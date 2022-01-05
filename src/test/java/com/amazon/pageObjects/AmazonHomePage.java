package com.amazon.pageObjects;

import com.amazon.base.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static com.amazone.util.TestDataReader.getToyName;

public class AmazonHomePage {
    WebDriver driver;
    public String productPrice;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchSubmit;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    WebElement sortButton;

    @FindBy(xpath = "//div[@id='a-popover-2']//li[4]")
    WebElement avgCustomerReviewSort;

    @FindBy(xpath = ".//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']")
    List<WebElement> elementsList;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToBasket;

    @FindBy(xpath = "(//div[contains(@id,'corePrice')]//span[@aria-hidden='true'])[2]")
    WebElement productPriceTag;

    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]")
    WebElement resultList;


    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        this.signInButton.click();
    }

    public void searchToy(String toyName) throws IOException {
        this.searchBox.sendKeys(getToyName());
        this.searchSubmit.click();
    }

    public void sortByCustomerReview() throws IOException {
        this.sortButton.click();
        this.avgCustomerReviewSort.click();
        new Waits().waitUntilElementIsVisible(this.driver, this.resultList);
    }

    public void addThirdToy() throws IOException {
        new Waits().waitUntilElementIsVisible(this.driver, this.elementsList.get(2));
        this.elementsList.get(2).click();
        this.addToBasket.click();
    }

    public void navigateBack() {
        driver.navigate().back();
        driver.navigate().back();
    }

    public void addFourthToy() {
        this.elementsList.get(3).click();
        productPrice = this.productPriceTag.getText().trim();
        this.addToBasket.click();
    }

}
