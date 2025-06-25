package utilities;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

import testBase.BaseClass_withReusableMethods;

import java.util.List;

public class ExtentReports_implementingListener implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; 
	public ExtentReports extReports;
	public ExtentTest extTest;
	
	String reportName;
	
	
	public void onStart(ITestContext context) {
		System.out.println("onStart Triggered");
		Date d= new Date();
		SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String formattedDate = fd.format(d);
				
		reportName="Automation_Test_Report_"+ formattedDate +".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\extentReports\\"+reportName);
		
		sparkReporter.config().setDocumentTitle("Automation Testing Report");
		sparkReporter.config().setReportName("OpenCart Functional Testing Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extReports = new ExtentReports();
		
		extReports.attachReporter(sparkReporter);
		extReports.setSystemInfo("Application", "OpenCart");
		extReports.setSystemInfo("Tester", System.getenv("user.name"));
		extReports.setSystemInfo("Test Environment", "QA");
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extReports.setSystemInfo("Operating System", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extReports.setSystemInfo("Browser", browser);
		
		List<String> groups = (List<String>) context.getCurrentXmlTest().getIncludedGroups();
		if(!groups.isEmpty())
			{
			extReports.setSystemInfo("Groups", groups.toString());
			}
	}

	
	public  void onTestSuccess(ITestResult result) {
		 System.out.println("onTestSuccess Triggered");
		 
		 extTest =extReports.createTest(result.getTestClass().getName());
		 extTest.assignCategory(result.getMethod().getGroups());
		 extTest.log(Status.PASS,result.getName() + "got Successfully executed");
		 
		  }
	
	
	public  void onTestFailure(ITestResult result) {
		 System.out.println("onTestFailure Triggered");
		 extTest =extReports.createTest(result.getTestClass().getName());
		 extTest.assignCategory(result.getMethod().getGroups());
		 extTest.log(Status.FAIL,result.getName() + "got Failed");
		 extTest.log(Status.INFO,result.getThrowable().getMessage());
		 
		 try {
			 String ssPath = new BaseClass_withReusableMethods().takeScreenshot(result.getName());
			 extTest.addScreenCaptureFromPath(ssPath);
		 	}
		 		catch(Exception e){
		 			e.printStackTrace();
		 							}
		}
	
	public  void onTestSkipped(ITestResult result) {
		 System.out.println("onTestSkipped Triggered");
		 
		 extTest =extReports.createTest(result.getTestClass().getName());
		 extTest.assignCategory(result.getMethod().getGroups());
		 extTest.log(Status.SKIP,result.getName() + "got Skipped");
		 extTest.log(Status.INFO,result.getThrowable().getMessage());
		  }
	
	
	public  void onFinish(ITestContext context) {
		 System.out.println("onFinish Triggered");
		 
		 extReports.flush();
		 String extentReportPath = System.getProperty("user.dir")+"\\extentReports\\"+reportName;
		 File extentReport = new File(extentReportPath);
		 
		 try {
			 Desktop.getDesktop().browse(extentReport.toURI());
			  }catch(IOException e) {
				  e.printStackTrace();
			  }
		  }

	}
	