package com.Guru99.TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass
{
	@Test(priority=1)
	public void testfunctions()
	{
		String curl=pg.Loginuser_and_pass("uname","pass");
		Assert.assertTrue(curl.contains("newtours"),"The Login is not complite");
		System.out.println("The Login is complete");
	}
	@Test(priority=2)
	public void submit()
	{
		pg.submitbutton();
	}
    @Test(priority=3)
    public void statuscke()
    {
    pg.statusCodeTest();
     
    }
	
	
}
