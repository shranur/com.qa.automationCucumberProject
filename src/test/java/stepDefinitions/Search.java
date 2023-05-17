package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Search {
WebDriver driver;
	
	@Given("User launch the URL and and open home page")
	public void user_launch_the_url_and_and_open_home_page() {
		//driver = DriverFactory.getDriver();
		
	    
	}

	@When("User search for a valid product in search filed")
	public void user_search_for_a_valid_product_in_search_filed() {
		driver.findElement(By.name("search")).sendKeys("hp");
		
	}

	@When("User click on search button")
	public void user_click_on_search_button() {
		driver.findElement(By.xpath("//i[@class ='fa fa-search']/..")).click();
	}

	@Then("User should get valid product displayed on search results")
	public void user_should_get_valid_product_displayed_on_search_results() {
		Assert.assertEquals("Add to Cart", driver.findElement(By.xpath(" //span[contains(text(),'Add to Cart')]")).getText());
		  
	}

	@When("User search for a Invalid product in search filed")
	public void user_search_for_a_invalid_product_in_search_filed() {
		driver.findElement(By.name("search")).sendKeys("mobile phone");
	}

	@Then("User should get an error message about No Product Matching")
	public void user_should_get_an_error_message_about_no_product_matching() {
	   Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath(" //p[contains(text(),'There is no product that matches the search criter')]")).getText());
	  
	}

}
