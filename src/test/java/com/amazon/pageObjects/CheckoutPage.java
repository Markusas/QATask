package com.amazon.pageObjects;

import com.amazon.base.BasePage;
import org.openqa.selenium.By;


public class CheckoutPage extends BasePage {
    By price = By.xpath("//*[@id='sc-subtotal-amount-buybox']/span");

    public double getPrice() {
        String amount = driver.findElement(price).getText();
        double pr = Double.parseDouble(amount.replace("£", ""));
        return pr;
    }

}
