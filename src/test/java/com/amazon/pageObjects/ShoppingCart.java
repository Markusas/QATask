package com.amazon.pageObjects;

import com.amazon.base.BasePage;
import org.openqa.selenium.By;

public class ShoppingCart extends BasePage {
    By basket = By.id("nav-cart");
    By toysList = By.xpath("//span[contains(@data-action,'delete')]");



    public void navigateToBasket() {
        driver.findElement(basket).click();
    }

    public void deleteToy() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElements(toysList).get(1).click();
    }

}