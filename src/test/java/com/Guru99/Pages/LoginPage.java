package com.Guru99.Pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class LoginPage 
{

	private WebDriver driver;
	
	
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Locators
	
	private By username=By.name("userName");
	private By password=By.name("password");
	private By submit=By.name("submit");
	
	
	
	
	//Methods
	public String Loginuser_and_pass(String uname,String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		String curl=driver.getCurrentUrl();
		return curl;
		
	}
	public void submitbutton()
	{
		driver.findElement(submit).click();
	}
	public void statusCodeTest()
	{
		WebElement successMessage = driver.findElement(By.xpath("//h3[text()='Login Successfully']")); 
		Assert.assertEquals(successMessage.getText(), "Login Successfully", "Login status message did not match!");
        System.out.println("The login is successfull"); 
	}
	
}
