/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor.akinola
 */
public class OfferingData implements Serializable {

    @Expose
    @NotNull(message = "offering ID cannot be null")
    private String id;
    private String instanceId;
    @Expose
    @NotNull(message = "action must be one of A, D or M (add, delete or modify)")
    private String action;
    @Expose
    private ArrayList<OfferingCharacteristicsData> offeringCharacteristics;
    private ArrayList<OfferingProductData> product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ArrayList<OfferingCharacteristicsData> getOfferingCharacteristics() {
        return offeringCharacteristics;
    }

    public void setOfferingCharacteristics(ArrayList<OfferingCharacteristicsData> offeringCharacteristics) {
        this.offeringCharacteristics = offeringCharacteristics;
    }

    public ArrayList<OfferingProductData> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<OfferingProductData> product) {
        this.product = product;
    }

    public OfferingData() {
    }

    public OfferingData(String id, String instanceId, String action) {
        this.id = id;
        this.instanceId = instanceId;
        this.action = action;
    }

    @Override
    public String toString() {
        return "OfferingData{" + "id=" + id + ", instanceId=" + instanceId + ", action=" + action + ", offeringCharacteristics=" + offeringCharacteristics + ", product=" + product + '}';
    }
}
