package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.amazone.util.TestDataReader.getToyName;

public class AmazonHomePage {
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    By signInButton = By.xpath("//a[@id='nav-link-accountList']");
    By searchBox = By.id("twotabsearchtextbox");
    By searchSubmit = By.id("nav-search-submit-button");

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void searchToy() throws IOException {
        driver.findElement(searchBox).sendKeys(getToyName());
        driver.findElement(searchSubmit).click();
    }
}
