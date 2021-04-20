/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author victor.akinola
 */
public class BusinessOwnershipData implements Serializable {

    @Expose
    @NotNull
    private String beId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String beCode;

    public String getBeId() {
        return beId;
    }

    public void setBeId(String beId) {
        this.beId = beId;
    }

    public String getBeCode() {
        return beCode;
    }

    public void setBeCode(String beCode) {
        this.beCode = beCode;
    }

}
