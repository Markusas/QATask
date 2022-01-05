package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.amazone.util.TestDataReader.getTime;

public class Waits {
    public void waitUntilElementIsVisible(WebDriver driver, WebElement element) throws IOException {
        new WebDriverWait(driver, Integer.parseInt(getTime()))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
