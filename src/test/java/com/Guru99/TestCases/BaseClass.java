package com.Guru99.TestCases;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.Guru99.Pages.LoginPage;
import com.Guru99.Pages.RegisterPage;
import com.SwagLabs.utility.PropertiesUtil;
import com.SwagLabs.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage pg;
	public RegisterPage rp;
	
	public PropertiesUtil p1;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	
	@BeforeSuite
	public void ExtendsReports()
	{
		//create ExtentReport instance
		  extent = new ExtentReports();
		  
		  //Using reporter we can add path
		spark = new ExtentSparkReporter("Reports/Guru99register.html");
		  
		  //setup any configuration
		  spark.config().setDocumentTitle("Sprint1 report");
		  spark.config().setReportName("Guru99registerAutomation Report");
		  spark.config().setTheme(Theme.DARK);
		  
		  
		  //attached the report
  	  extent.attachReporter(spark);
		  
		  
		  //Create a test-ExtentTest
		  test=extent.createTest("Guru99register End Report");
		  
		
	}
	@BeforeTest
	public void SetUpBrowser()
	{
		p1=new PropertiesUtil();
	     driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		pg=new LoginPage (driver);
	   rp=new RegisterPage(driver);
		
		
	}
	@BeforeClass
	public void SetUpPage()
	{ System.out.println("**********Login Page***********");
	Reporter.log("Log: Login page is open",true);
	   pg.Loginuser_and_pass("uname","pass");
		
		//pg.Loginuser_and_pass(p1.getData("unmae"),p1.getData("pass"));
		Reporter.log("Log:Login is completed with valid data set",true);
		test.pass("Login completed!");
		pg.submitbutton();
		pg.statusCodeTest();
		Utility.getScreenshot(driver);
		addWait();
		
		System.out.println("**********Register Page***********");
		 rp.ContactInformation();
		 addWait();
		 rp.MailingInformation();
		 addWait();
		 rp.countrydropdown();
		 addWait();
		 rp.UserInformation();
		 addWait();
		 rp.submitbutton();
		 Utility.getScreenshot(driver);
		 
		 
	}
	
	public void addWait()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void exitReport()
	{
		extent.flush();
	}

}
