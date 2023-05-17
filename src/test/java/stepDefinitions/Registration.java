package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Registration {
WebDriver driver;
	
	
	@Given("User is on Register Account page")
	public void user_is_on_register_account_page() {
		
		//driver=DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text() ='My Account'] ")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}

	@When("User select Privacy Policy")
	public void user_select_privacy_policy() {
	    driver.findElement(By.xpath("//input[contains(@name,'agree')] ")).click();
	}

	@When("User click on Continue button")
	public void user_click_on_continue_button() {
	    
		driver.findElement(By.xpath("//input[contains(@value,'Continue')] ")).click();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content'] /h1")).getText());
		
	   
	}

	@When("User select Yes for Newsletter")
	public void user_select_yes_for_newsletter() {
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1'] ")).click();
	    
	}

	@Then("User should see the error message for duplicate account")
	public void user_should_see_the_error_message_for_duplicat_account() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	
	@Then("User should see the warning message for filling fields")
	public void user_should_see_the_warning_message_for_filling_fields() {
		Assert.assertTrue(driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText());
		
	}

}
