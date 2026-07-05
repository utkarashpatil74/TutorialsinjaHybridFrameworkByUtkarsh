package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath="//input[@name='newsletter'and @value='1']")
	private WebElement subscribeToNewsletter;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private List<WebElement> allWarningMessages;
	
	@FindBy(xpath="//input[@type='password'][@name='confirm']")
	private WebElement confirmPassword;
	
	
	public void enterFirstName(String text)
	{
		elementUtils.typeTextIntoElement(firstNameField, text, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterLastName(String text) {
		elementUtils.typeTextIntoElement(lastNameField, text, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmail(String text) {
		elementUtils.typeTextIntoElement(emailField, text, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephone(String text) {
		elementUtils.typeTextIntoElement(telephoneField, text, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPasswordField(String text) {
		elementUtils.typeTextIntoElement(passwordField, text, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void selectPrivacyPolicyAgree() {
		elementUtils.clickOnWebElement(privacyPolicyAgree, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountsPage selectContinueButton() {
		elementUtils.clickOnWebElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountsPage(driver);
	}

	public void selectYesToNewsLetter() {
		elementUtils.clickOnWebElement(subscribeToNewsletter, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String duplicateEmailWarning() {
		return elementUtils.getTextOfElement(duplicateEmailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public List<WebElement> listOfAllFieldWarnings() {
		return allWarningMessages;
	}
	
	public void yesToNewsLetter() {
		elementUtils.javascriptClick(subscribeToNewsletter,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterConfirmPassword(String text) {
		elementUtils.typeTextIntoElement(confirmPassword, text,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
