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
public class InvoiceInfoData implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String contentType;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String headType;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String headName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String invoiceType;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String remark;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHeadType() {
        return headType;
    }

    public void setHeadType(String headType) {
        this.headType = headType;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
