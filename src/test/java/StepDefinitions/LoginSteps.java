package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Inside SD - Login page!");
	   
		
	}

	@When("user enters user1 and pass1")
	public void user_enters_user1_and_pass1() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside SD - Enter creds!");
		   
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside SD - Click login button!");
		   
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside SD - Home page!");
		    new io.cucumber.java.PendingException();
	}

}
