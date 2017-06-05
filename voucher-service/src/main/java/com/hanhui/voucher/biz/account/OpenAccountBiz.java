package com.hanhui.voucher.biz.account;

import com.hanhui.act.accounting.api.AccountService;
import com.hanhui.act.accounting.api.enums.AccountAttribute;
import com.hanhui.act.accounting.api.enums.ActivateStatus;
import com.hanhui.act.accounting.api.enums.CurrencyEnum;
import com.hanhui.act.accounting.api.enums.ReturnCode;
import com.hanhui.act.accounting.api.requests.InsertOuterAccountReq;
import com.hanhui.act.accounting.api.responses.GetAccountByAccountNoResp;
import com.hanhui.act.accounting.api.responses.InsertOuterAccountResp;
import com.hanhui.common.domain.OperationEnvironment;
import com.hanhui.voucher.common.constants.VoucherConstants;
import com.hanhui.voucher.dto.OpenAccountResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @描述: 开户
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
@Service("openAccountBiz")
public class OpenAccountBiz {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    /**
     * 开户
     *
     * @return
     */
    public boolean openAccount(OpenAccountResult openAccountResult) {
        String cardNo = openAccountResult.getEacctNo();//账户
        String memberId = openAccountResult.getCoopCustNo(); //合作方客户账号
        String reqNo = openAccountResult.getReqNo(); //请求流水号
        OperationEnvironment env = generateEnvironment();//环境变量
        GetAccountByAccountNoResp resp = accountService.getAccountByCardNo(cardNo, env);
        if (resp == null) {
            return false;
        } else if (resp.getCode() == ReturnCode.RECORD_NOT_FOUND.getCode() && resp.getAccount() == null) {
            // 创建外部户请求
            InsertOuterAccountReq accountReq = buildInsertOuterAccountReq(cardNo, memberId, reqNo);
            // 开户请求
            InsertOuterAccountResp accountResp = accountService.insertOuterAccount(accountReq, env);
            logger.info("-----------message----------->" + accountResp.getMessage());
            if (accountResp != null && accountResp.getCode() == ReturnCode.SUCCESS.getCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 生成开户请求
     *
     * @param cardNo
     * @param memberId
     * @param reqNo
     * @return
     */
    private InsertOuterAccountReq buildInsertOuterAccountReq(String cardNo,
                                                             String memberId,
                                                             String reqNo) {
        InsertOuterAccountReq accountReq = new InsertOuterAccountReq();
        accountReq.setCardNo(cardNo);
        accountReq.setAccountName(VoucherConstants.BANK_SHANGAHI);
        accountReq.setActivateStatus(ActivateStatus.ACTIVATED); // 激活状态
        accountReq.setAccountAttribute(AccountAttribute.PERSONAL); // 对私
        accountReq.setMemberId(memberId); // 会员ID
        accountReq.setAccountType(901);
        accountReq.setCurrencys(CurrencyEnum.CNY);  // 币种
        accountReq.setRequestNo(reqNo);   // 请求号
        return accountReq;
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






