package stepDefinitions;

import org.openqa.selenium.By;



import Factory.DriverFactory;
import PageLayer.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class Login {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	
//		driver.findElement(By.xpath("//span[text() ='My Account'] ")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		//DriverFactory.getDriver().get("https://tutorialsninja.com/demo/");
		DriverFactory.getDriver().findElement(By.xpath("//span[text() ='My Account'] ")).click();
		DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'Login')] ")).click();
	}

	@When("User enters valid email address {string}")
	public void user_enters_valid_emaail_address(String emailText) {
		loginPage.enterUsername(emailText);
	  
	}

	@When("User enter valid password {string}")
	public void user_enter_valid_password(String pwdText) {
	loginPage.enterPassword(pwdText);
		
	}

	@When("User clicks on Login Button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
	    //Assert.assertTrue((driver.findElement(By.linkText("Edit your account information")).isDisplayed()));
	}

	@When("User enters invalid email address {string}")
	public void user_enters_invalid_emaail_address(String username) {
		loginPage.enterUsername(username);
	}

	@When("User enter invalid password {string}")
	public void user_enter_invalid_password(String pwd) {
		loginPage.enterPassword(pwd);
	}

	@Then("User should  not login successfully and see an error message")
	public void user_should_not_login_successfully_and_see_an_error_message() {
	    //Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')] ")).isDisplayed());
	}
	
	@Then("forget your password link should be displayed")
	public void forget_your_password_link_should_be_displayed() {
	   Assert.assertTrue(loginPage.isForgetLinkExist());
	   
	}

	@Then("Login page title should be {string}")
	public void login_page_title_should_be(String expectedTiltle) {
	   title = loginPage.pageTitle();
	   System.out.println("title of page:" +title);
	   Assert.assertTrue(title.contains(expectedTiltle));
	}

}
