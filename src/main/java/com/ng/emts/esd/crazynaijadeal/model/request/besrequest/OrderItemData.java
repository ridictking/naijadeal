/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor.akinola
 */
public class OrderItemData implements Serializable {

    private String id;
    @Expose
    private String businessAction;
    @Expose
    private ApplyObjectData applyObject;
    @Expose
    private ArrayList<OfferingData> offering;
    private PropertyData property;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessAction() {
        return businessAction;
    }

    public void setBusinessAction(String businessAction) {
        this.businessAction = businessAction;
    }

    public ApplyObjectData getApplyObject() {
        return applyObject;
    }

    public void setApplyObject(ApplyObjectData applyObject) {
        this.applyObject = applyObject;
    }

    public ArrayList<OfferingData> getOffering() {
        return offering;
    }

    public void setOffering(ArrayList<OfferingData> offering) {
        this.offering = offering;
    }

    public PropertyData getProperty() {
        return property;
    }

    public void setProperty(PropertyData property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "OrderItemData{" + "id=" + id + ", businessAction=" + businessAction + ", applyObject=" + applyObject + ", offering=" + offering + ", property=" + property + '}';
    }
}
