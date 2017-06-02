package com.hanhui.voucher.facade.service.impl;

import com.hanhui.voucher.biz.account.OpenAccountBiz;
import com.hanhui.voucher.dto.OpenAccount;
import com.hanhui.voucher.dto.OpenAccountResult;
import com.hanhui.voucher.facade.service.OpenAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String openAccount(OpenAccount openAccount) {

        //1 发送到韩鑫平台 等待返回结果
        //send

        //2 收到返回结果 调用账户系统开户
        OpenAccountResult openAccountResult = null;
        openAccountBiz.openAccount(openAccountResult);


        //3 记录日志

        return null;

    }
}
