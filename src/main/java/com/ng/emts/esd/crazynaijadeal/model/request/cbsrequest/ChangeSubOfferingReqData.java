package com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest;

public class ChangeSubOfferingReqData {
    private SubAccessCode subAccessCode;

    private SupplementaryOffering supplementaryOffering;

    public void setSubAccessCode(SubAccessCode subAccessCode){
        this.subAccessCode = subAccessCode;
    }
    public SubAccessCode getSubAccessCode(){
        return this.subAccessCode;
    }
    public void setSupplementaryOffering(SupplementaryOffering supplementaryOffering){
        this.supplementaryOffering = supplementaryOffering;
    }
    public SupplementaryOffering getSupplementaryOffering(){
        return this.supplementaryOffering;
    }

    @Override
    public String toString() {
        return "ChangeSubOfferingReqData{" +
                "subAccessCode=" + subAccessCode +
                ", supplementaryOffering=" + supplementaryOffering +
                '}';
    }
}
