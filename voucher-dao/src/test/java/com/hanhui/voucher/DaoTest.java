package com.hanhui.voucher;

import com.hanhui.voucher.dao.InLogDao;
import com.hanhui.voucher.dao.InstOrderDao;
import com.hanhui.voucher.dao.OutLogDao;
import com.hanhui.voucher.entity.InVoucherLog;
import com.hanhui.voucher.entity.InstOrder;
import com.hanhui.voucher.entity.OutVoucherLog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by aizen.stark on 2017/5/18.
 */
public class DaoTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/voucher-dao-context.xml");
//        InstOrderDao instOrderDao = (InstOrderDao) ctx.getBean("instOrderDao");
//        System.out.println(instOrderDao);
//
//        InstOrder instOrder = new InstOrder();
//        instOrder.setInstOrderNo("");
//        instOrder.setOrgiInstOrderNo("");
//        instOrder.setCardNo("xxxx");
//        instOrder.setOrderType("");
//        instOrder.setCurrency("CNM");
//        instOrder.setAmount(new BigDecimal(9999));
//        instOrder.setProductCode("xxx");
//        instOrder.setStatus("1");
//
//
//        instOrderDao.insert(instOrder);


        InLogDao inLogDao = (InLogDao) ctx.getBean("inLogDao");
        OutLogDao outLogDao = (OutLogDao) ctx.getBean("outLogDao");


        InVoucherLog inVoucherLog = new InVoucherLog();
        inVoucherLog.setReqNo(System.nanoTime() + "");
        inVoucherLog.setReqInfo("hello");
        inVoucherLog.setGmtCreate(new Date());
        inVoucherLog.setGmtModified(new Date());
        inVoucherLog.setActionCode("GR");
        inVoucherLog.setActionName("测试");

        inLogDao.insert(inVoucherLog);


        OutVoucherLog outVoucherLog = new OutVoucherLog();
        outVoucherLog.setReqNo(System.nanoTime() + "");
        outVoucherLog.setReqInfo("hello");
        outVoucherLog.setGmtCreate(new Date());
        outVoucherLog.setGmtModified(new Date());
        outVoucherLog.setActionCode("GR");
        outVoucherLog.setActionName("测试");

        outLogDao.insert(outVoucherLog);


    }


}
