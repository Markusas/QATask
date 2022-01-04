package com.amazon.tests;

import com.amazon.base.BaseTest;
import com.amazon.pageObjects.AmazonHomePage;
import com.amazon.pageObjects.SignInPage;
import org.testng.annotations.*;

import java.io.IOException;

public class TestSignIn extends BaseTest {
    AmazonHomePage amazonHomePage;
    SignInPage signInPage;

    public TestSignIn() {
    }

    @BeforeTest()
    public void setUp() throws IOException {
        TestSignIn.setUp();
        amazonHomePage = new AmazonHomePage();
        signInPage = new SignInPage();
    }

    @Test
    public void logInAmazon() throws IOException {
        amazonHomePage.clickSignIn();
        signInPage.enterEmailAndContinue();
        signInPage.enterPasswordAndSubmit();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
