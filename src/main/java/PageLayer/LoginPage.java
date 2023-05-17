package PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver=null;
	
	//By Locators
	
	private By emailId = By.name("email");
	private By password = By.name("password");
	private By loginButton = By.xpath("By.xpath(\"//input[@value ='Login'] )");
	
	// constructor
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	//PageActions
	public String pageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin(){
		driver.findElement(loginButton).click();
	}
	
	public boolean isForgetLinkExist() {
		return driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::a")).isDisplayed();
	}
	

}
