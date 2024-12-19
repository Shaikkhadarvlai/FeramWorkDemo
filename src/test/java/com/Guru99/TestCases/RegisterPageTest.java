package com.Guru99.TestCases;

import org.testng.annotations.*;

public class RegisterPageTest extends BaseClass
{
   @Test(priority=1)
   public void ContactInformation_Test()
   {
	   rp.ContactInformation();
   }
	@Test(priority=2)
	public void  MailingInformation_Test()
	{
		rp.MailingInformation();
	}
   @Test(priority=3)
   public void countrydropdown_Test()
   {
	   rp.countrydropdown();
   }
   @Test(priority=4)
   public void UserInformation()
   {
	   rp.UserInformation();
   }
   @Test(priority=5)
   public void submitbutton()
   {
	   rp.submitbutton();
   }
}
