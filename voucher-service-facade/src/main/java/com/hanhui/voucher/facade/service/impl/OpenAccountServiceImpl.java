package com.hanhui.voucher.facade.service.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.hanhui.voucher.biz.account.OpenAccountBiz;
import com.hanhui.voucher.common.enums.BizType;
import com.hanhui.voucher.dto.OpenAccount;
import com.hanhui.voucher.dto.OpenAccountResult;
import com.hanhui.voucher.facade.service.OpenAccountService;
import com.hanhui.voucher.service.InLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.LogUtils;

/**
 * 门面的实现
 *
 * @作者: aizen.stark
 * @创建时间: 2017/6/1
 * @版本: 1.0
 */
@Service("openAccountService")
public class OpenAccountServiceImpl implements OpenAccountService {

    @Autowired
    OpenAccountBiz openAccountBiz;
    @Autowired
    InLogService inLogService;

    public String openAccount(OpenAccount openAccount) {
        //构建唯一品凭证号 先模拟一个 实现方法稍后改变
        String reqNo = null;
        String reqInfo = null;
        //请求信息
        try {
            reqNo = String.valueOf(System.nanoTime());
            reqInfo = JSON.json(openAccount);
            //开户
            openAccountBiz.openAccount(buildOpenAccountResult());

        } catch (Exception e) {

        } finally {
            inLogService.insert(LogUtils.buildInVoucherLog(BizType.OPENACCOUNT.getCode(),
                    BizType.OPENACCOUNT.getMessage(), reqInfo, reqNo));
        }
        return null;

    }



    private OpenAccountResult buildOpenAccountResult() {
        OpenAccountResult openAccountResult = new OpenAccountResult();
        return openAccountResult;

    }


}
