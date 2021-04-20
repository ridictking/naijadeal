/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.esd.crazynaijadeal.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author victor.akinola
 */
public class CBSApiClientException extends AbstractException {

    public CBSApiClientException(String message) {
        super(message);
    }

    public CBSApiClientException(HttpStatus httpStatus, String message) {
        super(httpStatus.toString().concat("::" + message));
    }
}
