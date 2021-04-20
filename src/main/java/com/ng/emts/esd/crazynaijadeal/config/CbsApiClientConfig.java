/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author victor.akinola
 */
@Component
@ConfigurationProperties(prefix = "cbs.api")
public class CbsApiClientConfig {

    private String bizMgrUrl;
    private String acctMgrUrl;
    private String bbMgrUrl;
    private String bcMgrUrl;

    public String getBizMgrUrl() {
        return bizMgrUrl;
    }

    public void setBizMgrUrl(String bizMgrUrl) {
        this.bizMgrUrl = bizMgrUrl;
    }

    public String getAcctMgrUrl() {
        return acctMgrUrl;
    }

    public void setAcctMgrUrl(String acctMgrUrl) {
        this.acctMgrUrl = acctMgrUrl;
    }

    public String getBbMgrUrl() {
        return bbMgrUrl;
    }

    public void setBbMgrUrl(String bbMgrUrl) {
        this.bbMgrUrl = bbMgrUrl;
    }

    public String getBcMgrUrl() {
        return bcMgrUrl;
    }

    public void setBcMgrUrl(String bcMgrUrl) {
        this.bcMgrUrl = bcMgrUrl;
    }

}
