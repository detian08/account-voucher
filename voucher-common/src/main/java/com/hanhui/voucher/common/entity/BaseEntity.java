package com.hanhui.voucher.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @描述: 基础实体类，包含各实体公用属性 .
 * @作者:  .
 * @创建时间:
 * @版本: 1.0 .
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;



    /*创建时间*/
    private Date gmtCreate;
    /*更新时间*/
    private Date gmtModified;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
