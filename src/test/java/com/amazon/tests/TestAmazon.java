package com.amazon.tests;

import com.amazon.base.BaseTest;
import com.amazon.pageObjects.AmazonHomePage;
import com.amazon.pageObjects.CheckoutPage;
import com.amazon.pageObjects.ShoppingCart;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.amazone.util.TestDataReader.*;

public class TestAmazon extends BaseTest {
    AmazonHomePage amazonHomePage;
    ShoppingCart shoppingCart;
    CheckoutPage checkoutPage;

    @Test(priority = 1)
    public void searchForToy() throws IOException {
        amazonHomePage = new AmazonHomePage(driver);
        shoppingCart = new ShoppingCart(driver);
        checkoutPage = new CheckoutPage(driver);

        //Searching for products
        amazonHomePage.searchToy(getToyName());
        commonElements.clickCookieAccept();

        //Sorting products
        amazonHomePage.sortByCustomerReview();

        //Adding products to cart
        amazonHomePage.addThirdToy();
        amazonHomePage.navigateBack();
        amazonHomePage.addFourthToy();

        //Removing products from cart
        shoppingCart.navigateToBasket();
        shoppingCart.deleteToy();

        //Checking basket
        String count = shoppingCart.getNumberOfToys();
        Assert.assertEquals(count, getToysAmount(), "Count of toys does not match");

        //Verifying Amount
        String actualAmount = checkoutPage.getPrice();
        Assert.assertEquals(actualAmount, amazonHomePage.productPrice, "Total amount does not match");
    }
}