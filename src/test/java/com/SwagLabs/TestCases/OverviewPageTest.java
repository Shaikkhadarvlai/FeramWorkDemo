package com.SwagLabs.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.SwagLabs.utility.Utility;

import org.testng.annotations.Test;

public class OverviewPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifySummary()
  {
	 
	  op.getSummary();
	  Utility.getScreenshot(driver);
  }
  
  @Test(priority=2)
  public void verifyOverview()
  {
	  op.doFinish();
	  Utility.getScreenshot(driver);
  }
  
}