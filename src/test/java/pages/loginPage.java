package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	protected WebDriver driver;
	
	public By txtUsername = By.id("user-name");
	public By txtPassword = By.id("password");
	public By buttonLogin = By.id("login-button");
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(txtUsername).sendKeys(username);
		
	}
	public void enterPassword(String password)
	{
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void ClickButton() {
		driver.findElement(buttonLogin).click();
		
	}
	
	public void loginValidUser(String username, String password)
	{
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(buttonLogin).click();
	}

}
