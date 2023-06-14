package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage_PF;
import pages.loginPage;

public class Registration_PF {
	WebDriver driver=null;
	@Before
	public void BrowserSetup()
	{
		System.out.println("I am inside Browser Setup");
		System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void TearDown() {
		System.out.println("I am inside Tear Down setup");
		driver.close();
		driver.quit();
	}
	
	LoginPage_PF login1;

	
	@Given("launch the url")
	public void launch_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get("https://www.saucedemo.com/?ref=hackernoon.com");
		System.out.println("I am inside Page factory login steps!");
		
	    
	}

	@When("the user enters {string} and {string}")
	public void the_user_enters_username_and_password(String Username, String Password) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		login1 = new LoginPage_PF(driver);
		login1.enterUsername(Username);
		login1.enterPassword(Password);
		/*
		 * loginPage login = new loginPage(driver); login.enterUsername(Username);
		 * login.enterPassword(Password);
		 */
//		driver.findElement(By.id("user-name")).sendKeys(Username);
//		driver.findElement(By.id("password")).sendKeys(Password);
	    
	}

	@Then("the user clicks on Login button")
	public void the_user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete 
		login1.ClickLoginButton();
//		driver.findElement(By.id("login-button")).click();
	    
	}

	@And("the user validates the Login success")
	public void the_user_validates_the_login_success() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login testing Completed !!");
		Thread.sleep(2000);
		
	    
	}


}
