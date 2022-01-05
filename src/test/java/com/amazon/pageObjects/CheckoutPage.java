package com.amazon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='sc-subtotal-amount-buybox']/span")
    WebElement price;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        String amount = this.price.getText();
        return amount;
    }

}
