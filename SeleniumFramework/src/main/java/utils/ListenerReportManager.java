package utils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ListenerReportManager implements ITestListener, IAnnotationTransformer {

	public ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public ExtentTest logger;
	
	public String reportName;
	public Method testMethod;
	

	@Override
	public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	

	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		logger = extent.createTest("Test case method : " + result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test case failed " , ExtentColor.RED));
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test case failed " , ExtentColor.RED));

		try {
			String imgPath = new BaseTest().captureScreen(result.getName());
			logger.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		logger = extent.createTest("Test case method : " + result.getName());
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " - Test case skipped ", ExtentColor.ORANGE));

		try {
			String imgPath = new BaseTest().captureScreen(result.getName());
			logger.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}



	@Override
	public void onStart(ITestContext context) {
		 
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
		
		reportName = "Test-Report - " + timeStamp + ".html" ;

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ExtentReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation tests results by Project QA Team");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Super Admin");
		extent.setSystemInfo("Environment", "Staging");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));

		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("OS", os);

		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

	}
	@Override
	public void onTestSuccess(ITestResult result) {

		logger = extent.createTest("Test case method : " + result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case passed ", ExtentColor.GREEN));

		try {
			String imgPath = new BaseTest().captureScreen(result.getName());
			logger.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
		
	/*	EmailService es = new EmailService();
		es.emailReport(); */

	}	
	
}
