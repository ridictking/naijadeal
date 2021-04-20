/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request;

import java.io.Serializable;

/**
 *
 * @author arinze.ojiaku
 * @author keni
 */
public class OcsBaseData implements Serializable {

    private static final long serialVersionUID = -4607824992978615136L;
    private String appName;
    private String txnCode;
    private String commandId;
    private String description;
    private String txnId;

    public String getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "OcsBaseData{" +
                "appName='" + appName + '\'' +
                ", txnCode='" + txnCode + '\'' +
                ", commandId='" + commandId + '\'' +
                ", description='" + description + '\'' +
                ", txnId='" + txnId + '\'' +
                '}';
    }
}
