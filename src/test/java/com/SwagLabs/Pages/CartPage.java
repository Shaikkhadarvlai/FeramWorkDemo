package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage
{

	private WebDriver driver;
	
	public CartPage(WebDriver driver)//BAse class
	{
		this.driver=driver;
	}
	
	//locator
	private By cartPage=By.xpath("//a[@class='shopping_cart_link']");
	private By rbtn=By.xpath("//button[text()='Remove']");
	private By cbtn=By.xpath("//button[text()='Continue Shopping']");
	private By checkbtn=By.id("checkout");
	
	
	
	//methods
	
	public void getCartPage()
	{
		driver.findElement(cartPage).click();
		System.out.println("Cart page is open!");
	}
	
	
	public void doRemove()
	{
		driver.findElement(rbtn).click();
		System.out.println("Selected Product get removed!");
	}
	
	public void doContinueShopping()
	{
		driver.findElement(cbtn).click();
		System.out.println("Inventory page open: select Product");
		
	}
	
	public String doCheckOut()
	{
		driver.findElement(checkbtn).click();
	   return driver.getCurrentUrl();
		
	}
}