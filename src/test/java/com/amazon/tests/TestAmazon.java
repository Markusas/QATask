package com.amazon.tests;

import com.amazon.base.BasePage;
import com.amazon.pageObjects.AmazonHomePage;
import com.amazon.pageObjects.SignInPage;
import org.testng.annotations.*;

import java.io.IOException;

public class TestAmazon extends BasePage {
    AmazonHomePage amazonHomePage;
    SignInPage signInPage;

    public TestAmazon() {
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        amazonHomePage = new AmazonHomePage();
        signInPage = new SignInPage();
    }

    @Test
    public void logInAmazon() throws IOException {
        amazonHomePage.clickSignIn();
        signInPage.enterEmailAndContinue();
        signInPage.enterPasswordAndSubmit();
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
