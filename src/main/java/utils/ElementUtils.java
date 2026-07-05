package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {	
		this.driver=driver;
	}
	
	public void clickOnWebElement(WebElement e,long durationOfSeconds) {
		
		WebElement we=waitForElement(e,durationOfSeconds);
		we.click();
	}
	
	public void typeTextIntoElement(WebElement e,String textToBeTyped,long durationInSeconds) {
	
		WebElement we=waitForElement(e,durationInSeconds);
		we.click();
		we.clear();
		we.sendKeys(textToBeTyped);
	}
	
	public WebElement waitForElement(WebElement e,long durationInSeconds) {
		
		WebElement we=null;
		
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		we=wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		
		return we;
	}
	
	public void selectOptionInDropDown(WebElement we,String dropDownOption,long durationInSeconds) {
		
		WebElement webElement=waitForElement(we, durationInSeconds);
		Select select=new Select(webElement);
		select.selectByVisibleText(dropDownOption);
	}
	
	public Alert waitForAlert(long durationOfSeconds) {
		Alert alert=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return alert;
	}
	
	public void acceptAlert(long durationOfSeconds) {
		Alert alert=waitForAlert(durationOfSeconds);
		alert.accept();	
	}
	
	public void dismissAlert(long durationOfSeconds) {
		Alert alert=waitForAlert(durationOfSeconds);
		alert.dismiss();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement we,long durationInSeconds) {
		
		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement=wait.until(ExpectedConditions.visibilityOf(we));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void mouseHoverAndClick(WebElement we,long durationInSeconds) {
		
		WebElement webElement=waitForVisibilityOfElement(we, durationInSeconds);
		Actions act=new Actions(driver);
		act.moveToElement(webElement).click().build().perform();
	}
	
	public void javascriptClick(WebElement we,long durationInSeconds) {
		WebElement webElement=waitForVisibilityOfElement(we, durationInSeconds);
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",webElement);
	}
	
	public void javascriptType(WebElement we,long durationInSeconds,String textToBeTyped) {
		
		WebElement webElement=waitForVisibilityOfElement(we, durationInSeconds);
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
	}
	
	public String getTextOfElement(WebElement we,long durationInSeconds) {
		WebElement webElement=waitForElement(we, durationInSeconds);
		return webElement.getText();
	}
	
	public boolean elementIsDisplayed(WebElement we,long durationInSeconds) {
		WebElement webElement=waitForElement(we, durationInSeconds);
		return webElement.isDisplayed();
	}

}
