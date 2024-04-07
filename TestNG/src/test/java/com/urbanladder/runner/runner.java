package com.urbanladder.runner;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.urbanladder.pageObject.*;
import com.urbanladder.reusablecomponents.*;
import com.urbanladder.utilities.*;
import com.urbanladder.uistore.*;

public class runner {
	public static WebDriver driver;
	propertyFileReader pfr=new propertyFileReader();
	excelRead xl=new excelRead();
	extentReports er=new extentReports();
    Logger logger=Logger.getLogger( runner.class);
	@BeforeClass
	public void loadDriver() {
		driver=reusableComponents.driverload();	
		logger=Logger.getLogger("urbanLadder");
		PropertyConfigurator.configure("./Log4j.properties");
	}
	
	@Test(priority=0)
	public void loginTest() throws IOException {
		logger.info("*************TEST CASE 1***********");
		driver.get(pfr.getURL());
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(pfr.username());
		logger.info("Entered Username");
		lp.setPassword(pfr.password());
		logger.info("Entered Password");
		lp.loginBtn();
		if(driver.getTitle().equals(pfr.title1())) {
			Assert.assertTrue(true);
			logger.info("Logged in");
		}else {
			er.captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.warn("Login Test Failed");
		}
		lp.login();
		logger.info("Logged Out");
		lp.logout();
}
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider="LoginData",priority=1)
	public void loginTest1(String User,String pwd) throws IOException {
		LoginPage lp=new LoginPage(driver);
		logger.info("*************TEST CASE 2***********");
		driver.get(pfr.getURL());
		logger.info("URL is opened");
		lp.setUserName(User);
		logger.info("Entered Username");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		lp.loginBtn();
		logger.info("Login Button pressed");
		if(driver.getTitle().equals(pfr.title1())) {
			Assert.assertFalse(true);
			er.captureScreen(driver, "loginTest1");
			logger.warn("Test failed");
		}else {
			Assert.assertTrue(false);
			logger.info("Test Passed");
			}
		
	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/LoginData.xlsx";
		int rownum=excelRead.RowCount(path,"Sheet1");
		int colCount=excelRead.cellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colCount];
		for(int i=1;i<=rownum-1;i++) {
			for(int j=0;j<colCount;j++) {
				logindata[i-j][j]=excelRead.getCellData(path,"Sheet1", i, j);
			}
		}
		return logindata;
	}
	
	@Test(dataProvider="LoginData",priority=2)
	public void signup(String User,String pwd) throws IOException {
		logger.info("*************TEST CASE 3***********");
		driver.get(pfr.getURL());
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.login();
		lp.signup();
		lp.signup_login(User);
		logger.info("Username entered");
		lp.signup_pwd(pwd);
		logger.info("Entered Password");
		lp.signupbtn();
		logger.info("signup bUtton pressed");
		if(driver.getCurrentUrl().equals(pfr.url1())) {
			Assert.assertTrue(false);
			er.captureScreen(driver, "signup");
			logger.warn("Username already exists");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Signup Successful");
			
		}
	}
	@Test(priority=3)
	public void search() throws IOException {
		logger.info("*************TEST CASE 4***********");
		driver.get(pfr.getURL());
		logger.info("URL opened");
		searchPageObject spo=new searchPageObject(driver);
		spo.searchbar(pfr.search());
		spo.searchbtn();
		logger.info("search done");
		if(driver.findElement(searchPage.searchResult).getText().equals(pfr.searchResult()))
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else {
			Assert.assertFalse(false);
			er.captureScreen(driver, "search");
			logger.warn("test case failed");
		}
	}

	@Test(priority=4)
	public void seacrh1() throws IOException {
		logger.info("*************TEST CASE 5***********");
		driver.get(pfr.getURL());
		logger.info("URL opened");
		searchPageObject spo=new searchPageObject(driver);
		spo.study();
		logger.info("Seacrh done");
		spo.table();
		if(driver.getTitle().equals(pfr.title2())) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}else {
			Assert.assertFalse(false);
			er.captureScreen(driver, "search1");
			logger.warn("Test case failed");
		}
		}
	
	@Test(priority=5)
	public void addToCart() throws IOException {
		logger.info("*************TEST CASE 6***********");
		driver.get(pfr.getURL());
		logger.info("URL opened");
		searchPageObject spo=new searchPageObject(driver);
		spo.searchbar(pfr.search());
		spo.searchbtn();
		logger.info("search done");
		spo.diningTable();
		driver.get(pfr.url2());
		spo.Cart();
		logger.info("Added to cart");
		if(driver.getCurrentUrl().equals(pfr.url3()))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		} else{
			Assert.assertFalse(false);
			er.captureScreen(driver, "addToCart");
			logger.warn("Test case Failed");
			
		}
	}
	
	@Test(priority=6)
	public void trackOrder() throws IOException {
		logger.info("*************TEST CASE 7***********");
		driver.get(pfr.getURL());
		logger.info("URL opened");
		LoginPage lp=new LoginPage(driver);
		lp.trackorder();
		logger.info("track order opened");
		lp.orderNumber(pfr.order());
		logger.info("Order number Entered");
		lp.phoneNumber(pfr.phone());
		logger.info("Phone Number Entered");
		lp.submit();
		logger.info("Submitted");
		if(driver.findElement(homepage.trackText).getText().equals(pfr.text())){
		Assert.assertFalse(false);
		logger.warn("Test case Failed");
		er.captureScreen(driver, "trackOrder");
		}else {
		Assert.assertTrue(true);
		logger.info("Test case Passed");
		}
		}
	
	@Test(priority=7)
	public void stores() throws IOException {
		logger.info("*************TEST CASE 8***********");
		driver.get(pfr.getURL());
		logger.info("URL opened");
		searchPageObject spo=new searchPageObject(driver);
		spo.store();
		logger.info("Stores Location ");
		spo.viewDetail();
		logger.info("Details of the store");
		if(driver.findElement(searchPage.storeLoaction).getText().equals(pfr.text2())) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}else {
			Assert.assertFalse(false);
			logger.warn("Test case failed");
			er.captureScreen(driver, "stores");
		}
	}
	@Test(priority=8)
	public void help() throws IOException {
		logger.info("*************TEST CASE 9***********");
		driver.get(pfr.getURL());
		logger.info("URL opened");
		searchPageObject spo=new searchPageObject(driver);
		spo.help();
		logger.info("Help Page is Opened");
		spo.contact();
		logger.info("Contact Us page is opened");
		if(driver.findElement(searchPage.contactEmail).getText().equals(pfr.contactEmail())) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}else {
			Assert.assertFalse(false);
			logger.warn("Test case Failed");
			er.captureScreen(driver, "help");
		}
	}
	
	@Test(priority=9)
	public void helpSearhbar() throws IOException
	{
		logger.info("*************TEST CASE 10***********");
		driver.get(pfr.getURL());
		logger.info("URL opened");
		searchPageObject spo=new searchPageObject(driver);
		spo.help();
		logger.info("Help Page is Opened");
		spo.helpSearch(pfr.helpSearch());
		logger.info("Keyword Entered");
		spo.helpbtn();
		logger.info("Keyword searched");
		if(driver.findElement(searchPage.helpSearchResult).getText().equals(pfr.searchResult2())) {
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
			}else {
				Assert.assertFalse(false);
				logger.warn("Test Case Failed");
				er.captureScreen(driver, "helpsearch");
			}
		
	}
	
	@AfterClass
	public static void endTest() {
		driver.close();
	}
	
}
