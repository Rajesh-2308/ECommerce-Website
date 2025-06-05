package com.Sauce.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Sauce.Base.BaseClass;
import com.Sauce.Base.ExtentManager;
import com.Sauce.Base.TakeScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListeners implements ITestListener {

	private static ExtentReports reports;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onStart(ITestContext context) {
        // Initialize ExtentReports once before any tests start
        reports = ExtentManager.extentInstance();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extenttest = reports.createTest(result.getMethod().getMethodName());
		test.set(extenttest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(test.get()!=null) {
		test.get().log(Status.PASS, "Test Passed");
		}
		if(BaseClass.driver!=null) {
		TakeScreenshot screenshot = new TakeScreenshot();
		String screenshotPath = screenshot.getScreenshot(BaseClass.driver, result.getMethod().getMethodName());
		try{
				test.get().addScreenCaptureFromPath(screenshotPath);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(test.get()!=null) {
		test.get().log(Status.FAIL, "Test Failed");
		}
		TakeScreenshot screenshot = new TakeScreenshot();
		String screenshotPath = screenshot.getScreenshot(BaseClass.driver, result.getMethod().getMethodName());
		try{
			if(screenshot!=null) {
				test.get().addScreenCaptureFromPath(screenshotPath);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(test.get()!=null) {
		test.get().log(Status.SKIP, "Test Skipped");
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


	@Override
	public void onFinish(ITestContext context) {
			reports.flush();
	}

}
