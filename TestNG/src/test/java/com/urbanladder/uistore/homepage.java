package com.urbanladder.uistore;

import org.openqa.selenium.By;


public class homepage {

	public static By login=By.cssSelector("body.one-col.ul_desktop.body_home:nth-child(2) div.container:nth-child(1) div.header__topBar:nth-child(2) div.header__topBar-content section.header__topBar_sectionRight ul.header__topBarIconList li.header__topBarIconList_profile-icon:nth-child(2) span.header-icon-link.user-profile-icon > svg:nth-child(1)");
	public static By login1=By.cssSelector("body.one-col.ul_desktop.body_home:nth-child(2) div.container:nth-child(1) div.header__topBar:nth-child(2) div.header__topBar-content section.header__topBar_sectionRight ul.header__topBarIconList li.header__topBarIconList_profile-icon:nth-child(2) span.header-icon-link.user-profile-icon ul.dropdown:nth-child(2) li:nth-child(1) > a.login-link.authentication_popup");
	public static By emailid=By.xpath("//div[@id='password-credentials']//input[@id='spree_user_email']");
	public static By password=By.xpath("//body/div[@id='login_dialog']/div[@id='authentication_popup']/div[1]/div[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]");
	public static By loginbtn=By.xpath("//input[@id='ul_site_login']");
	public static By logout=By.xpath("//a[@id='logout']");
	public static By signup=By.xpath("//a[contains(text(),'Sign Up')]");
	public static By signup_email=By.xpath("//body/div[@id='login_dialog']/div[@id='authentication_popup']/div[1]/div[1]/div[2]/div[2]/form[1]/input[3]");
	public static By signup_pwd=By.xpath("//body/div[@id='login_dialog']/div[@id='authentication_popup']/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[2]");
	public static By signupbtn=By.xpath("//body/div[@id='login_dialog']/div[@id='authentication_popup']/div[1]/div[1]/div[2]/div[2]/form[1]/input[4]");
	public static By trackorder=By.xpath("//header/section[1]/div[1]/ul[1]/li[2]/a[1]");
	public static By orderNumber=By.xpath("//input[@id='ip_379403698']");
	public static By phoneNumber=By.xpath("//input[@id='ip_394711104']");
	public static By submit=By.xpath("//body/div[@id='app-container']/div[1]/main[1]/section[1]/form[1]/button[1]");
	public static By trackText=By.xpath("//p[contains(text(),'Order not found. If you have just placed the order')]");

	

	
}
