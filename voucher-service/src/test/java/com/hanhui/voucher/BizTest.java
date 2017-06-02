package com.hanhui.voucher;

import com.hanhui.voucher.biz.account.AccountApplyBiz;
import com.hanhui.voucher.biz.account.OpenAccountBiz;
import com.hanhui.voucher.common.enums.BizType;
import com.hanhui.voucher.common.enums.ProductCode;
import com.hanhui.voucher.dto.OpenAccountResult;
import com.hanhui.voucher.entity.InstOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @描述: 基础实体类，包含各实体公用属性 .
 * @作者: aizen.stark
 * @创建时间: 2017/5/19
 * @版本: 1.0
 */

public class BizTest {

    static Logger logger = LoggerFactory.getLogger(BizTest.class);


    public static String ACCOUNT_NO = "6228480402564890018";

    public static String USER_NAME = "100008265";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/voucher-service-context.xml");
        apply(ctx);
        //openAccountTest(ctx);
    }

    //開戶
    public static void openAccountTest(ClassPathXmlApplicationContext ctx) {
        OpenAccountBiz openAccountBiz = (OpenAccountBiz) ctx.getBean("openAccountBiz");
        System.out.println("openAccountBiz----------------------->" + openAccountBiz);
        OpenAccountResult openAccountResult = new OpenAccountResult();
        openAccountResult.setEacctNo(ACCOUNT_NO);
        openAccountResult.setCoopCustNo(USER_NAME);
        openAccountResult.setReqNo(System.nanoTime() + "");
        boolean flag = openAccountBiz.openAccount(openAccountResult);
        logger.info("-------------------------" + flag + "-------------------------");

    }

    //金额测试
    public static void apply(ClassPathXmlApplicationContext ctx) {
        AccountApplyBiz accountApplyBiz = (AccountApplyBiz) ctx.getBean("accountApplyBiz");
        //构建订单
        //授信
        InstOrder shouxin = buildInstOrder(ProductCode.CREDIT.getCode(), BizType.FUNDOUT.getCode(), new BigDecimal(1000));
        //消费
        InstOrder xioafei = buildInstOrder(ProductCode.TRANSACTION.getCode(), BizType.FUNDIN.getCode(), new BigDecimal(500));
        //还款
        InstOrder huankuan = buildInstOrder(ProductCode.REPAYMENT.getCode(), BizType.FUNDIN.getCode(), new BigDecimal(500));
        //退款
        InstOrder tuikuan = buildInstOrder(ProductCode.REFUND.getCode(), BizType.FUNDIN.getCode(), new BigDecimal(200));

        boolean flag = accountApplyBiz.accountingApply(xioafei);
    }


    //构造实体
    public static InstOrder buildInstOrder(String productCode, String bizType, BigDecimal money) {
        InstOrder instOrder = new InstOrder();
        instOrder.setInstOrderNo(System.nanoTime()+""); //对应分录凭证号
        instOrder.setOrgiInstOrderNo(UUID.randomUUID().toString());
        instOrder.setCardNo(ACCOUNT_NO);
        instOrder.setInstCode("shoujidai");
        instOrder.setOrderType("");
        instOrder.setCurrency("RMB");
        instOrder.setAmount(money);
        instOrder.setBizType(bizType);
        instOrder.setProductCode(productCode);
        instOrder.setGmtCreate(new Date());
        return instOrder;
    }


}
