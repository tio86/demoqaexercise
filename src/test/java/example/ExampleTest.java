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

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) driver.quit();
//    }

    @Test(enabled = true)
    public void easyTitleTest() {
        System.out.println("TEST - DemoQA oldalra lépés.");
        driver.get(DemoQAPage.URL);

        System.out.println("TEST - Oldal ellenőrzése");
        DemoQAPage.assertPage(driver);
    }

    @Test
    public void tab1Test() {
        System.out.println("TEST - Tab1 kattintás");

        int id = 1;
        DemoQAPage.tab(driver, id).click();
        DemoQAPage.tabTitle(driver, id);
    }

    @Test
    public void tab2Test() {
        System.out.println("TEST - Tab2 kattintás");

        int id = 2;
        DemoQAPage.tab(driver, id).click();
        DemoQAPage.tabTitle(driver, id);
    }

    @Test
    public void tab3Test() {
        System.out.println("TEST - Tab3 kattintás");

        int id = 3;
        DemoQAPage.tab(driver, id).click();
        DemoQAPage.tabTitle(driver, id);
    }

    @Test
    public void tab4Test() {
        System.out.println("TEST - Tab4 kattintás");

        int id = 4;
        DemoQAPage.tab(driver, id).click();
        DemoQAPage.tabTitle(driver, id);
    }

    @Test
    public void tab5Test() {
        System.out.println("TEST - Tab5 kattintás");

        int id = 5;
        DemoQAPage.tab(driver, id).click();
        DemoQAPage.tabTitle(driver, id);
    }

}
