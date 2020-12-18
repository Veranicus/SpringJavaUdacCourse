package com.udacity.jwnd.c1.review.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

@FindBy(id = "count-display")
private WebElement inputUsername;

@FindBy(id = "increment-button")
private WebElement inputPassword;


    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    public void setInputUsername(String usernameInput) {
        inputUsername.sendKeys(usernameInput);
    }

    public void setInputPassword(String passwordInput) {
        inputPassword.sendKeys(passwordInput);
    }

    public void submitAllLoginInputs(){
        inputPassword.submit();
        inputUsername.submit();
    }
}