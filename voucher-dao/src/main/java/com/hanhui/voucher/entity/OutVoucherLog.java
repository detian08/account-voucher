package com.hanhui.voucher.entity;

import com.hanhui.voucher.common.entity.BaseEntity;

import java.util.Date;

/**
 * @描述: 凭证系统外部交互日志
 * @作者: aizen.stark
 * @创建时间: 2017/5/22
 * @版本: 1.0
 */
public class OutVoucherLog extends BaseEntity {
    private long logId;
    private String reqNo;
    private String reqInfo;
    private String actionCode;
    private String actionName;

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getReqInfo() {
        return reqInfo;
    }

    public void setReqInfo(String reqInfo) {
        this.reqInfo = reqInfo;
    }


}
