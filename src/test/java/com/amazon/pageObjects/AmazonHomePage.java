package com.amazon.pageObjects;

import com.amazon.base.BasePage;
import org.openqa.selenium.By;
import java.io.IOException;

import static com.amazone.util.TestDataReader.getToyName;

public class AmazonHomePage extends BasePage {

    By signInButton = By.xpath("//a[@id='nav-link-accountList']");
    By searchBox = By.id("twotabsearchtextbox");
    By searchSubmit = By.id("nav-search-submit-button");

    By sort = By.xpath("//span[@class='a-dropdown-prompt']");
    By avgCustomerReviewSort = By.xpath("//div[@id='a-popover-2']//li[4]");

    By elementsList = By.xpath(".//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']");

    By addToBasket = By.xpath("//input[@id='add-to-cart-button']");

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void searchToy(String toyName) throws IOException {
        driver.findElement(searchBox).sendKeys(getToyName());
        driver.findElement(searchSubmit).click();
    }

    public void sortByCustomerReview() throws InterruptedException {
        driver.findElement(sort).click();
        driver.findElement(avgCustomerReviewSort).click();
        Thread.sleep(1000);
    }

    public void addThirdToy() {
        driver.findElements(elementsList).get(2).click();
        driver.findElement(addToBasket).click();
    }

    public void navigateBack() {
        driver.navigate().back();
        driver.navigate().back();
    }

    public void addFourthToy() {
        driver.findElements(elementsList).get(3).click();
        driver.findElement(addToBasket).click();
    }
}
