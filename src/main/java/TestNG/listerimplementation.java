package TestNG;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listerimplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Throwable results = result.getThrowable();
		//Reporter.log(methodname+"testscript execution started"+results,true);
		test = report.createTest(methodname+"testscript execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		Throwable results = result.getThrowable();
//		Reporter.log(methodname+"testscript is passed"+results,true);
		test.log(Status.PASS, methodname+"testscript is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		Throwable message = result.getThrowable();
//		Reporter.log(methodname+"Test script execution failed"+message,true);
		webdriverUtils wb=new webdriverUtils();
		String Screenshotname=methodname+wb.Random();
		try {
			String path = wb.takescreenshots(baseClass.d,Screenshotname);
			//add screenshot to my extent reporter
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, methodname+"Testscript is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Throwable results = result.getThrowable();
//		Reporter.log(methodname+"testscript execution is skipped"+results,true);
		test.log(Status.SKIP, methodname+"testscript execution is skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		webdriverUtils wb=new webdriverUtils();
		//configuration of extent report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".//ExtentReporter/report"+wb.Random()+".html");
		htmlreport.config().setDocumentTitle("Aniket framework batch ");
		htmlreport.config().setReportName("vtigercrm");
		htmlreport.config().setTheme(Theme.STANDARD);
		
		
		//to add information to the report to extent report 
		 report=new ExtentReports();
		//to attach all the data to the report 
		report.attachReporter(htmlreport);
		report.setSystemInfo("Author", "Aniket");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser","Chrome");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//all data which is written in onstart method will be added or configured to onfinish report
		report.flush();
	}
}
