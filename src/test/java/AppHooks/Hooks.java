package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Utilities.ConfigReader;
import io.cucumber.java.*;

public class Hooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver =driverFactory.init_browser(browserName);
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order=1)
	public void failedScenario(Scenario scenario) {
		if (scenario.isFailed())
		{
			String screenshotName =scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
			
	}
}
