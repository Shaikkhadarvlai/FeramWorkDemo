package com.Guru99.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SwagLabs.utility.Utility;

public class RegisterPage 
{
	private WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	//Locators
	//  Contact Information write locators
	private By registerButton=By.xpath("//a[text()='REGISTER']");
	private By FirstName =By.name("firstName");
	private By LastName =By.name("lastName");
	private By Phone =By.name("phone");
	private By  Email =By.name("userName");
	
	
	  //Mailing Information
    private By Address=By.name("address1");
    private By city=By.name("city");
    private By StateProvince=By.name("state");
    private By postalCode=By.name("postalCode");
    private By country=By.name("country");
    
	// User Information
    private By UserName=By.name("email");
    private By password=By.name("password");
    private By confirmPassword=By.name("confirmPassword");
    private By submit=By.name("submit");
    
    
    //methods 
    public void ContactInformation()
    
    {
    	driver.findElement(registerButton).click();
    	
    	
    	driver.findElement(FirstName).sendKeys("Khadar vali");
    	driver.findElement(LastName).sendKeys("vali.shaik");
    	driver.findElement(Phone).sendKeys("9347249755");
    	driver.findElement(Email).sendKeys("vali18@gmail.com");
    }
    
    public void MailingInformation()
    {
    	driver.findElement(Address).sendKeys("12/45/555");
    	driver.findElement(city).sendKeys("giddalur");
    	driver.findElement(StateProvince).sendKeys("prakasham");
    	driver.findElement(postalCode).sendKeys("523345");
   	
    }
    public void countrydropdown()
    {
    	WebElement dropdown=driver.findElement(country);
      Utility.selectBasedDropdown(dropdown,"ZIMBABWE");
    }
    public void   UserInformation()
    {
    	driver.findElement(UserName).sendKeys("Admin");
    	driver.findElement(password).sendKeys("admin123");
    	driver.findElement(confirmPassword).sendKeys("admin123");
    }

    public void submitbutton()
    {
    	driver.findElement(submit).click();
    }
    
    
	
	
	
}
