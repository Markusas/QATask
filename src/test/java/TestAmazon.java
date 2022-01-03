import com.amazone.pages.AmazonHomePage;
import com.amazone.pages.SignInPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static com.amazone.util.TestDataReader.getNodeUrl;
import static com.amazone.util.TestDataReader.getUrl;


public class TestAmazon {
    WebDriver driver;
    AmazonHomePage amazonHomePage;
    SignInPage signInPage;
    String baseUrl, nodeUrl;

    @BeforeTest
    public void setUp() throws IOException {
        baseUrl = getUrl();
        nodeUrl = getNodeUrl();
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeUrl), dc);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void logInAmazon() throws IOException {
        amazonHomePage = new AmazonHomePage(driver);
        signInPage = new SignInPage(driver);
        amazonHomePage.clickSignIn();
        signInPage.enterEmailAndContinue();
        signInPage.enterPasswordAndSubmit();
    }
}
