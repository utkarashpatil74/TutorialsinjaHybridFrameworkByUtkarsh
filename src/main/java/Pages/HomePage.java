package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	private WebElement myAccount;
	
	@FindBy(linkText ="Login")
	private WebElement loginBtton;
	
	@FindBy(xpath="//ul//a[text()='Register']")
	private WebElement register;
	
	public void clickOnMyAccount() {
		
		elementUtils.clickOnWebElement(myAccount,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage clickOnLoginValue() {
		
		elementUtils.clickOnWebElement(loginBtton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegister() {
		elementUtils.clickOnWebElement(register,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	

}
