/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor.akinola
 */
public class OfferingProductData implements Serializable {

    private String id;
    private String action;
    private String instanceId;
    private ArrayList<ProductCharacteristicsData> productCharacteristics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public ArrayList<ProductCharacteristicsData> getProductCharacteristics() {
        return productCharacteristics;
    }

    public void setProductCharacteristics(ArrayList<ProductCharacteristicsData> productCharacteristics) {
        this.productCharacteristics = productCharacteristics;
    }
}
