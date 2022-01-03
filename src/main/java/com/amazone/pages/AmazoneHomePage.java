package com.amazone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazoneHomePage {
    public AmazoneHomePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    By signInButton = By.xpath("//a[@id='nav-link-accountList']");
}
