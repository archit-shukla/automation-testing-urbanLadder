package com.urbanladder.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReports extends TestListenerAdapter {
	public ExtentSparkReporter htmlReporter;
	public ExtentTest Logger;
	public ExtentReports extent;
	
	public void onStart(ITestContext testContext) {
		String  timeStamp =new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String repName="test-report"+timeStamp+".html";
		htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Archit");
		
		htmlReporter.config().setDocumentTitle("Urban Ladder Test");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr) {
		Logger=extent.createTest(tr.getName());
		Logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
		
		public void onTestFailure(ITestResult tr) {
			Logger=extent.createTest(tr.getName());
			Logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));	
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenshotPath);
		if(f.exists()) {
			Logger.fail("Screenshot is below"+Logger.addScreenCaptureFromPath(screenshotPath));
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		Logger=extent.createTest(tr.getName());
		Logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
