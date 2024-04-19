package com.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	
	ExtentReports  report;
	ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log("execution starts from here", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName);
		Reporter.log(MethodName+"---executed successfully");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	try {
			String screenshot = WebDriverUtility.getScreenShot(BaseClass.sdriver,MethodName);
			test.log(Status.FAIL, MethodName+"---failed");
			test.log(Status.FAIL, result.getThrowable());
			
			test.addScreenCaptureFromPath(screenshot);
			
			Reporter.log(MethodName+"---failed");
	}
	catch(Throwable e) {
		e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"----skipped");
		}

	
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("BANKING");
		htmlreport.config().setReportName("COIN_FIRST");
		htmlreport.config().setTheme(Theme.DARK);
		
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Platform","windows");
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("Base_URL", "http://rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("ReporterName", "Vaishnavi");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}


