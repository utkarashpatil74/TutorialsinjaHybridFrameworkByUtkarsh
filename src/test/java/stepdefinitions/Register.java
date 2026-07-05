package stepdefinitions;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.AccountsPage;
import Pages.HomePage;
import Pages.RegisterPage;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;

public class Register {
	
	private WebDriver driver;
	private HomePage homePage;
	private RegisterPage registerPage;
	private AccountsPage accountsPage;
	private CommonUtils commonUtils;

	
	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
	
		driver=DriverFactory.getDriver();
		homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=homePage.selectRegister();	  
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable data) {
		
			commonUtils=new CommonUtils();
			Map<String,String> dataMap=data.asMap(String.class,String.class);
			registerPage.enterFirstName(dataMap.get("firstName"));
			registerPage.enterLastName(dataMap.get("lastName"));
			String mailId=commonUtils.getRandomEmailId();
			System.out.println(mailId);
			registerPage.enterEmail(mailId);
			registerPage.enterTelephone(dataMap.get("telephone"));
			registerPage.enterPasswordField(dataMap.get("password"));
			registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable data) {
		
			Map<String,String> dataMap=data.asMap(String.class,String.class);
			registerPage.enterFirstName(dataMap.get("firstName"));
			registerPage.enterLastName(dataMap.get("lastName"));
			registerPage.enterEmail(dataMap.get("email"));
			registerPage.enterTelephone(dataMap.get("telephone"));
			registerPage.enterPasswordField(dataMap.get("password"));
			registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		registerPage.selectPrivacyPolicyAgree();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountsPage= registerPage.selectContinueButton();	 
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		assertEquals(accountsPage.isAccountCreated(),"Your Account Has Been Created!");
	}
	
	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.yesToNewsLetter();
	}
	
	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	   
		assertEquals(registerPage.duplicateEmailWarning(),"Warning: E-Mail Address is already registered!");
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	  
	}


	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field(List<String> expectedWarnings) {
	   
		List<WebElement> actualWarnings=registerPage.listOfAllFieldWarnings();
		
		List<String> actualWarnings1=new ArrayList<>();
		
		for(WebElement e:actualWarnings) {
			
			String s=e.getText();
			actualWarnings1.add(s);
		}
		
		assertEquals(expectedWarnings,actualWarnings1);
	}

	
}
