package com.microservicedemo.notification_service.models;

public class Account {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Account() {
    }
}
