/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.response.besresponse;




import com.ng.emts.esd.crazynaijadeal.model.request.besrequest.PropertyData;

import java.util.ArrayList;

/**
 *
 * @author victor.akinola
 */
public abstract class ResponseHeaderData {

    public ResponseHeaderData() {
    }

    public ResponseHeaderData(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    private String transactionId;
    private String returnCode;
    private String returnMsg;
    private ArrayList<PropertyData> property;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public ArrayList<PropertyData> getProperty() {
        return property;
    }

    public void setProperty(ArrayList<PropertyData> property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "ResponseHeaderData{" +
                "transactionId='" + transactionId + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", property=" + property +
                '}';
    }
}
