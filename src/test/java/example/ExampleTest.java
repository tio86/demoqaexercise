package example;

import base.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoQAPage;

public class ExampleTest extends TestBase {

    @BeforeClass
    public void setUp() {
        initialize();
    }

    @AfterMethod
    public void evaluateTest(ITestResult testResult) {
        evaluateResults(testResult);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test(enabled = true)
    public void easyTitleTest() {
        System.out.println("TEST - DemoQA oldalra lépés.");
        driver.get(DemoQAPage.URL);

        System.out.println("TEST - Oldal ellenőrzése");
        DemoQAPage.assertPage(driver);
    }
}
