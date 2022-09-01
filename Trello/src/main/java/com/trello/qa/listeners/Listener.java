package com.trello.qa.listeners;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.trello.qa.base.TestBase;
import com.trello.qa.utils.TakeScreenshot;


public class Listener implements ITestListener
{
	String Starttime;
	String endtime;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  

	@Override
	public void onFinish(ITestContext arg0) 
	{
			}

	@Override
	public void onStart(ITestContext arg0) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		//ExtentReport.logger= ExtentReport.report.startTest(arg0.getName());
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test Case Current URL : " + TestBase.driver.getCurrentUrl());
		System.out.println("Test Case failed : " + (arg0.getMethod().getMethodName()));
		try {
			TakeScreenshot.takeScreenshotAtEndOfTest(arg0.getMethod().getMethodName());
			 System.out.println("Successfully captured a screenshot");		 
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screenshot failed");
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
	    System.out.println("The name of the testcase Skipped is :"+arg0.getMethod().getMethodName());					

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		   LocalDateTime now = LocalDateTime.now();  
		   Starttime =dtf.format(now);
		   System.out.println("Test Case "+arg0.getMethod().getMethodName()+" started at " + Starttime);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test Case successfully Passed : " + (arg0.getMethod().getMethodName()));
		System.out.println("Test Case Current URL : " + TestBase.driver.getCurrentUrl());

		   
	}
	
	

}
