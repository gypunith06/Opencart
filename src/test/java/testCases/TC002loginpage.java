package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccountpage;
import testBase.Baseclass;

public class TC002loginpage extends Baseclass {
	@Test(groups = {"Sanity","Master"})
	public void verifylogin() 
	{
		logger.info("***staring test cases***");
		try {
			
              Homepage hp = new Homepage(driver);
			hp.getmyaccunt();
			hp.clicklogin();
			Loginpage l = new Loginpage(driver);
			l.getmail(p.getProperty("email"));
			l.getpass(p.getProperty("pass"));
			l.getlogin();
			Myaccountpage mcc = new Myaccountpage(driver);
			boolean target = mcc.ismyaccountpageexist();
			Assert.assertTrue(target);
		}
		catch (Exception e) 
		{
			
			Assert.fail();
		}
			logger.info("***finished test cases***");
		}		
	}
	
	
