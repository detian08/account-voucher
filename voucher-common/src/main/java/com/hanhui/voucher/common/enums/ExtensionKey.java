package com.hanhui.voucher.common.enums;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
public enum ExtensionKey {

    SIGN_NO("signNo"),
    ACCOUNT_NAME("accountName"),
    MEMBER_ID("memberId"),;

    ExtensionKey(String key) {
        this.key = key;
    }

    public final String key;
}
