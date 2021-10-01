package com.SwiZo.GenericLib;



import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class CustomReports
{
	@Test
	public void runReports()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\L e n o v o\\git\\repository\\SwiZo\\Invoices.xml");
		spark.config().setReportName("Mukesh Report");
		spark.config().setDocumentTitle("SwiZo Report");
		spark.config().setTheme(Theme.STANDARD);
		ExtentReports repo = new ExtentReports();
		
		repo.attachReporter(spark);
		
		ExtentTest test = repo.createTest("SalesTest").assignAuthor("Mukesh").assignCategory("SmokeTest")
				.assignDevice("Windows10_Chrome");
		
		test.log(Status.PASS,"PASS");
		
		repo.flush();
		
	}	

}
