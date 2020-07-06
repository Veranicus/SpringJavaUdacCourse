package com.udacity.jwnd.c1.review.controller;

public class ChatMessages {

    private Integer messageid;

    private String messageText;

    private String username;

    public ChatMessages(String messageText, String username) {
        this.messageText = messageText;
        this.username = username;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
