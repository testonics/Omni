package TestTestng.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import in.testonics.omni.web.Browser;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void launchURL() {
        //Creating an object of ChromeDriver
        WebDriver driver = Browser.getWebDriver();

        driver.get("https://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

}
