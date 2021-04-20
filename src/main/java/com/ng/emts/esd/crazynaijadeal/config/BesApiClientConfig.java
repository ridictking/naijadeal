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
@ConfigurationProperties(prefix = "bes.api")
public class BesApiClientConfig {

    private String baseUrl;
    private String baseUrl72;

    public String getBaseUrl72() {
        return baseUrl72;
    }

    public void setBaseUrl72(String baseUrl72) {
        this.baseUrl72 = baseUrl72;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
