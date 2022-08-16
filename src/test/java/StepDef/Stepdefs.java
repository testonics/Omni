package StepDef;

import cucumber.api.java.en.Given;
import mobile.android;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import web.Browser;

public class Stepdefs {

    @Given("^Login and Search Google$")
    public void loginAndSearch() throws Throwable {

        //Creating an object of ChromeDriver
        WebDriver driver = Browser.getWebDriver();

        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    @Given("^Execute Rest API$")
    public void executeRestAPI(){
        //ToDo
    }

    @Given("^launch mobile app$")
    public void launchMobileApp(){
        android android = new android();
        android.setDriver();
        RemoteWebDriver driver = android.getDriver();
//        System.out.println("Driver Title : " + driver.getTitle());
    }

}
