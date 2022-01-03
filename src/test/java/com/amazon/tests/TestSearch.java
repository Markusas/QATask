package com.amazon.tests;

import com.amazon.base.BasePage;
import com.amazon.pageObjects.AmazonHomePage;
import org.testng.annotations.*;

import java.io.IOException;

import static com.amazone.util.TestDataReader.*;

public class TestSearch extends BasePage {
    AmazonHomePage amazonHomePage;

    public TestSearch() {
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        amazonHomePage = new AmazonHomePage();
    }

    @Test
    public void searchForToy() throws IOException {
        amazonHomePage.searchToy(getToyName());
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
