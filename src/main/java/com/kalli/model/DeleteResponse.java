package com.kalli.model;

public class DeleteResponse {

    public String responseStatus;

    public DeleteResponse(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}
