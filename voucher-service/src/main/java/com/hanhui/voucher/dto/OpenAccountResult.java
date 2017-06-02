package com.hanhui.voucher.dto;

/**
 * @描述: 开户结果
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
public class OpenAccountResult extends BaseDto {

    private String coopCustNo;//合作方客户账号
    private String custName;//姓名
    private String idNo;  //身份证号
    private String eacctNo;  //E账户主账户
    private String subAcctNo;//XXePay子账户
    private String acctOpenResult;  //平台账户开户结果
    private String acctOpenDesc; //平台账户开户结果描述

    public String getCoopCustNo() {
        return coopCustNo;
    }

    public void setCoopCustNo(String coopCustNo) {
        this.coopCustNo = coopCustNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEacctNo() {
        return eacctNo;
    }

    public void setEacctNo(String eacctNo) {
        this.eacctNo = eacctNo;
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getAcctOpenResult() {
        return acctOpenResult;
    }

    public void setAcctOpenResult(String acctOpenResult) {
        this.acctOpenResult = acctOpenResult;
    }

    public String getAcctOpenDesc() {
        return acctOpenDesc;
    }

    public void setAcctOpenDesc(String acctOpenDesc) {
        this.acctOpenDesc = acctOpenDesc;
    }
}
