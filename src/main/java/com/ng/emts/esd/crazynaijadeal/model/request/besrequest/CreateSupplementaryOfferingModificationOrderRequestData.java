/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author victor.akinola
 */
public class CreateSupplementaryOfferingModificationOrderRequestData implements Serializable {

    @Expose
    @NotNull(message = "order cannot be null")
    private OrderData order;

    @Expose
    @NotNull(message = "the field \"appName\" is not nillable")
    private String appName;
    private String srcIpAddress;
    private String reason;

    public OrderData getOrder() {
        return order;
    }

    public void setOrder(OrderData order) {
        this.order = order;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSrcIpAddress() {
        return srcIpAddress;
    }

    public void setSrcIpAddress(String srcIpAddress) {
        this.srcIpAddress = srcIpAddress;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "CreateSupplementaryOfferingModificationOrderRequestData{" + "order=" + order + '}';
    }
}
