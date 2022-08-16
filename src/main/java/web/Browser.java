package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
	
	public static WebDriver getWebDriver() {

		WebDriver driver;

		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Projects\\Github\\TAF\\src\\main\\resources\\drivers\\chromedriver_104.exe");
		String browser = System.getProperty("browser");

		if(browser.equals("firefox")) {
			driver =  new FirefoxDriver();
		} else if(browser.equals("chrome")) {
			driver =  new ChromeDriver();
		} else if(browser.equals("msie")) {
			driver =  new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Unrecognized system property 'browser': " + browser);
		}

		driver.manage().window().maximize();

		//Deleting all the cookies
		driver.manage().deleteAllCookies();

		//Specifiying pageLoadTimeout and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}
}
