package com.ng.emts.esd.crazynaijadeal.model.request.dataobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CRAZY_NAIJA_DEAL")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrazyNaijaDealRequest {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String transactionId;
    private String msisdn;
    private LocalDateTime transactionDate;
    private String clientResponse;
    private String giftCode;
    private int singleRecharge;
    private int subcosid;
    private int cnt;
    private int hr;
    public CrazyNaijaDealRequest() {
    }

    public CrazyNaijaDealRequest(String transactionId,
                                 String msisdn,
                                 LocalDateTime transactionDate,
                                 int singleRecharge,
                                 String clientResponse,
                                 String giftCode,
                                 int subcosid,
                                 int cnt, int hr) {
        this.transactionId = transactionId;
        this.msisdn = msisdn;
        this.transactionDate = transactionDate;
        this.singleRecharge = singleRecharge;
        this.clientResponse = clientResponse;
        this.giftCode = giftCode;
        this.subcosid = subcosid;
        this.cnt = cnt;
        this.hr = hr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setClientResponse(String clientResponse) {
        this.clientResponse = clientResponse;
    }

    public String getClientResponse() {
        return clientResponse;
    }

    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String coupon) {
        this.giftCode = coupon;
    }

    public int getSingleRecharge() {
        return singleRecharge;
    }

    public void setSingleRecharge(int singleRecharge) {
        this.singleRecharge = singleRecharge;
    }

    public int getSubcosid() {
        return subcosid;
    }

    public void setSubcosid(int subcosid) {
        this.subcosid = subcosid;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }
}
