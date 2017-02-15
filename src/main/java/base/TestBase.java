package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import java.io.File;

public class TestBase {

    protected WebDriver driver = null;

    protected void initialize() {
        /* Így lehet megadni direktben, hogy honnan indítsa el a firefoxot */
        File pathToBinary = new File("/home/kergeodeta/Letöltések/firefox/firefox");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        System.out.println("SETUP - Böngésző megnyitása");
        driver = new FirefoxDriver(ffBinary,firefoxProfile);
    }

    protected void evaluateResults(ITestResult result) {
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

    protected DesiredCapabilities getBrowserCapabilities(String browserType) {

        DesiredCapabilities tmpCapabilites;

        if (browserType.equals("firefox")) {
            System.out.println("Opening firefox driver");
            tmpCapabilites = DesiredCapabilities.firefox();
        } else if (browserType.equals("chrome")) {
            System.out.println("Opening chrome driver");
            tmpCapabilites = DesiredCapabilities.chrome();
        } else {
            System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
            tmpCapabilites = DesiredCapabilities.firefox();
        }

        return tmpCapabilites;
    }
}
