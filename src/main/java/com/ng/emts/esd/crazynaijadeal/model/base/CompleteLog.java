package com.ng.emts.esd.crazynaijadeal.model.base;

public class CompleteLog {
    String uuid;
    String message;

    public CompleteLog(String uuid, String message) {
        this.uuid = uuid;
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
