package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	
	WebDriver driver;
	private ConfigReader configReader;
	
	@Before
	public void setup() {
		
		configReader=new ConfigReader();
		Properties prop=configReader.readPropertiesFile();
		DriverFactory.initializeBrowser("chrome");
		driver=DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
		String scenarioName=scenario.getName().replaceAll(" ","_");
		byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenshot,"image/png",scenarioName);
		}
		driver.quit();
	} 

}
