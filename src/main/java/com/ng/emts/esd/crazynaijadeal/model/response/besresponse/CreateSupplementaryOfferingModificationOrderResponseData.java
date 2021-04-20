/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.response.besresponse;



import com.ng.emts.esd.crazynaijadeal.model.request.besrequest.OrderData;

import java.io.Serializable;

/**
 *
 * @author victor.akinola
 */
public class CreateSupplementaryOfferingModificationOrderResponseData extends ResponseHeaderData implements Serializable {

    public CreateSupplementaryOfferingModificationOrderResponseData() {
    }

    public CreateSupplementaryOfferingModificationOrderResponseData(String returnCode, String returnMsg) {
        super(returnCode, returnMsg);
    }

    private String modificationType;
    private OrderData order;

    public String getModificationType() {
        return modificationType;
    }

    public void setModificationType(String modificationType) {
        this.modificationType = modificationType;
    }

    public OrderData getOrder() {
        return order;
    }

    public void setOrder(OrderData order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "CreateSupplementaryOfferingModificationOrderResponseData{" +
                "modificationType='" + modificationType + '\'' +
                ", order=" + order +
                '}';
    }
}
