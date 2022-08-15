package StepDef;

import TestngTest.endpoints.UserEndpoints;
import com.google.gson.Gson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.jsonUtils;
import web.Browser;
import api.hooks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Stepdefs {

    @Given("^Login and Search Google$")
    public void loginAndSearch() throws Throwable {
        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Projects\\Github\\TAF\\src\\main\\resources\\drivers\\chromedriver_104.exe");

        //Creating an object of ChromeDriver
        WebDriver driver = Browser.launch();
        driver.manage().window().maximize();

        //Deleting all the cookies
        driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    @Given("^Execute Rest API$")
    public void executeRestAPI(){
    }

//    @Given("^I have an account file with contents:$")
//    public void i_have_an_account_file_with_contents(String arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
//    }
//
//    @When("^I parse the file$")
//    public void i_parse_the_file() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
//    }
//
//    @Then("^the first account number is \"([^\"]*)\"$")
//    public void the_first_account_number_is(String arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
//    }
//
//    @Given("^am I on the todo page$")
//    public void am_I_on_the_todo_page() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    }
//
//    @When("^I type the todo \"([^\"]*)\"$")
//    public void i_type_the_todo(String arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    }
//
//    @Then("^todo list item (\\d+) has text \"([^\"]*)\"$")
//    public void todo_list_item_has_text(int arg1, String arg2) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    }
//
//    @Given("^I have (\\d+) cukes in my belly$")
//    public void i_have_cukes_in_my_belly(int arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    }
//
//    @When("^I wait (\\d+) hour$")
//    public void i_wait_hour(int arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    }
//
//    @Then("^my belly should growl$")
//    public void my_belly_should_growl() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    }

}
