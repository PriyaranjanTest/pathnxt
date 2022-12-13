package com.pathnxt.commonUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * 
 * @author -Priyaranjan Mohanty-
 *
 */
public class listenersImplementation  implements ITestListener 
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		test=report.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		String testName= result.getMethod().getMethodName();
		System.out.println("---------------i am ilstrening------------");
		TakesScreenshot screenshot=(TakesScreenshot)baseClass.driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		LocalDateTime localDateTime = LocalDateTime.now();
		String dateTime= localDateTime.toString().replace(" ", "_").replace(":","_");
		File dst = new File("screenshots/"+"_"+testName+"-"+dateTime+".PNG");
		try {
			FileUtils.copyFile(src, dst);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("problem in saving screenshot"+e.getMessage());
		}

	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) 
	{

		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report.html");

		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Framework Extent Report");
		spark.config().setDocumentTitle("Priyaranjan's document");

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "priyaranjan");
		report.setSystemInfo("ReviwedBy", "priyaranjan");
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("browser", "Google Chrome");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();

	}

}
