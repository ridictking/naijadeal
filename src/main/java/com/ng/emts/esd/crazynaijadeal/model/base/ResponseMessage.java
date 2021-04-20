package com.ng.emts.esd.crazynaijadeal.model.base;

public enum ResponseMessage {
    BAD_REQUEST("400", "Bad request"),
    NOT_FOUND("404", "Not found");

    private String code;
    private String description;

    ResponseMessage(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
