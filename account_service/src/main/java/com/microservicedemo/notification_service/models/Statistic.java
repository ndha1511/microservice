package com.microservicedemo.notification_service.models;

import java.util.Date;

public class Statistic {
    private String message;
    private Date createdDate;

    public Statistic(String message, Date createdDate) {
        this.message = message;
        this.createdDate = createdDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Statistic() {
    }
}
