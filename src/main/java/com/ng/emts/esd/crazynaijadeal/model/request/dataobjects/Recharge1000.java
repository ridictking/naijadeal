package com.ng.emts.esd.crazynaijadeal.model.request.dataobjects;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "RECHARGE_1K_ABOVE")
public class Recharge1000 implements Serializable {
    private LocalDate refDate;
    private int hr;
    private String msisdn;
    private int cardvalue;
    private int subcosid;
    private int cnt;
    @Id
    private Long subId;


    public LocalDate getRefDate() {
        return refDate;
    }

    public void setRefDate(LocalDate refDate) {
        this.refDate = refDate;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getCardvalue() {
        return cardvalue;
    }

    public void setCardvalue(int cardvalue) {
        this.cardvalue = cardvalue;
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
}
