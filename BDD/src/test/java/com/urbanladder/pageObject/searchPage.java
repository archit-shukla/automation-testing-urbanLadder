package com.urbanladder.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.urbanladder.uistore.searchpage;

public class searchPage {
	WebDriver driver;
	public searchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchbar(String search) {
		WebElement srch=driver.findElement(searchpage.searchbar);
		srch.sendKeys(search);
	}
	public void searchbtn() {
		WebElement srch=driver.findElement(searchpage.searchbtn);
		srch.click();
	}
	public void study() {
		WebElement study=driver.findElement(searchpage.study);
		study.click();
	}
	public void table() {
		WebElement table=driver.findElement(searchpage.table);
		table.click();

}
	public void diningTable() {
		WebElement table=driver.findElement(searchpage.diningTable);
		table.click();
	}
	public void Cart() {
		WebElement table=driver.findElement(searchpage.addToCart);
		table.click();
	}
	public void store() {
		WebElement store=driver.findElement(searchpage.stores);
		store.click();
	}
	public void viewDetail() {
		WebElement vd=driver.findElement(searchpage.viewDetails);
		vd.click();
	}
	public void help() {
		WebElement help=driver.findElement(searchpage.help);
		help.click();
	}
	public void contact() {
		WebElement con=driver.findElement(searchpage.contact);
		con.click();
	}
	public void helpSearch(String helps) {
		WebElement help=driver.findElement(searchpage.helpSearch);
		help.sendKeys(helps);
	}
	public void helpbtn() {
		WebElement help=driver.findElement(searchpage.helpbtn);
		help.click();
    }
}


