package com.amazon.pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {
    WebDriver driver;

    @FindBy(id = "sp-cc-accept")
    WebElement acceptCookiesButton;

    public CommonElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCookieAccept() {
        try{
            this.acceptCookiesButton.click();
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

    }
}
