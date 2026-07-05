package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement hpProduct;
	
	@FindBy(xpath ="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatching;
	
	
	public boolean isHpProductPresent() {
		return elementUtils.elementIsDisplayed(hpProduct,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String noProductMatchText() {
		return elementUtils.getTextOfElement(noProductMatching,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
}
