package com.amazon.tests;

import com.amazon.base.BasePage;
import com.amazon.pageObjects.AmazonHomePage;
import com.amazon.pageObjects.CheckoutPage;
import com.amazon.pageObjects.ShoppingCart;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.amazone.util.TestDataReader.*;

public class TestSearch extends BasePage {
    AmazonHomePage amazonHomePage;
    ShoppingCart shoppingCart;
    CheckoutPage checkoutPage;

    public TestSearch() {
    }

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        amazonHomePage = new AmazonHomePage();
        shoppingCart = new ShoppingCart();
        checkoutPage = new CheckoutPage();
    }

    @Test(priority = 1)
    public void searchForToy() throws IOException {
        amazonHomePage.searchToy(getToyName());
    }

    @Test(priority = 2)
    public void sortToys() throws InterruptedException {
        amazonHomePage.sortByCustomerReview();
    }

    @Test(priority = 3)
    public void addToCard() {
        amazonHomePage.addThirdToy();
        amazonHomePage.navigateBack();
        amazonHomePage.addFourthToy();
    }

    @Test(priority = 4)
    public void navigateToShoppingCart() {
        shoppingCart.navigateToBasket();
    }

    @Test(priority = 5)
    public void removeSecondToy() throws InterruptedException {
        shoppingCart.deleteToy();
    }

    @Test(priority = 6)
    public void checkBasket() {
        String count = shoppingCart.getNumberOfToys();
        Assert.assertEquals(count, "1", "Count of toys does not match");
    }

    @Test(priority = 7)
    public void verifyAmount() {
        double amount = checkoutPage.getPrice();
        Assert.assertEquals(amount, 4.99, "Total amount does not match");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
