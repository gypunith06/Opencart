package utilites;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Baseclass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter SparkReporter; 
	public ExtentReports extent;
	public ExtentTest test;
	String repName ;
	public void onStart(ITestContext testContext) {
		Date dt = new Date();
		String TimeStamp = dt.toString().replaceAll(":", "-");
		 repName = "test-Report-"+TimeStamp+".html";
		 SparkReporter = new ExtentSparkReporter("./reports/"+repName);
		SparkReporter.config().setDocumentTitle(" OpenCart Automation report");
		SparkReporter.config().setReportName("OpenCart Functional testing");
		SparkReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(SparkReporter);
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Custoomer");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Enviornament", "QA");
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty()) {
			extent.setSystemInfo("Grups", includeGroups.toString());
		}
	}
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"got succesfully executed");
	}
	public void onTestFailure(ITestResult result) {
		 test = extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+"got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		 Baseclass b = new Baseclass();
		 String imagepath;
		try {
			imagepath = b.captureScreen(result.getName());
			test.addScreenCaptureFromPath(imagepath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName()+"got skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		String pathofExtentReport = System.getProperty("user.dir")+"./reports/"+repName;
		File ExtentReport = new File(pathofExtentReport);	
	    try {
			Desktop.getDesktop().browse(ExtentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	     
	}

}
