package com.amazon.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static com.amazone.util.TestDataReader.*;

public class BasePage {
    public static WebDriver driver;

    public static void initialization() throws IOException {
        String baseUrl = getUrl();
        String nodeUrl = getNodeUrl();
        String browser = getBrowser();

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(browser);
        dc.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeUrl), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(getTime())));
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
