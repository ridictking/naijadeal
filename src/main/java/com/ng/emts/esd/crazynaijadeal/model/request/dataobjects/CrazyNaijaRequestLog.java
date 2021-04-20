package com.ng.emts.esd.crazynaijadeal.model.request.dataobjects;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class CrazyNaijaRequestLog {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "requestlog_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;
    private String msisdn;
    private String message;
    private String shortCode;
    private LocalDateTime requestInTime;
    private LocalDateTime requestOutTime;
//    private String cbsTransactionReference;
//    private String giftCode;
//    private String crazyCode;

    public CrazyNaijaRequestLog(String msisdn, String message, String shortCode, LocalDateTime requestInTime, LocalDateTime requestOutTime) {
        this.msisdn = msisdn;
        this.message = message;
        this.shortCode = shortCode;
        this.requestInTime = requestInTime;
        this.requestOutTime = requestOutTime;
    }

    public CrazyNaijaRequestLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public LocalDateTime getRequestInTime() {
        return requestInTime;
    }

    public void setRequestInTime(LocalDateTime requestInTime) {
        this.requestInTime = requestInTime;
    }

    public LocalDateTime getRequestOutTime() {
        return requestOutTime;
    }

    public void setRequestOutTime(LocalDateTime requestOutTime) {
        this.requestOutTime = requestOutTime;
    }
//
//    public String getCbsTransactionReference() {
//        return cbsTransactionReference;
//    }
//
//    public void setCbsTransactionReference(String cbsTransactionReference) {
//        this.cbsTransactionReference = cbsTransactionReference;
//    }
//
//    public String getGiftCode() {
//        return giftCode;
//    }
//
//    public void setGiftCode(String giftCode) {
//        this.giftCode = giftCode;
//    }
//
//    public String getCrazyCode() {
//        return crazyCode;
//    }
//
//    public void setCrazyCode(String crazyCode) {
//        this.crazyCode = crazyCode;
//    }
}
