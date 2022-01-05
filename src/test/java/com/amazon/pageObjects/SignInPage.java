package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.amazone.util.TestDataReader.getEmail;
import static com.amazone.util.TestDataReader.getPassword;

public class SignInPage {
    WebDriver driver;

    @FindBy(id = "ap_email")
    WebElement email;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement password;

    @FindBy(id = "signInSubmit")
    WebElement signInSubmit;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement welcomeMessage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmailAndContinue() throws IOException {
        this.email.sendKeys(getEmail());
        this.continueButton.click();
    }

    public void enterPasswordAndSubmit() throws IOException {
        this.password.sendKeys(getPassword());
        this.signInSubmit.click();
    }

    public String getWelcomeText() {
        return this.welcomeMessage.getText();
    }
}
