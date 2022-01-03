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

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        amazonHomePage = new AmazonHomePage();
    }

    @Test(priority = 1)
    public void searchForToy() throws IOException {
        amazonHomePage.searchToy(getToyName());
    }

    @Test (priority = 2)
    public void sortToys() {
        amazonHomePage.sortByCustomerReview();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
