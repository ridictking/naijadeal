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
public class ContactPersonInfoData implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ContactPersonInfoNameData name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<ContactInfoData> contactInformation;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String effectiveTime;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String expiryTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContactPersonInfoNameData getName() {
        return name;
    }

    public void setName(ContactPersonInfoNameData name) {
        this.name = name;
    }

    public ArrayList<ContactInfoData> getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ArrayList<ContactInfoData> contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }
}
