package com.util.entity;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ProductErrorResponse {

    private int status;

    private String message;

    private ZonedDateTime timeStamp;

    public ProductErrorResponse() {
    }

    public ProductErrorResponse(int status, String message, ZonedDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = Instant.ofEpochMilli(timeStamp).atZone(ZoneOffset.UTC);
    }
}
