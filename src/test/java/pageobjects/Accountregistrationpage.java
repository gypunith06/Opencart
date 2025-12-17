package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends Basepage {
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement fsname;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lsname;
	@FindBy(xpath = "//input[@placeholder='E-Mail']")
	WebElement email;
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement tel;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//input[@name='confirm']")
	WebElement conf;
	@FindBy(xpath = "//input[@value='0']")
	WebElement sub;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement button;
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgcon;
	public Accountregistrationpage(WebDriver driver)
	{
		super(driver);
	}
	public void getfsname(String fname)
	{
		fsname.sendKeys(fname);
	}
	public void getlsname(String lname)
	{
		lsname.sendKeys(lname);
	}
	public void getemil(String em)
	{
		email.sendKeys(em);
	}
	public void getel(String num)
	{
		tel.sendKeys(num);
	}
	public void getpassword(String passwor)
	{
		password.sendKeys(passwor);
	}
	public void getconfpass(String pass)
	{
		conf.sendKeys(pass);
	}
	
	public void getsub()
	{
		sub.click();
	}
	public void getprivacy()
	{
		privacy.click();
	}
	public void getbutton()
	{
		button.click();
	}
	public String getconfirmationmsg()
	{
		 try {
			return(msgcon.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	

}
