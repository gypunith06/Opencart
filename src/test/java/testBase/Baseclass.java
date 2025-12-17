package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p ;
	public DesiredCapabilities cap;
	@BeforeClass(groups = {"Regression","Sanity","Master"})
	@Parameters({"os","browser"})

	public void setup(String os,String br) throws InterruptedException, IOException
	{
		   FileInputStream file= new FileInputStream("./src//main//resources//cofig.properties");
		p=new Properties();
	     p.load(file);
		logger=LogManager.getLogger(this.getClass());
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			
			}
			else
			{
				System.out.println("no matching os");
			}
			
			switch (br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			case "firefox":cap.setBrowserName("firefox");break;
			default:System.out.println("no matching browser");return;	
			}
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
			
        //  driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		if(p.getProperty("execution_env").equalsIgnoreCase("Local"))
		{
		switch (br.toLowerCase()) {
		case "chrome":driver= new ChromeDriver();break;
		case "edge":driver= new EdgeDriver();break;
		case "firefox":driver= new FirefoxDriver();break;
		default:System.out.println("invalid browse");return;
		}
		}
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  //driver.get("https://tutorialsninja.com/demo/");
   driver.get( p.getProperty("appurl1"));
 //Thread.sleep(5000);
	}
	@AfterClass(groups = {"Regression","Sanity","Master"})
	public void teardown()
	{
		driver.quit();
	}
	public String getrandomstring()
	{
		String genstring = RandomStringUtils.randomAlphabetic(5);
		return genstring;
	}
	public String getrandomnumber()
	{
		String geennum = RandomStringUtils.randomNumeric(10);
		return geennum;
	}
	public String getrandomalphanum()
	{
		String geennumalpha = RandomStringUtils.randomAlphanumeric(5, 5);
		return geennumalpha;
	}
	public String captureScreen(String tname) throws IOException 
	{
		Date d = new Date();
		String dt = d.toString().replaceAll(":", "-");
		TakesScreenshot tss = (TakesScreenshot)driver;
		File temp = tss.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir")+"./screenshots/"+tname+"_"+dt+".png";
		File perm = new File(filepath);
		org.openqa.selenium.io.FileHandler.copy(temp, perm);
		return filepath;
		
		
		
	
		
	}

}
