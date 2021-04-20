package com.ng.emts.esd.crazynaijadeal.model.request;

import java.time.LocalDate;

public class AbstractRequest {
    private static final long serialVersionUID = 1L;

    private String transactionId;
    private String msisdn;
    private LocalDate transactionDate;
    private String clientResponse;
    private String coupon;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setClientResponse(String clientResponse) {
        this.clientResponse = clientResponse;
    }

    public String getClientResponse() {
        return clientResponse;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}
