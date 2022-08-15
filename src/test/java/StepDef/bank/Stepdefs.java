package StepDef.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

    @Given("^I have an account file with contents:$")
    public void i_have_an_account_file_with_contents(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @When("^I parse the file$")
    public void i_parse_the_file() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Then("^the first account number is \"([^\"]*)\"$")
    public void the_first_account_number_is(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }

    @Given("^am I on the todo page$")
    public void am_I_on_the_todo_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I type the todo \"([^\"]*)\"$")
    public void i_type_the_todo(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^todo list item (\\d+) has text \"([^\"]*)\"$")
    public void todo_list_item_has_text(int arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I have (\\d+) cukes in my belly$")
    public void i_have_cukes_in_my_belly(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

}
