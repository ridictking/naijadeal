/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 *
 * @author victor.akinola
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentInfoData implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String method;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String amount;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String currency;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String paymentDate;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String remark;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
