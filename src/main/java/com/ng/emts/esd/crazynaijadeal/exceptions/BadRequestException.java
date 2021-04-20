package com.ng.emts.esd.crazynaijadeal.exceptions;


import com.ng.emts.esd.crazynaijadeal.util.LogUtil;

/**
 * created by Ridhwan Oladejo, 2020
 */
public class BadRequestException extends AbstractException{
    public BadRequestException(String message) {
        super(message);
        this.setGuid(LogUtil.getGUID());
    }

    public BadRequestException(String code, String message) {
        super(code, LogUtil.getGUID() ,message);
    }
}
