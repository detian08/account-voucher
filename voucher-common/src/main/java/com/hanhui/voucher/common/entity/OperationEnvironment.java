package com.hanhui.voucher.common.entity;

/**
 * @描述:
 * @作者: aizen.stark
 * @创建时间: 2017/5/24
 * @版本: 1.0
 */
public class OperationEnvironment {

    private static final long serialVersionUID = -7606172336527767001L;
    private String clientIp;
    private String clientMac;
    private String clientId;
    private String serverIp;
    private String serverName;
    private Extension extension;

    public OperationEnvironment() {
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientMac() {
        return this.clientMac;
    }

    public void setClientMac(String clientMac) {
        this.clientMac = clientMac;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getServerIp() {
        return this.serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Extension getExtension() {
        return this.extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }
}
