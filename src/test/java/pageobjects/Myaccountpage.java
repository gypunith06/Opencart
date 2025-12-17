package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage {
	public Myaccountpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgheading;
	@FindBy(xpath = "//a[@class='list-group-item'][13]")
	WebElement logout;
	public boolean ismyaccountpageexist()
	{
		try {
			return(msgheading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
		
	}
	public void getlogout()
	{
		logout.click();
	}

}
