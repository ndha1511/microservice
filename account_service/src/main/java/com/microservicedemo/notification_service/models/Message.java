package com.microservicedemo.notification_service.models;

public class Message {
    private String to;
    private String toName;
    private String subject;
    private String content;

    public Message(String to, String toName, String subject, String content) {
        this.to = to;
        this.toName = toName;
        this.subject = subject;
        this.content = content;
    }

    public Message() {
    }

    public String getTo() {
        return to;
    }

    public String getToName() {
        return toName;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
