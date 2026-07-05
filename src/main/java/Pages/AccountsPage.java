package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText ="Edit your account information")
	private WebElement accountCreationSuccess;
	
	@FindBy(xpath="//div[@id='content']//h1")
	private WebElement accountCreationSuccessful;
	
	public boolean accountSuccessCreation() {
		return elementUtils.elementIsDisplayed(accountCreationSuccess,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String isAccountCreated() {
		return elementUtils.getTextOfElement(accountCreationSuccessful,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
