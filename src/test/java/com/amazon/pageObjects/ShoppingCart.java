package com.amazon.pageObjects;

import com.amazon.base.BaseTest;
import org.openqa.selenium.By;

public class ShoppingCart extends BaseTest {
    By basket = By.id("nav-cart");
    By toysList = By.xpath("//input[contains(@data-action,'delete')]");
    By numberOfToys = By.id("nav-cart-count");

    public void navigateToBasket() {
        driver.findElement(basket).click();
    }

    public void deleteToy() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElements(toysList).get(1).click();
    }

    public String getNumberOfToys() {
        String number = driver.findElement(numberOfToys).getText();
        return number;
    }

    public void deleteToyFromBasket() {
        driver.findElement(toysList).click();
    }

}
