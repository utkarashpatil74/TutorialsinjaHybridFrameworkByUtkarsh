package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.AccountsPage;
import Pages.HomePage;
import Pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;

public class Login {

	private WebDriver driver;
	
	private LoginPage loginPage;
	private AccountsPage accountsPage;
	private CommonUtils commonUtils;
	
	
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage=homePage.clickOnLoginValue();
		
	}

	@When("User enters valid email address {string} into the email field")
	public void user_enters_valid_email_address_into_the_email_field(String emailText) {
	  
		loginPage.sendEmailAddress(emailText);
	
	}

	@And("User has entered valid password {string} into password field")
	public void user_has_entered_valid_password_into_password_field(String passwordText) {
		
		loginPage.sendPassword(passwordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountsPage=loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(accountsPage.accountSuccessCreation());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {    
		commonUtils=new CommonUtils();
		loginPage.sendEmailAddress(commonUtils.getRandomEmailId());
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginPage.sendPassword(invalidPasswordText);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.warningMessageIsDisplayed()); 
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		loginPage.sendEmailAddress("");	
	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginPage.sendPassword("");
	}
	
	

}
