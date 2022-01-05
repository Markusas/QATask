package com.amazon.tests;

import com.amazon.base.BaseTest;
import com.amazon.pageObjects.AmazonHomePage;
import com.amazon.pageObjects.SignInPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class TestSignIn extends BaseTest {
    AmazonHomePage amazonHomePage;
    SignInPage signInPage;
    String textNotBePresent = "Sign in";

    @Test
    public void logInAmazon() throws IOException {
        amazonHomePage = new AmazonHomePage(driver);
        signInPage = new SignInPage(driver);
        amazonHomePage.clickSignIn();
        signInPage.enterEmailAndContinue();
        signInPage.enterPasswordAndSubmit();
        Assert.assertFalse(signInPage.getWelcomeText().contains(textNotBePresent));
    }
}
