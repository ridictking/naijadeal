/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.besrequest;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor.akinola
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderBasicInfoData implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String priority;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String state;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String orderDate;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String completionDate;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String expectedCompletionDate;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<OrderBasicInfoRelatedPartyData> relatedParty;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getExpectedCompletionDate() {
        return expectedCompletionDate;
    }

    public void setExpectedCompletionDate(String expectedCompletionDate) {
        this.expectedCompletionDate = expectedCompletionDate;
    }

    public ArrayList<OrderBasicInfoRelatedPartyData> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(ArrayList<OrderBasicInfoRelatedPartyData> relatedParty) {
        this.relatedParty = relatedParty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
