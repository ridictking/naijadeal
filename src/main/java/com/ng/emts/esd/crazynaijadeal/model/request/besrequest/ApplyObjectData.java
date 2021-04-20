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
public class ApplyObjectData implements Serializable {

    private String type;
    private String id;
    @Expose
    @NotNull(message = "serviceNumber (msisdn format: 809*******) cannot be null")
    private String serviceNumber;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public ApplyObjectData() {
    }

    public ApplyObjectData(String type, String id, String serviceNumber) {
        this.type = type;
        this.id = id;
        this.serviceNumber = serviceNumber;
    }

    @Override
    public String toString() {
        return "ApplyObjectData{" + "type=" + type + ", id=" + id + ", serviceNumber=" + serviceNumber + '}';
    }
}
