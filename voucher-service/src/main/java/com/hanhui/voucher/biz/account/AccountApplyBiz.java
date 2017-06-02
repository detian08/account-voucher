package com.hanhui.voucher.biz.account;

import com.alibaba.druid.util.StringUtils;
import com.hanhui.act.accounting.api.AccountService;
import com.hanhui.act.accounting.api.AccountingFacade;
import com.hanhui.act.accounting.api.enums.CrDr;
import com.hanhui.act.accounting.api.enums.MainReturn;
import com.hanhui.act.accounting.api.enums.ReturnCode;
import com.hanhui.act.accounting.api.models.Entry;
import com.hanhui.act.accounting.api.requests.AccountingRequest;
import com.hanhui.act.accounting.api.responses.AccountingResponse;
import com.hanhui.act.accounting.api.responses.GetAccountByAccountNoResp;
import com.hanhui.common.domain.OperationEnvironment;
import com.hanhui.common.util.money.Money;
import com.hanhui.voucher.common.enums.BizType;
import com.hanhui.voucher.common.enums.ProductCode;
import com.hanhui.voucher.common.enums.SourceCode;
import com.hanhui.voucher.entity.InstOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述: 交易类
 * @作者: aizen.stark
 * @创建时间: 2017/5/25
 * @版本: 1.0
 */
@Service("accountApplyBiz")
public class AccountApplyBiz {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountingFacade accountingFacade;


    /**
     * @param instOrder
     * @return
     */
    public boolean accountingApply(InstOrder instOrder) {
        // 记账申请
        AccountingResponse response = accountingFacade.apply(createRequest(instOrder), null);
        logger.info("response.getMainReturnMessage()---------------------------------------------->" + response.getMainReturnMessage()
        +"--"+response.getUnityResultMessage());

        if (response.getMainReturnCode().equals(MainReturn.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    /**
     * @param instOrder
     * @return
     */
    private AccountingRequest createRequest(InstOrder instOrder) {
        AccountingRequest req = new AccountingRequest();
        req.setAppId(SourceCode.VOUCHER.getCode());
        req.setOperatorId("SYS");
        req.setTransactionNo(String.valueOf(System.currentTimeMillis()));   // 事务号
        // 产生分录
        req.setEntries(generateEntry(instOrder, getAccountNo(instOrder.getCardNo())));
        return req;
    }

    /**
     * 获取虚拟账号
     *
     * @param cardNo 银行卡号
     * @return
     */
    private String getAccountNo(String cardNo) {
        GetAccountByAccountNoResp resp = accountService.getAccountByCardNo(cardNo, generateEnvironment());
        if (resp.getCode() == ReturnCode.SUCCESS.getCode()) {
            return resp.getAccount().getAccountNo();
        }
        return null;
    }

    /**
     * 生成分录
     */
    private List<Entry> generateEntry(InstOrder instOrder, String accountNo) {
        List<Entry> entryList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            Entry entry = null;
            //还款
            if (StringUtils.equals(instOrder.getBizType(), BizType.FUNDIN.getCode())) {
                entry = fundin(instOrder, i, accountNo);
            }
            //退款
            if (StringUtils.equals(instOrder.getBizType(), BizType.REFUND.getCode())) {
                entry = refund(instOrder, i, accountNo);
            }
            //授信
            if (StringUtils.equals(instOrder.getBizType(), BizType.FUNDOUT.getCode())) {
                entry = fundout(instOrder, i, accountNo);
            }
            entryList.add(entry);
        }
        return entryList;
    }


    /**
     * 生成还款分录
     *
     * @param instOrder
     * @param i
     * @param accountNo
     * @return
     */
    private Entry fundin(InstOrder instOrder, int i, String accountNo) {
        Entry entry = null;
        //还款
        if (instOrder.getProductCode() != null && instOrder.getProductCode().equals(ProductCode.REPAYMENT.getCode())) {
            if (i % 2 == 0) {
                entry = createEntry(instOrder, accountNo, CrDr.DEBIT, "FR", String.valueOf(i));
            } else {
                entry = createEntry(instOrder, accountNo, CrDr.CREDIT, "CR", String.valueOf(i));
            }
        }
        //登账
        else if (instOrder.getProductCode() != null && instOrder.getProductCode().equals(ProductCode.ACCOUNTING.getCode())) {
            if (i % 2 == 0) {
                entry = createEntry(instOrder, accountNo, CrDr.CREDIT, "DR", String.valueOf(i));
            } else {
                entry = createEntry(instOrder, accountNo, CrDr.DEBIT, "CR", String.valueOf(i));
            }
        }
        //消费
        else {
            if (i % 2 == 0) {
                entry = createEntry(instOrder, accountNo, CrDr.CREDIT, "FR", String.valueOf(i));
            } else {
                entry = createEntry(instOrder, accountNo, CrDr.DEBIT, "CR", String.valueOf(i));
            }
        }
        return entry;
    }

    /**
     * 退款分录
     *
     * @param instOrder
     * @param i
     * @param accountNo
     * @return
     */
    private Entry refund(InstOrder instOrder, int i, String accountNo) {
        Entry entry = null;
        if (i % 2 == 0) {
            entry = createEntry(instOrder, accountNo, CrDr.DEBIT, "FR", String.valueOf(i));
        } else {
            entry = createEntry(instOrder, accountNo, CrDr.CREDIT, "CR", String.valueOf(i));
        }
        return entry;
    }

    /**
     * 登账分录
     *
     * @param instOrder
     * @param i
     * @param accountNo
     * @return
     */
    private Entry fundout(InstOrder instOrder, int i, String accountNo) {
        Entry entry = null;
        // 授信
        if (i % 2 == 0) {
            entry = createEntry(instOrder, "200100100128888888888800001", CrDr.DEBIT, "DR", String.valueOf(i));
        } else {
            entry = createEntry(instOrder, accountNo, CrDr.CREDIT, "CR", String.valueOf(i));
        }
        return entry;
    }


    /**
     * 创建分目录
     *
     * @param instOrder
     * @param accountNo
     * @param crDr
     * @param accountingRule
     * @param suffix
     * @return
     */

    private Entry createEntry(InstOrder instOrder,
                              String accountNo,
                              CrDr crDr,
                              String accountingRule,
                              String suffix) {
        Entry entry = new Entry();
        Money money = new Money(instOrder.getAmount());
        entry.setAmount(money); // 金额
        entry.setAccountNo(accountNo);  // 虚拟账户
        entry.setVoucherNo(instOrder.getInstOrderNo() + suffix); //凭证号
        entry.setSuiteNo(instOrder.getInstOrderNo()); // 套号
        entry.setCrDr(crDr);
        entry.setAccountingRule(accountingRule); // 记账规则
        return entry;
    }

    /**
     * 生成调用环境
     *
     * @return
     */

    private OperationEnvironment generateEnvironment() {
        OperationEnvironment environment = new OperationEnvironment();
        environment.setClientId("voucher");
        environment.setClientIp("");
        environment.setClientMac("");
        return environment;
    }

}
