package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class searchpage {
	public static By searchbar=By.xpath("//input[@id='search']");
	public static By searchbtn=By.xpath("//header/div[1]/div[1]/section[2]/div[1]/form[1]/div[1]/button[1]/span[1]");
	public static By study=By.xpath("//h4[contains(text(),'Study')]");
	public static By table=By.xpath("//span[contains(text(),'Twain Study Table')]");
	public static By diningTable=By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[5]/a[1]/div[1]/div[1]");
	public static By addToCart=By.id("add-to-cart-button");
	public static By stores=By.xpath("//header/section[1]/div[1]/ul[2]/li[1]/a[1]");
	public static By viewDetails=By.xpath("//body/div[@id='app-container']/div[1]/main[1]/section[2]/div[1]/a[1]/div[2]/button[1]");
	public static By help=By.xpath("//header/section[1]/div[1]/ul[1]/li[1]/a[1]");
	public static By contact=By.xpath("//a[contains(text(),'Contact Us')]");
	public static By helpSearch=By.xpath("//input[@id='help-center-search-input']");
	public static By helpbtn=By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/button[1]");

}
