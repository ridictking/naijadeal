package com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest;

import java.util.List;

public class SupplementaryOffering {
    private List<AddOffering> addOffering;

    public void setAddOffering(List<AddOffering> addOffering){
        this.addOffering = addOffering;
    }
    public List<AddOffering> getAddOffering(){
        return this.addOffering;
    }

    @Override
    public String toString() {
        return "SupplementaryOffering{" +
                "addOffering=" + addOffering +
                '}';
    }
}
