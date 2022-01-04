package com.amazon.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.amazone.util.TestDataReader.*;

public class BaseTest {
    public WebDriver driver;
    String baseUrl;
    String nodeUrl;
    DesiredCapabilities dc;

    @BeforeSuite
    public void initializeVariables() throws IOException {
        String browser = getBrowser();
        baseUrl = getUrl();
        nodeUrl = getNodeUrl();
        dc = new DesiredCapabilities();
        dc.setBrowserName(browser);
        dc.setPlatform(Platform.WINDOWS);
    }

    public void setUp() throws IOException {
        driver = new RemoteWebDriver(new URL(nodeUrl), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(getTime())));
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
