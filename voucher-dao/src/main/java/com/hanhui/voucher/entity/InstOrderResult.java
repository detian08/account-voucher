package com.hanhui.voucher.entity;

import com.hanhui.voucher.common.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * @描述: 对账文件
 * @作者: aizen.stark
 * @创建时间: 2017/5/22
 * @版本: 1.0
 */
public class InstOrderResult extends BaseEntity {

    private long resultId;
    private String batchResultId; //结果批次
    private long instOrderId; // 凭证订单ID
    private String instOrderNo; // 凭证唯一识别
    private String orgiInstOrderNo; //手机贷原始凭证号
    private String bankInstOrderNo;// 银行原始凭证号
    private String productCode; //交易类型
    private BigDecimal realAmount; //金额
    private String realCurrency; //交易币种
    private String compareStatus; //对账状态
    private String memo;//备注
    private String operateStatus; //操作状态
    private String diffMsg; //差异信息
    private String extension;

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public String getBatchResultId() {
        return batchResultId;
    }

    public void setBatchResultId(String batchResultId) {
        this.batchResultId = batchResultId;
    }

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

    public String getBankInstOrderNo() {
        return bankInstOrderNo;
    }

    public void setBankInstOrderNo(String bankInstOrderNo) {
        this.bankInstOrderNo = bankInstOrderNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public String getRealCurrency() {
        return realCurrency;
    }

    public void setRealCurrency(String realCurrency) {
        this.realCurrency = realCurrency;
    }

    public String getCompareStatus() {
        return compareStatus;
    }

    public void setCompareStatus(String compareStatus) {
        this.compareStatus = compareStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getDiffMsg() {
        return diffMsg;
    }

    public void setDiffMsg(String diffMsg) {
        this.diffMsg = diffMsg;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
