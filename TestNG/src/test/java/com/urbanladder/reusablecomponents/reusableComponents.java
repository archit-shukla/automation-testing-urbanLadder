package com.urbanladder.reusablecomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.urbanladder.utilities.propertyFileReader;



public class reusableComponents {
	static propertyFileReader pfr=new propertyFileReader();
	static String browser=pfr.browser();
	@SuppressWarnings("deprecation")
	public static  WebDriver driverload()   {
		System.setProperty("webdriver.chrome.driver", pfr.chromepath());
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;

}
}
