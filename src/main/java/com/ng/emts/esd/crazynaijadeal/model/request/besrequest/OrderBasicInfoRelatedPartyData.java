/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 *
 * @author victor.akinola
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderBasicInfoRelatedPartyData implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String roleType;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String roleId;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public OrderBasicInfoRelatedPartyData() {
    }

    public OrderBasicInfoRelatedPartyData(String roleType, String roleId) {
        this.roleType = roleType;
        this.roleId = roleId;
    }
}
