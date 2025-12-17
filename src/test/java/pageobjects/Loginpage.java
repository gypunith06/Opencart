package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{
	@FindBy(xpath = "//input[@placeholder='E-Mail Address']")
	WebElement setemail;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement setpass;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement logbtn;
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	public void getmail(String email)
	{
		setemail.sendKeys(email);
	}
	public void getpass(String pwd)
	{
		setpass.sendKeys(pwd);
	}
	public void getlogin()
	{
		logbtn.click();
	}
	
	
	

}
