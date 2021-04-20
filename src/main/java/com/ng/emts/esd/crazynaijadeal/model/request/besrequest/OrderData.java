/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor.akinola
 */
public class OrderData implements Serializable {

    @Expose
    @SerializedName("busiOwnership")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BusinessOwnershipData busiOwnership;
    @Expose
    @SerializedName("orderBasicInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrderBasicInfoData orderBasicInfo;
    @Expose
    private ArrayList<OrderItemData> orderItem;
    @Expose
    @SerializedName("contactPersonInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactPersonInfoData contactPersonInfo;
    @Expose
    @SerializedName("invoiceInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private InvoiceInfoData invoiceInfo;
    @Expose
    @SerializedName("businessFee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<BusinessFeeFeeItemData> businessFee;
    @Expose
    @SerializedName("paymentInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaymentInfoData paymentInfo;

    public BusinessOwnershipData getBusiOwnership() {
        return busiOwnership;
    }

    public void setBusiOwnership(BusinessOwnershipData busiOwnership) {
        this.busiOwnership = busiOwnership;
    }

    public OrderBasicInfoData getOrderBasicInfo() {
        return orderBasicInfo;
    }

    public void setOrderBasicInfo(OrderBasicInfoData orderBasicInfo) {
        this.orderBasicInfo = orderBasicInfo;
    }

    public ArrayList<OrderItemData> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(ArrayList<OrderItemData> orderItem) {
        this.orderItem = orderItem;
    }

    public ContactPersonInfoData getContactPersonInfo() {
        return contactPersonInfo;
    }

    public void setContactPersonInfo(ContactPersonInfoData contactPersonInfo) {
        this.contactPersonInfo = contactPersonInfo;
    }

    public InvoiceInfoData getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(InvoiceInfoData invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    public ArrayList<BusinessFeeFeeItemData> getBusinessFee() {
        return businessFee;
    }

    public void setBusinessFee(ArrayList<BusinessFeeFeeItemData> businessFee) {
        this.businessFee = businessFee;
    }

    public PaymentInfoData getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoData paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "OrderData{" + "busiOwnership=" + busiOwnership + ", orderBasicInfo=" + orderBasicInfo + ", orderItem=" + orderItem + ", contactPersonInfo=" + contactPersonInfo + ", invoiceInfo=" + invoiceInfo + ", businessFee=" + businessFee + ", paymentInfo=" + paymentInfo + '}';
    }
}
