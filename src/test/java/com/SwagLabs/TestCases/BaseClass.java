package com.SwagLabs.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.SwagLabs.Pages.CartPage;
import com.SwagLabs.Pages.CheckOutPage;
import com.SwagLabs.Pages.InventoryPage;
import com.SwagLabs.Pages.LoginPage;
import com.SwagLabs.Pages.OverviewPage;
import com.SwagLabs.utility.PropertiesUtil;
import com.SwagLabs.utility.Utility;
import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	public CheckOutPage ch;
	public OverviewPage op;
	public PropertiesUtil p1;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@BeforeSuite
	public void reports()
	{
		//create ExtentReport instance
		  extent = new ExtentReports();
		  
		  //Using reporter we can add path
		spark = new ExtentSparkReporter("Reports/SwagLab.html");
		  
		  //setup any configuration
		  spark.config().setDocumentTitle("Sprint1 report");
		  spark.config().setReportName("SwagLabAutomation Report");
		  spark.config().setTheme(Theme.DARK);
		  
		  
		  //attached the report
    	  extent.attachReporter(spark);
		  
		  
		  //Create a test-ExtentTest
		  test=extent.createTest("SwagLaba End To End Report");
		  
	}
	
	@BeforeTest//For all Pages Browser setup
	public void setUpBrowser()
	{
		p1=new PropertiesUtil();
		driver=new ChromeDriver();
		Reporter.log("Log: Driver session is created",true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p1.getData("url"));
		Reporter.log("Log: Apllication is open",true);
		test.pass("SwagLab Application open Successfully!");
		
		lp=new LoginPage(driver);
		ip=new InventoryPage(driver);
		cp=new CartPage(driver);
		ch=new CheckOutPage(driver);
		op=new OverviewPage(driver);
		
		
	}
	
	
	@BeforeClass//Page preconditions
	public void pageSetUp()
	{   System.out.println("**********Login Page***********");
		System.out.println("Url is: "+lp.getUrl());
		Reporter.log("Log: Login page is open",true);
		System.out.println("Title is: "+lp.getAppTitle());
		Utility.getScreenshot(driver);
		lp.doLogin(p1.getData("un"),p1.getData("psw"));
		Reporter.log("Log:Login is completed with valid data set",true);
		test.pass("Login completed!");
		addWait();
		Utility.getScreenshot(driver);
		System.out.println("**********Inventory Page***********");
		System.out.println("Total Product Count is: "+ip.getProductCount());
		ip.getProductName();
		addWait();
		Utility.getScreenshot(driver);
		ip.addToCart(p1.getData("pname1"));
		addWait();
		Utility.getScreenshot(driver);
		cp.getCartPage();
		addWait();
		Utility.getScreenshot(driver);
		test.pass("Inventory page validation completed!");
		System.out.println("**********Cart Page***********");
		cp.doRemove();
		Utility.getScreenshot(driver);
		addWait();
		cp.doContinueShopping();
		Utility.getScreenshot(driver);
		ip.addToCart(p1.getData("pname2"));
		cp.getCartPage();
		addWait();
		Utility.getScreenshot(driver);
		cp.doCheckOut();
		Utility.getScreenshot(driver);
		test.pass("Cart page validation completed!");

		System.out.println("**********Checkout page***********");
		ch.doContinue(p1.getData("fn"),p1.getData("ln"),p1.getData("zc"));
		test.pass("Checkout page validation completed!");

		System.out.println("**********Overview page***********");
		test.pass("Overview page validation completed!");

		
		

		
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
	
	
	@AfterSuite
	public void exitReport()
	{
		extent.flush();
	}
}