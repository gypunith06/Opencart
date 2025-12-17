package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Accountregistrationpage;
import pageobjects.Homepage;
import testBase.Baseclass;

public class TC001Accontregistrationpage extends Baseclass{
	
	@Test(groups = {"Regression","Master"})
	public void verifyaccontreg()
	{
		logger.info("--starting account registration test--");
		
		
		try {
			Homepage h = new Homepage(driver);
		
		h.getmyaccunt();
		logger.info("clicked my account");
		h.getregister();
		logger.info("clicked registration button");
		Accountregistrationpage a = new Accountregistrationpage(driver);
		logger.info("providing registration details");
		a.getfsname(getrandomstring().toUpperCase());
		a.getlsname(getrandomstring().toLowerCase());
		a.getemil(getrandomstring()+"@gmail.com");
		a.getel(getrandomnumber());
	String	password=getrandomalphanum();
		a.getpassword(password);
		a.getconfpass(password);
		a.getsub();
		a.getprivacy();
		a.getbutton();
		logger.info("validating expected message");
		String msg = a.getconfirmationmsg();
		if(msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("test failed");
			Assert.fail();
		}
		
		Assert.assertEquals(msg, "Your Account Has Been Created!");
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("finshed test cases");

	
	}
}
