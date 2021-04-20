package com.ng.emts.esd.crazynaijadeal.model.request;

import java.io.Serializable;
import java.sql.Timestamp;

public class IPCCRequestBody implements Serializable {
    private String requestString;
    private String msisdn;
    private String shortCode;
    private String serviceId;
    private String vasId;
    private Timestamp subscriptionDate;

    public String getRequestString() {
        return requestString;
    }

    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Timestamp getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Timestamp subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getVasId() {
        return vasId;
    }

    public void setVasId(String vasId) {
        this.vasId = vasId;
    }

    @Override
    public String toString() {
        return "IPCCRequestBody{" +
                "requestString='" + requestString + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", vasId='" + vasId + '\'' +
                '}';
    }
}
