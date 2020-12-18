package com.udacity.jwnd.c1.review.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    @FindBy(css = "inputFirstName")
    private WebElement inputFirstName;

    @FindBy(css = "inputLastName")
    private WebElement inputLastName;

    @FindBy(css = "inputUsername")
    private WebElement inputUsername;

    @FindBy(css = "inputPassword")
    private WebElement inputPassword;

    @FindBy(css = "submit-button")
    private WebElement submit;

    public SignupPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }


    public void signupUser(String firstName, String lastName, String username,
                           String password){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        submit.click();
    }
}
