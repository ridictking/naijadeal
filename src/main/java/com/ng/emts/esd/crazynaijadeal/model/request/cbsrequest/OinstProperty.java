package com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest;

public class OinstProperty {
    private String effectiveTime;

    private String expirationTime;

    private String propCode;

    private String propType;

    private String value;

    public void setEffectiveTime(String effectiveTime){
        this.effectiveTime = effectiveTime;
    }
    public String getEffectiveTime(){
        return this.effectiveTime;
    }
    public void setExpirationTime(String expirationTime){
        this.expirationTime = expirationTime;
    }
    public String getExpirationTime(){
        return this.expirationTime;
    }
    public void setPropCode(String propCode){
        this.propCode = propCode;
    }
    public String getPropCode(){
        return this.propCode;
    }
    public void setPropType(String propType){
        this.propType = propType;
    }
    public String getPropType(){
        return this.propType;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return "OinstProperty{" +
                "effectiveTime='" + effectiveTime + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", propCode='" + propCode + '\'' +
                ", propType='" + propType + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
