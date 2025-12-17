package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myac;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement reg;
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginlink;
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
    public void getmyaccunt( )
    {
    	myac.click();
    }
    public void getregister( )
    {
    	reg.click();
    }
    public void clicklogin()
    {
    	loginlink.click();
    }
}
