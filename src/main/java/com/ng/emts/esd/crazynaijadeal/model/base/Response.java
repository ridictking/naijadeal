package com.ng.emts.esd.crazynaijadeal.model.base;

import org.springframework.util.StringUtils;

import java.util.List;

public class Response {
    private String code;
    private String description;
    private String logId;
    private List<Error> errors;

    public Response() {
    }

    public Response(String code, String description) {
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

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public String toString(){
        String value = "";
        if(StringUtils.hasText(this.code) || StringUtils.hasText(this.description) || this.errors != null){
            value = "Response{";
            if(StringUtils.hasText(this.code)){
                value = value + "code='" + this.code + '\'';
            }
            if(StringUtils.hasText(this.description)){
                value = value + ", description='" + this.description + '\'';
            }
            if(this.errors != null && !this.errors.isEmpty()){
                value = value + this.errors;
            }

            value = value + '}';
        }
        return value;
    }
}
