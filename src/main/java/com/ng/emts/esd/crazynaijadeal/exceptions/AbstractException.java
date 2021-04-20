package com.ng.emts.esd.crazynaijadeal.exceptions;

/**
 * created by Ridhwan Oladejo, 2020
 */
public class AbstractException extends RuntimeException {

    private String code;
    private String guid;

    public AbstractException(String message){ super(message); }

    public AbstractException(String code, String message){
        super(message);
        this.setCode(code);
    }

    public AbstractException(String message, Throwable cause, String code, String guid) {
        super(message, cause);
        this.code = code;
        this.guid = guid;
    }

    public AbstractException(String code, String guid, String message) {
        super(message);
        this.code = code;
        this.guid = guid;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
