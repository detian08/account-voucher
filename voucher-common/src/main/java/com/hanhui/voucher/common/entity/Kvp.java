package com.hanhui.voucher.common.entity;

import java.io.Serializable;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
public class Kvp implements Serializable{

    private static final long serialVersionUID = -1192195739822408992L;

    private String key;
    private String value;

    public Kvp() {
    }

    public Kvp(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
