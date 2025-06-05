package com.Sauce.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	static ExtentReports reports;

	public static ExtentReports extentInstance() {
		if (reports == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			reports = new ExtentReports();
			reports.attachReporter(reporter);
			reports.setSystemInfo("Environment", "Testing");
			reports.setSystemInfo("Tester", "Rajeshkumar R");
		}
		return reports;
	}

}
