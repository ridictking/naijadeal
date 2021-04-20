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
public class OfferingCharacteristicsData implements Serializable {

    @Expose
    @NotNull(message = "action must be one of A, D or M (add, delete or modify)")
    private String action;
    private String instanceId;
    @NotNull(message = "name of characteristic to be set")
    private String name;
    @NotNull(message = "value of named-characteristic to be applied")
    private String value;
    private String oldValue;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    @Override
    public String toString() {
        return "OfferingCharacteristicsData{" + "action=" + action + ", instanceId=" + instanceId + ", name=" + name + ", value=" + value + ", oldValue=" + oldValue + '}';
    }
}
