package com.hanhui.voucher.dto;

/**
 * @描述: 开户请求
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
public class OpenAccount extends BaseDto {

    private String coopCustNo; //合作方客户账号 唯一标识
    private String productCd; //产品参数
    private String custName; //姓名
    private String idNo; //身份证号
    private String expDay; //证件到期日
    private String mobllePhone; //手机号
    private String bindCardNo; //绑定银行卡号
    private String reservedPhone; //银行卡预留手机号
    private String email; //邮箱
    private String homeAddr; //家庭住址
    private String occupation; //职业

    public String getCoopCustNo() {
        return coopCustNo;
    }

    public void setCoopCustNo(String coopCustNo) {
        this.coopCustNo = coopCustNo;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
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

    public String getExpDay() {
        return expDay;
    }

    public void setExpDay(String expDay) {
        this.expDay = expDay;
    }

    public String getMobllePhone() {
        return mobllePhone;
    }

    public void setMobllePhone(String mobllePhone) {
        this.mobllePhone = mobllePhone;
    }

    public String getBindCardNo() {
        return bindCardNo;
    }

    public void setBindCardNo(String bindCardNo) {
        this.bindCardNo = bindCardNo;
    }

    public String getReservedPhone() {
        return reservedPhone;
    }

    public void setReservedPhone(String reservedPhone) {
        this.reservedPhone = reservedPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
