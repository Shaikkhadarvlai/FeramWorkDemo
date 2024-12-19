package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{

	//Encapsulation=data(private)+Method(public)
	
	private WebDriver driver;
	
	//initialization driver
	public LoginPage(WebDriver driver)//BAse class
	{
		this.driver=driver;
	}
	
	
	//Locators
	private By username=By.xpath("(//input[@class='input_error form_input'])[1]");
	
	private By password=By.id("password");
	
	private By loginbtn=By.name("login-button");
	
	
	//Methods
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	public String doLogin(String un,String psw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(loginbtn).click();
		String curl=driver.getCurrentUrl();
		return curl;
		
	}
	
	
}