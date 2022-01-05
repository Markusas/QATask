package com.amazon.pageObjects;

import com.amazon.base.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static com.amazone.util.TestDataReader.getTime;

public class ShoppingCart {

    WebDriver driver;

    @FindBy(id = "nav-cart")
    WebElement basket;

    @FindBy(xpath = "//input[contains(@data-action,'delete')]")
    List<WebElement> toysList;

    @FindBy(id = "nav-cart-count")
    WebElement numberOfToys;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToBasket() {
        this.basket.click();
    }

    public void deleteToy() throws IOException {
        new Waits().waitUntilElementIsVisible(this.driver, this.toysList.get(1));
        this.toysList.get(1).click();
    }

    public String getNumberOfToys() {
        String number = this.numberOfToys.getText();
        return number;
    }

    public void deleteToyFromBasket() {
        this.toysList.get(1).click();
    }

}
