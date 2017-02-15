package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DemoQAPage {

    public static final String URL = "http://demoqa.com/";
    
    private static WebElement element = null;
    
    public static WebElement registration(WebDriver driver){
        element = driver.findElement(By.xpath("//li[contains(.,'Registration')]"));
    
        Assert.assertTrue(element.isDisplayed(), "Elem létezésének ellenőrzése.");
        return element;
    }
    
    public static void assertPage(WebDriver driver){
        Assert.assertEquals(driver.getTitle(), "Demoqa | Just another WordPress site");
    }

    public static WebElement tab(WebDriver driver, int num) {
        element = driver.findElement(By.cssSelector(String.format("#ui-id-%d", num)));

        Assert.assertTrue(element.isDisplayed(), "Tab 1 megvan!");

        return element;
    }


    public static WebElement tabTitle(WebDriver driver, int num) {
        element = driver.findElement(By.cssSelector(String.format("#tabs-%d>b", num)));

        Assert.assertEquals(element.getText(), String.format("Content %d Title", num));

        return element;
    }

}
