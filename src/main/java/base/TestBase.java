package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

public class TestBase {

    protected  WebDriver driver = null;

    protected void initialize(){

        System.out.println("SETUP - Böngésző megnyitása");
        driver = new FirefoxDriver();
    }

    protected void evaluateResults(ITestResult result){
        System.out.println("TEARDOWN - Eredmények kiértékelése");
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                System.out.println("ERROR - Hiba a(z) " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName() + " futása során!");
            } else {
                System.out.println("SUCCESS - Sikeres: " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
            }

        } catch (Exception e) {
            System.out.println("ERROR - Hiba történt az AfterMethod futása közben " + e);
        }

    }
}
