package com.urbanladder.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.urbanladder.uistore.searchPage;

public class searchPageObject {
	WebDriver driver;
	public searchPageObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchbar(String search) {
		WebElement srch=driver.findElement(searchPage.searchbar);
		srch.sendKeys(search);
	}
	public void searchbtn() {
		WebElement srch=driver.findElement(searchPage.searchbtn);
		srch.click();
	}
	public void study() {
		WebElement study=driver.findElement(searchPage.study);
		study.click();
	}
	public void table() {
		WebElement table=driver.findElement(searchPage.table);
		table.click();

}
	public void diningTable() {
		WebElement table=driver.findElement(searchPage.diningTable);
		table.click();
	}
	public void Cart() {
		WebElement table=driver.findElement(searchPage.addToCart);
		table.click();
	}
	public void store() {
		WebElement store=driver.findElement(searchPage.stores);
		store.click();
	}
	public void viewDetail() {
		WebElement vd=driver.findElement(searchPage.viewDetails);
		vd.click();
	}
	public void help() {
		WebElement help=driver.findElement(searchPage.help);
		help.click();
	}
	public void contact() {
		WebElement con=driver.findElement(searchPage.contact);
		con.click();
	}
	public void helpSearch(String helps) {
		WebElement help=driver.findElement(searchPage.helpSearch);
		help.sendKeys(helps);
	}
	public void helpbtn() {
		WebElement help=driver.findElement(searchPage.helpbtn);
		help.click();
    }
}