package com.amazon.base;

import com.amazon.pageObjects.CommonElements;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.amazone.util.TestDataReader.*;

public class BaseTest {
    public WebDriver driver;
    String baseUrl;
    String nodeUrl;
    DesiredCapabilities dc;
    public CommonElements commonElements;

    @BeforeMethod
    public void setUp() throws IOException {
        String browser = getBrowser();
        this.baseUrl = getUrl();
        nodeUrl = getNodeUrl();
        dc = new DesiredCapabilities();
        dc.setBrowserName(browser);
        dc.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL(nodeUrl), dc);

        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getTime()), TimeUnit.SECONDS);
        driver.get(this.baseUrl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        commonElements = new CommonElements(driver);
        commonElements.clickCookieAccept();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
