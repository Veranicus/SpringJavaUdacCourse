package com.udacity.jwnd.c1.review.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement textField;

    @FindBy(id = "submitMessage")
    private WebElement submitButton;

    @FindBy(className = "chatMessageUsername")
    private WebElement firstMessageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;


    public ChatPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void sendChatMessage(String text) {
        textField.sendKeys(text);
        submitButton.click();
    }

    public ChatMessages getFirstMessage() {
        ChatMessages result = new ChatMessages(firstMessageText.getText(), firstMessageUsername.getText());
        return result;
    }
}