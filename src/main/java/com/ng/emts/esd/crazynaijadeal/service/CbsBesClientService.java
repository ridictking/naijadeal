/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.service;

import com.google.gson.Gson;
import com.ng.emts.esd.crazynaijadeal.config.BesApiClientConfig;
import com.ng.emts.esd.crazynaijadeal.config.CbsApiClientConfig;
import com.ng.emts.esd.crazynaijadeal.exceptions.BadRequestException;
import com.ng.emts.esd.crazynaijadeal.exceptions.CBSApiClientException;
import com.ng.emts.esd.crazynaijadeal.model.request.besrequest.CreateSupplementaryOfferingModificationOrderRequestData;
import com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest.ChangeSubOfferingReqData;
import com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest.changeappendant.ChangeAppendantProductResponseData;
import com.ng.emts.esd.crazynaijadeal.model.request.cbsrequest.changeappendant.ChangeAppendantRequestData;
import com.ng.emts.esd.crazynaijadeal.model.response.CbsResponse;
import com.ng.emts.esd.crazynaijadeal.model.response.besresponse.CreateSupplementaryOfferingModificationOrderResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author victor.akinola
 */
@Service
public class CbsBesClientService {

    private static final Logger logger = LoggerFactory.getLogger(CbsBesClientService.class);

    private final CbsApiClientConfig cbsConfig;
    private final BesApiClientConfig besConfig;

    private final String CHANGE_SUB_OFFERING = "changeSubOffering";
    private final String CREATESUPPLEMENTARYOFFERING = "createSupplementaryOfferingModificationOrder";
    private final String CHANGE_APPENDANT_PRODUCT = "change-appendant-product-operation";
    private final RestTemplate restTemplate;
    private final Gson gson;
    private final SmsClient smsClient;

    protected HttpHeaders headers;

    @Autowired
    public CbsBesClientService(CbsApiClientConfig cbsConfig, BesApiClientConfig besConfig, RestTemplate restTemplate, Gson gson, SmsClient smsClient) {
        this.cbsConfig = cbsConfig;
        this.besConfig = besConfig;
        this.restTemplate = restTemplate;
        this.gson = gson;
        this.smsClient = smsClient;
        setDefaultHeader();
    }
    private void setDefaultHeader(){
        headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
    }

    public CbsResponse changeSubOffering(ChangeSubOfferingReqData requestData) {

        String cbsUrl = cbsConfig.getBcMgrUrl().concat(CHANGE_SUB_OFFERING);
        HttpEntity<ChangeSubOfferingReqData> request = new HttpEntity<>(requestData, headers);

        try {
            ResponseEntity<CbsResponse> response = restTemplate.exchange(cbsUrl, HttpMethod.POST, request, CbsResponse.class);
            int statusCode = response.getStatusCodeValue();
            logger.info("Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
            if(statusCode == 200){
                return response.getBody();
            }
            String jsonResultObject = gson.toJson(response.getBody());
            logger.info("changeSubOffering::JSonResult" + jsonResultObject);
            throw new BadRequestException(jsonResultObject);
        } catch (RestClientException e) {
            e.printStackTrace();
            throw new CBSApiClientException(e.getMessage());
        }
    }

    public ChangeAppendantProductResponseData changeAppendantProductResponseData(ChangeAppendantRequestData requestData) {

        String cbsUrl = cbsConfig.getBizMgrUrl().concat(CHANGE_APPENDANT_PRODUCT);
        HttpEntity<ChangeAppendantRequestData> request = new HttpEntity<>(requestData, headers);

        try {
            ResponseEntity<ChangeAppendantProductResponseData> response = restTemplate.exchange(cbsUrl, HttpMethod.POST, request, ChangeAppendantProductResponseData.class);
            int statusCode = response.getStatusCodeValue();
            logger.info("Result - status (" + response.getStatusCode() + ") has body: " + response.hasBody());
            if(statusCode == 200){
                return response.getBody();
            }
            String jsonResultObject = gson.toJson(response.getBody());
            logger.info("changeSubOffering::JSonResult" + jsonResultObject);
//            throw new BadRequestException(jsonResultObject);
        } catch (RestClientException e) {
            e.printStackTrace();
//            throw new CBSApiClientException(e.getMessage());
        }
        return null;
    }

    public CreateSupplementaryOfferingModificationOrderResponseData createSupplementaryOfferingModificationOrderv2(CreateSupplementaryOfferingModificationOrderRequestData requestData) {
        RestTemplate restTemplate = new RestTemplate();

        String url = besConfig.getBaseUrl72().concat(CREATESUPPLEMENTARYOFFERING);
        HttpEntity<CreateSupplementaryOfferingModificationOrderRequestData> request = new HttpEntity<>(requestData, headers);

        String jsonRequest = gson.toJson(request.getBody());
        logger.info("createSupplementaryOfferingModificationOrder::JSonRequest" + jsonRequest);

        ResponseEntity<CreateSupplementaryOfferingModificationOrderResponseData> responseEntity
                = null;
        int statusCode = 0;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, CreateSupplementaryOfferingModificationOrderResponseData.class);

            logger.info("Result - status (" + responseEntity.getStatusCode() + ") has body: " + responseEntity.hasBody());
            String jsonResultObject = gson.toJson(responseEntity.getBody());
            logger.info("createSupplementaryOfferingModificationOrder::JSonResult" + jsonResultObject);
            statusCode = responseEntity.getStatusCodeValue();
            if(statusCode == 200){
                return responseEntity.getBody();
            }
            throw new BadRequestException(jsonResultObject);
        } catch (RestClientException e) {
            e.printStackTrace();
            logger.error("createSupplementaryOfferingModificationOrder returned::" + statusCode);
            //throw  new CBSApiClientException(e.getMessage());
        }
        return null;
    }
}
