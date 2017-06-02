package com.hanhui.voucher.entity;

import com.hanhui.voucher.common.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @描述: 交互凭证
 * @作者: aizen.stark
 * @创建时间: 2017/5/22
 * @版本: 1.0
 */
public class InstOrder extends BaseEntity{

    private long instOrderId;
    private String instOrderNo; //唯一识别
    private String orgiInstOrderNo; // 手机贷唯一识别
    private String cardNo; // 银行卡号
    private String instCode; //机构代码
    private String orderType; //订单类型
    private String currency;  //币种
    private BigDecimal amount; //金额
    private String bizType;//入账方式
    private String productCode;//交易类型
    private String fundChannelCode; //渠道代码
    private String fundChannelApi; //渠道API
    private String status; //状态
    private Date gmtCreate;
    private Date gmtModified;
    private String memo; //备注


    public long getInstOrderId() {
        return instOrderId;
    }

    public void setInstOrderId(long instOrderId) {
        this.instOrderId = instOrderId;
    }

    public String getInstOrderNo() {
        return instOrderNo;
    }

    public void setInstOrderNo(String instOrderNo) {
        this.instOrderNo = instOrderNo;
    }

    public String getOrgiInstOrderNo() {
        return orgiInstOrderNo;
    }

    public void setOrgiInstOrderNo(String orgiInstOrderNo) {
        this.orgiInstOrderNo = orgiInstOrderNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getFundChannelCode() {
        return fundChannelCode;
    }

    public void setFundChannelCode(String fundChannelCode) {
        this.fundChannelCode = fundChannelCode;
    }

    public String getFundChannelApi() {
        return fundChannelApi;
    }

    public void setFundChannelApi(String fundChannelApi) {
        this.fundChannelApi = fundChannelApi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Date getGmtCreate() {
        return gmtCreate;
    }

    @Override
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public Date getGmtModified() {
        return gmtModified;
    }

    @Override
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
