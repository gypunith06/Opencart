package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import testBase.Baseclass;
import utilites.DataProviders;

public class TC003loginDDT extends Baseclass{

	
	@Test(dataProvider = "LoginData",dataProviderClass=DataProviders.class,groups = "Datadriven")
	public void verify_loginddt(String email, String pwd, String exp)
	{
		logger.info("****starting test cases****");
		try {
          Homepage h = new Homepage(driver);
          h.getmyaccunt();
          h.clicklogin();
		Loginpage l = new Loginpage(driver);
		l.getmail(email);
		l.getpass(pwd);
		l.getlogin();
		Myaccountpage mcc = new Myaccountpage(driver);
		boolean target = mcc.ismyaccountpageexist();
		if(exp.equalsIgnoreCase("valid"))
		{
			if(target==true)
			{
				mcc.getlogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
			if(exp.equalsIgnoreCase("invalid"))
			{
				if(target==true)
				{
					mcc.getlogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e)
		{
			Assert.fail();
		}
			logger.info("****finished test cases****");
		}
		
	}

