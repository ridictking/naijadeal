package com.ng.emts.esd.crazynaijadeal.model.request.dataobjects;

import javax.persistence.*;

@Entity
@Table(name = "CRAZY_CODES")
public class CrazyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String crazyCode;
    private String url;
    @Column(nullable = true)
    private String msisdn;
    @Column(nullable = true)
    private String cbsTransactionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrazyCode() {
        return crazyCode;
    }

    public void setCrazyCode(String crazyCode) {
        this.crazyCode = crazyCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getCbsTransactionId() {
        return cbsTransactionId;
    }

    public void setCbsTransactionId(String cbsTransactionId) {
        this.cbsTransactionId = cbsTransactionId;
    }
}
