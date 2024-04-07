package com.urbanladder.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.urbanladder.uistore.*;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void login() {
		WebElement lgn=driver.findElement(homepage.login);
				lgn.click();
	}
	public void setUserName(String uname ) {
		WebElement login =driver.findElement(homepage.login);
		login.click();
		WebElement login1=driver.findElement(homepage.login1);
		login1.click();
		WebElement email=driver.findElement(homepage.emailid);
		email.clear();
		email.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		WebElement pswd=driver.findElement(homepage.password);
		pswd.sendKeys(pwd);
	}
	public void loginBtn() {
		WebElement lgbt=driver.findElement(homepage.loginbtn);
		lgbt.click();
	}
	public void logout() {
		WebElement logout=driver.findElement(homepage.logout);
		logout.click();
	}
	public void signup() {
		WebElement signup=driver.findElement(homepage.signup);
		signup.click();
	}
	public void signup_login(String email) {
		WebElement sgl=driver.findElement(homepage.signup_email);
		sgl.sendKeys(email);
	}
	public void signup_pwd(String pwd) {
		WebElement sgp=driver.findElement(homepage.signup_pwd);
		sgp.sendKeys(pwd);
	}
	public void signupbtn() {
		WebElement lgbt=driver.findElement(homepage.signupbtn);
		lgbt.click();
	}
	public void trackorder() {
		WebElement trc=driver.findElement(homepage.trackorder);
		trc.click();
	}
	public void orderNumber(String order) {
		WebElement ord=driver.findElement(homepage.orderNumber);
		ord.sendKeys(order);
	}
	public void phoneNumber(String phone) {
		WebElement ord=driver.findElement(homepage.phoneNumber);
		ord.sendKeys(phone);
	}
	public void submit() {
		WebElement sub=driver.findElement(homepage.submit);
		sub.click();
	}

}
