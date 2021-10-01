package com.SwiZo.GenericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportListeners implements ITestListener
	{

		public static ExtentReports extent;
		public static ExtentTest test;
		
		
		public void onTestStart(ITestResult result) {
			test=extent.createTest(result.getName());
			test.log(Status.INFO, result.getName()+" Method Started");

		}
		
		public void onTestSuccess(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.pass(MarkupHelper.createLabel(result.getName()+" case has PASSED", ExtentColor.GREEN));
		}

		public void onTestFailure(ITestResult result) 
		{
			test=extent.createTest(result.getName());
			test.fail(MarkupHelper.createLabel(result.getName()+" case has FAILED because of following reasons: ", ExtentColor.RED));
			test.fail(result.getThrowable());
			WebDriverCommonLib wlib = new WebDriverCommonLib();
			wlib.getFullPageScreenshot(result.getName());
			test.addScreenCaptureFromPath(wlib.getFullPageScreenshot(result.getName()));
		}
		public void onTestSkipped(ITestResult result) {
			test=extent.createTest(result.getName());
			test.skip(MarkupHelper.createLabel(result.getName()+" case has SKIPPED because of following reasons: ", ExtentColor.PINK));
			test.skip(result.getThrowable());
		}

		public void onStart(ITestContext context) 
		{
			ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\L e n o v o\\git\\repository\\SwiZo\\Reports\\First6.html");
			//Customising report view
			spark.config().setDocumentTitle("SwiZo Reports");
			spark.config().setReportName("Extent Reports 5");
			spark.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(spark);
			//setting system info
			extent.setSystemInfo("Author", "Mukesh");
			extent.setSystemInfo("OS", "Windows 10");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("TestRunner Name", context.getName());
			
		}

		public void onFinish(ITestContext context) 
		{
			//Writing all logs into report
			extent.flush();
		}

	}

	
	
	
	
	
	
	
	

