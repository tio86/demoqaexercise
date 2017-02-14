package example;

import base.TestBase;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ExampleGRIDTest extends TestBase {

    public RemoteWebDriver driver = null;
    public String baseURL = "http://www.apertus.hu/";
    public String nodeURL = "http://172.25.0.1:4444/wd/hub";

    String actualBrowser = null;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {

        actualBrowser = browser;

        driver = new RemoteWebDriver(new URL(nodeURL), getBrowserCapabilities(browser));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void firstGridTest() throws InterruptedException {
        System.out.println(actualBrowser + " - INFO - Apertus oldalra lépés");
        driver.get(baseURL);

        Thread.sleep(5000);

        System.out.println(actualBrowser + " - INFO - Cím kiolvasása");
        String pageTitle = driver.getTitle();

        Thread.sleep(5000);

        System.out.println(actualBrowser + " - INFO - Cím ellenőrzése");
        Assert.assertEquals(pageTitle, "Apertus Nonprofit Kft.");
    }

    @Test
    public void googleGridTest() throws InterruptedException {
        System.out.println(actualBrowser + " - INFO - Google oldalra lépés");
        driver.get("https://www.google.com");

        Thread.sleep(5000);

        System.out.println(actualBrowser + " - INFO - Cím kiolvasása");
        String pageTitle = driver.getTitle();

        Thread.sleep(5000);

        System.out.println(actualBrowser + " - INFO - Cím ellenőrzése");
        Assert.assertEquals(pageTitle, "Google");
    }
}
