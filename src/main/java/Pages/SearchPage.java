package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(name="search")
	private WebElement searchInputField;
	
	@FindBy(xpath = "//div[@id='search']//button")
	private WebElement searchButton;
	
	public void searchProduct(String text) {
		elementUtils.typeTextIntoElement(searchInputField, text, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		elementUtils.clickOnWebElement(searchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
	}

}
