package com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest;

import java.util.List;

public class AddOffering {
    private EffectiveTime effectiveTime;

    private String expirationTime;

    private OfferingKey offeringKey;

    private String bundledFlag;

    private String offeringClass;

    private List<String> productInst;

    private List<OinstProperty> oinstProperty;

    public void setEffectiveTime(EffectiveTime effectiveTime){
        this.effectiveTime = effectiveTime;
    }
    public EffectiveTime getEffectiveTime(){
        return this.effectiveTime;
    }
    public void setExpirationTime(String expirationTime){
        this.expirationTime = expirationTime;
    }
    public String getExpirationTime(){
        return this.expirationTime;
    }
    public void setOfferingKey(OfferingKey offeringKey){
        this.offeringKey = offeringKey;
    }
    public OfferingKey getOfferingKey(){
        return this.offeringKey;
    }
    public void setBundledFlag(String bundledFlag){
        this.bundledFlag = bundledFlag;
    }
    public String getBundledFlag(){
        return this.bundledFlag;
    }
    public void setOfferingClass(String offeringClass){
        this.offeringClass = offeringClass;
    }
    public String getOfferingClass(){
        return this.offeringClass;
    }
    public void setProductInst(List<String> productInst){
        this.productInst = productInst;
    }
    public List<String> getProductInst(){
        return this.productInst;
    }
    public void setOinstProperty(List<OinstProperty> oinstProperty){
        this.oinstProperty = oinstProperty;
    }
    public List<OinstProperty> getOinstProperty(){
        return this.oinstProperty;
    }

    @Override
    public String toString() {
        return "AddOffering{" +
                "effectiveTime=" + effectiveTime +
                ", expirationTime='" + expirationTime + '\'' +
                ", offeringKey=" + offeringKey +
                ", bundledFlag='" + bundledFlag + '\'' +
                ", offeringClass='" + offeringClass + '\'' +
                ", productInst=" + productInst +
                ", oinstProperty=" + oinstProperty +
                '}';
    }
}
