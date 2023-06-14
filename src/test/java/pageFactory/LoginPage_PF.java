package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {
	
	WebDriver driver;
	
	@FindBy(id = "user-name" )
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	public LoginPage_PF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUsername(String Username)
	{
		txtUsername.sendKeys(Username);
	}
	
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void ClickLoginButton()
	{
		loginButton.click();
	}
	

}
