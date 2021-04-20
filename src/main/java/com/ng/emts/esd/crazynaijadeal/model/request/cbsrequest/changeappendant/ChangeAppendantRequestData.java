/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest.changeappendant;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author arinze.ojiaku
 */
public class ChangeAppendantRequestData implements Serializable {

    private static final long serialVersionUID = 160057990963137372L;

    @Expose
    private String[] productId;
    @Expose
    private String msisdn;
    @Expose
    private int handlingChargeFlag;
    @Expose
    private String txnId;
    @Expose
    private String productStatus;
    private int graceDays;
    @Expose
    private int operationType;
    @Expose
    private String effectiveDate;
    @Expose
    private String expiryDate;
    @Expose
    @NotNull(message = "the field \"appName\" is not nillable")
    private String appName;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String[] getProductId() {
        return productId;
    }

    public void setProductId(String[] productId) {
        this.productId = productId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getHandlingChargeFlag() {
        return handlingChargeFlag;
    }

    public void setHandlingChargeFlag(int handlingChargeFlag) {
        this.handlingChargeFlag = handlingChargeFlag;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public int getGraceDays() {
        return graceDays;
    }

    public void setGraceDays(int graceDays) {
        this.graceDays = graceDays;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("txid=>%s, msisdn=>%s, charge-flag=>%s, ops-type=>%s", this.getTxnId(), this.getMsisdn(), this.getHandlingChargeFlag(), this.getOperationType()));
        if (this.getProductId() != null) {
            for (String pid : productId) {
                sb.append(String.format("\nproduct-id:%s", pid));
            }
        }
        return super.toString();
    }
}
