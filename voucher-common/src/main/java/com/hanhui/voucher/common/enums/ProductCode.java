package com.hanhui.voucher.common.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
public enum ProductCode {

    ACCOUNTING("accounting", "登账"),
    CREDIT("credit_extension", "授信"),
    TRANSACTION("transaction", "交易/消费"),
    REFUND("refund", "退款"),
    REPAYMENT("repayment", "还款");


    /** 代码 */
    private final String code;
    /** 信息 */
    private final String message;

    /**
     * 构造
     * @param code
     * @param message
     */
    ProductCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据代码获取ENUM
     * @param code
     * @return
     */
    public static ProductCode getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }

        for (ProductCode mode : values()) {
            if (StringUtils.equals(mode.getCode(), code)) {
                return mode;
            }
        }

        return null;
    }

    /**
     * 根据枚举名称获取ENUM
     * @param name
     * @return
     */
    public static ProductCode getByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (ProductCode mode : values()) {
            if (StringUtils.equals(mode.name(), name)) {
                return mode;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
