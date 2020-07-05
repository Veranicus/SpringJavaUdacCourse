package com.udacity.jwnd.c1.review.controller;

public class ChatMessage {

    private String showMessageText;

    private String showMessageUsername;

    public ChatMessage(String showMessageText, String showMessageUsername) {
        this.showMessageText = showMessageText;
        this.showMessageUsername = showMessageUsername;
    }

    public String getShowMessageText() {
        return showMessageText;
    }

    public void setShowMessageText(String showMessageText) {
        this.showMessageText = showMessageText;
    }

    public String getShowMessageUsername() {
        return showMessageUsername;
    }

    public void setShowMessageUsername(String showMessageUsername) {
        this.showMessageUsername = showMessageUsername;
    }
}
