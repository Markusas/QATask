package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.amazone.util.TestDataReader.getEmail;
import static com.amazone.util.TestDataReader.getPassword;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    By email = By.id("ap_email");
    By continueButton = By.id("continue");
    By password = By.id("ap_password");
    By signInSubmit = By.id("signInSubmit");

    public void enterEmailAndContinue() throws IOException {
        driver.findElement(email).sendKeys(getEmail());
        driver.findElement(continueButton).click();
    }

    public void enterPasswordAndSubmit() throws IOException {
        driver.findElement(password).sendKeys(getPassword());
        driver.findElement(signInSubmit).click();
    }
}
