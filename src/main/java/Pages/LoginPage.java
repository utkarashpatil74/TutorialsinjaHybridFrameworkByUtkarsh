package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void sendEmailAddress(String email) {
		elementUtils.typeTextIntoElement(emailField, email,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void sendPassword(String password) {
		elementUtils.javascriptType(passwordField,CommonUtils.EXPLICIT_WAIT_BASIC_TIME, password);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	public AccountsPage clickOnLoginButton() {
		elementUtils.clickOnWebElement(loginButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountsPage(driver);
	}

	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	private WebElement warningMessage;
	
	public boolean warningMessageIsDisplayed() {
		return elementUtils.elementIsDisplayed(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	

	
	
	
}

