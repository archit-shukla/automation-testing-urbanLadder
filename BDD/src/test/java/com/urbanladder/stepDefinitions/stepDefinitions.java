package com.urbanladder.stepDefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.urbanladder.pageObject.loginPage;
import com.urbanladder.pageObject.searchPage;
import com.urbanladder.reusableComponents.reusableComponents;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
public class stepDefinitions {
	public WebDriver driver;
	public loginPage lp;
	public searchPage sp;
	public Logger logger;
	
		@Given("User Launch Chrome Browser")
	    public void user_launch_chrome_browser() throws Throwable {
			driver=reusableComponents.driverload();
	    	lp=new loginPage(driver);
	    	logger=Logger.getLogger("urbanLadder");
	    	sp=new searchPage(driver);
	    	PropertyConfigurator.configure("log4j.properties");
	    }

	    @When("User opens URL {string}")
	    public void user_opens_url_something(String url) throws Throwable {
	        driver.get(url);
	        logger.info("URL Entered");
	    }
	    @When("User enters Email as {string} and password as {string}")
	    public void user_enters_email_as_something_and_password_as_something(String uname, String pwd) throws Throwable {
	        lp.setUserName(uname);
	        logger.info("Username Entered");
	        lp.setPassword(pwd);
	        logger.info("Password Entered");
	    }

	    @Then("click on Login")
	    public void click_on_login() throws Throwable {
	      lp.loginBtn();
	      logger.info("Logged in");
	    }

	    @Then("Page Title should be {string}")
	    public void page_title_should_be_something(String title) throws Throwable {
	    	if(driver.getTitle().equals(title)) {
				Assert.assertTrue(true);
				logger.info("Test Case Passed");
				
			}else {
				Assert.assertFalse(false);
				logger.info("Test Case Failed");
			}
	        
	    }
	    
	    @And("User click on logout link")
	    public void user_click_on_logout_link() throws Throwable {
	    	lp.login();
	    	lp.logout();
	    	logger.info("Logged Out");
	    }

	    @And("close browser")
	    public void close_browser() throws Throwable {
	       driver.close();
	    }
	    

	    @Then("press the login button and click on signup")
	    public void press_the_login_button_and_click_on_signup() {
	    	lp.login();
	    	lp.signup();
	    	logger.info("Sign up window opened");
	        
	    }
	    @Then("user enters {string} and {string}")
	    public void user_enters_and(String email, String pwd) {
	       lp.signup_login(email);
	       logger.info("Email Id entered");
	       lp.signup_pwd(pwd);
	       logger.info("Password Entered");
	    }
	    @Then("click on Submit")
	    public void click_on_submit() {
	        lp.signupbtn();
	        logger.info("Sign up button clicked");
	    }
	    @Then("current URL should be {string}")
	    public void current_url_should_be(String string) {
	    	if(driver.getCurrentUrl().equals(string)) {
				Assert.assertTrue(false);
				logger.warn("Username already exists");
			}
			else {
				Assert.assertTrue(true);
				logger.info("Signup Successful");
				
			}
	    }

	    @Then("Enter {string} in the search bar and press the search button")
	    public void enter_in_the_search_bar_and_press_the_search_button(String string) {
	    	sp.searchbar(string);
	    	logger.info("Search data Entered");
	    	sp.searchbtn();
	    	logger.info("Search Done");
	    }
	    @Then("verify the title with {string}")
	    public void verify_the_title_with(String string) {
	    	if(driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/h2[1]/span[1]")).getText().equals(string))
			{
				Assert.assertTrue(true);
				logger.info("Test case passed");
			}
			else {
				Assert.assertFalse(false);
				logger.warn("test case failed");
			}
	        
	    }
	 
	    @When("User clicks on study and click on the first result")
	    public void user_clicks_on_study_and_click_on_the_first_result() {
	    	sp.study();
			logger.info("Seacrh done");
			sp.table();
			logger.info("View details of product");
	    }
	    @Then("verify title of the product with {string}")
	    public void verify_title_of_the_product_with(String string) {
	    	if(driver.getTitle().equals(string)) {
				Assert.assertTrue(true);
				logger.info("Test Case Passed");
			}else {
				Assert.assertFalse(false);
				logger.warn("Test case failed");
			}
	        
	    }
	    @Then("click on th first result")
	    public void click_on_th_first_result() {
	    	sp.diningTable();
			driver.get("https://www.urbanladder.com/products/arabia-xl-storage-dining-table?sku=FNTBDI11MH10124&src=room"); 
	    }
	    @Then("click on add to cart button")
	    public void click_on_add_to_cart_button() {
	    	sp.Cart();
			logger.info("Added to cart");
	    }
	    @Then("verify if product is added to cart with matching url {string}")
	    public void verify_if_product_is_added_to_cart_with_matching_url(String string) {
	    	if(driver.getCurrentUrl().equals(string))
			{
				Assert.assertTrue(true);
				logger.info("Test Case Passed");
			} else{
				Assert.assertFalse(false);
				logger.warn("Test case Failed");
				
			}
	    }
	    @Then("click on track order button")
	    public void click_on_track_order_button() {
	    	lp.trackorder();
			logger.info("track order opened");
	    }
	    @Then("Enter {string} as Order Number and {string} as phone Number")
	    public void enter_as_order_number_and_as_phone_number(String string, String string2) {
	    	lp.orderNumber(string);
			logger.info("Order number Entered");
			lp.phoneNumber(string2);
			logger.info("Phone Number Entered");
			lp.submit();
			logger.info("Submitted");
	    }
	    @Then("verify text with {string} to see if details entered are correct")
	    public void verify_text_with_to_see_if_details_entered_are_correct(String string) {
	    	if(driver.findElement(By.xpath("//p[contains(text(),'Order not found. If you have just placed the order')]")).getText().equals(string)){
	    		Assert.assertFalse(false);
	    		logger.warn("Test case Failed");
	    		}else {
	    		Assert.assertTrue(true);
	    		logger.info("Test case Passed");
	    		}
	    }
	
	    @Then("click on help button")
	    public void click_on_help_button() {
	    	sp.help();
			logger.info("Help Page is Opened");
	    }
	    @Then("click on contact us")
	    public void click_on_contact_us() {
	    	sp.contact();
			logger.info("Contact Us page is opened");
	    }
	    @Then("verify the emailid with {string}")
	    public void verify_the_emailid_with(String string) {
	    	if(driver.findElement(By.xpath("//a[contains(text(),'hello@urbanladder.com')]")).getText().equals(string)) {
				Assert.assertTrue(true);
				logger.info("Test Case Passed");
			}else {
				Assert.assertFalse(false);
				logger.warn("Test case Failed");
			}
	    }
	    @Then("Enter {string} in the help seacrh bar")
	    public void enter_in_the_help_seacrh_bar(String string) {
	    	sp.helpSearch(string);
			logger.info("Keyword Entered");
			sp.helpbtn();
			logger.info("Keyword searched");
	    
	    }
	    @Then("verify the text with the search page {string}")
	    public void verify_the_text_with_the_search_page(String string) {
	    	if(driver.findElement(By.xpath("//span[contains(text(),\"'Payment'\")]")).getText().equals(string)) {
				Assert.assertTrue(true);
				logger.info("Test Case Passed");
				}else {
					Assert.assertFalse(false);
					logger.warn("Test Case Failed");
				}
	        
	    }
	    @Then("click on store button")
	    public void click_on_store_button() {
	    	sp.store();
			logger.info("Stores Location ");
	    }
	    @When("click on view details of the store location")
	    public void click_on_view_details_of_the_store_location() {
	    	sp.viewDetail();
			logger.info("Details of the store");
	    }
	    @Then("verify the location with {string}")
	    public void verify_the_location_with(String string) {
	    	if(driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/address[1]/div[3]/span[1]")).getText().equals(string)) {
				Assert.assertTrue(true);
				logger.info("Test Case Passed");
			}else {
				Assert.assertFalse(false);
				logger.warn("Test case failed");
			}
	    }

}
	  
