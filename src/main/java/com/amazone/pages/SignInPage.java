package com.amazone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    By email = By.id("ap_email");
    By continueButton = By.id("continue");
    By password = By.id("ap_password");
    By signInSubmit = By.id("signInSubmit");
}
