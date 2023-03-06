package org.testonics.omni.frameworks;

import org.testonics.omni.Interface.Omni;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testonics.omni.web.Browser;

public class Selenium implements Omni {

    public static WebDriver driver;
    public String url = "https://www.google.com";

    public void setDriver(){
        driver = Browser.getWebDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeDriver(){
        driver.close();
        driver.quit();
    }

    public void navigate(){
        driver.get(url);
    }

    @Override
    public void click(Object element) {
        WebElement webElement = getWebElement(element);
        webElement.click();
    }

    @Override
    public void enter(Object element, String value) {
        WebElement webElement = getWebElement(element);
        webElement.sendKeys(value);
        webElement.submit();
    }

    @Override
    public void select(Object element, Object value) {
        WebElement webElement = getWebElement(element);
        Select dropDown = new Select(webElement);
        if (value instanceof String) {
            dropDown.selectByValue((String) value);
        }else{
            dropDown.selectByIndex((Integer) value);
        }

    }

    WebElement getWebElement(Object element){
        if (element instanceof String)
            return driver.findElement(By.xpath((String) element));
        else
            return (WebElement) element;
    }
}
