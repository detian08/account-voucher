package com.hanhui.voucher.facade.service;

import com.hanhui.voucher.dto.OpenAccount;

/**
 * Created by aizen.stark on 2017/6/1.
 */
public interface OpenAccountService {

    /**
     * 开户接口 暴露参数依照手机贷与银行方面
     *
     * @param openAccount
     * @return
     */
    String openAccount(OpenAccount openAccount);
}
