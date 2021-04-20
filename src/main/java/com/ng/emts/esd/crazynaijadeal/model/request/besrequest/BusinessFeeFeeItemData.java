/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor.akinola
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessFeeFeeItemData implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String chargeCode;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String unitPrice;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer quantity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BusinessFeeFeeItemTaxData tax;
    private String discountAmount;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String waiveAmount;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String currency;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<PropertyData> property;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BusinessFeeFeeItemTaxData getTax() {
        return tax;
    }

    public void setTax(BusinessFeeFeeItemTaxData tax) {
        this.tax = tax;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getWaiveAmount() {
        return waiveAmount;
    }

    public void setWaiveAmount(String waiveAmount) {
        this.waiveAmount = waiveAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ArrayList<PropertyData> getProperty() {
        return property;
    }

    public void setProperty(ArrayList<PropertyData> property) {
        this.property = property;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
