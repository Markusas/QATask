package com.amazon.pageObjects;

import com.amazon.base.BasePage;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.amazone.util.TestDataReader.getToyName;

public class AmazonHomePage extends BasePage {

    public AmazonHomePage() {
    }

    By signInButton = By.xpath("//a[@id='nav-link-accountList']");
    By searchBox = By.id("twotabsearchtextbox");
    By searchSubmit = By.id("nav-search-submit-button");

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void searchToy(String toyName) throws IOException {
        driver.findElement(searchBox).sendKeys(getToyName());
        driver.findElement(searchSubmit).click();
    }
}
