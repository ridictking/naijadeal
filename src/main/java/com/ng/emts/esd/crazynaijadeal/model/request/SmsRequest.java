package com.ng.emts.esd.crazynaijadeal.model.request;

import java.util.UUID;

public class SmsRequest {
    private String msgType;
    private String msisdn;
    private String msg;
    private Integer shortCode;
    private String serviceid;
    private UUID correlationId;
    private int amount;


// Getter Methods

    public String getMsgType() {
        return msgType;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getShortCode() {
        return shortCode;
    }

    public String getServiceid() {
        return serviceid;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }
    public int getAmount() {
        return amount;
    }

    // Setter Methods

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setShortCode(Integer shortCode) {
        this.shortCode = shortCode;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
