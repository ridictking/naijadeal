package com.ng.emts.esd.crazynaijadeal.model.request.dataobjects;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "GIFT_ACCESS_CODE")
public class GiftAccessCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String giftCode;
    @Column(unique = true, nullable = true)
    private String crazyGiftCode;
    @Column(nullable = false)
    private String dataType;
    private LocalDateTime startDate;
    private LocalDateTime giftCodeExpiry;
    private LocalDateTime dateUsed;
    private boolean used;
    private boolean expired;
    private String msisdn;
    private String url;
    private String CbsTransactionReference;

    public GiftAccessCode() {
    }

    public GiftAccessCode(String giftCode, String dataType) {
        this.giftCode = giftCode;
        this.dataType = dataType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String coupon) {
        this.giftCode = coupon;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCrazyGiftCode() {
        return crazyGiftCode;
    }

    public void setCrazyGiftCode(String crazyGiftCode) {
        this.crazyGiftCode = crazyGiftCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getGiftCodeExpiry() {
        return giftCodeExpiry;
    }

    public void setGiftCodeExpiry(LocalDateTime giftCodeExpiry) {
        this.giftCodeExpiry = giftCodeExpiry;
    }

    public LocalDateTime getDateUsed() {
        return dateUsed;
    }

    public void setDateUsed(LocalDateTime dateUsed) {
        this.dateUsed = dateUsed;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getCbsTransactionReference() {
        return CbsTransactionReference;
    }

    public void setCbsTransactionReference(String cbsTransactionReference) {
        CbsTransactionReference = cbsTransactionReference;
    }
}
