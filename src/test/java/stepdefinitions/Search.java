package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.SearchPage;
import Pages.SearchResultsPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	
	private WebDriver driver;
	private SearchPage searchPage;
	private SearchResultsPage searchResultsPage;

	
	@Given("User opens the Application")
	public void user_opens_the_application() {
	
		driver=DriverFactory.getDriver();
		searchPage =new SearchPage(driver);
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String text) {
		searchPage.searchProduct(text);
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
		searchResultsPage=searchPage.clickOnSearchButton();
		}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	 
	   assertTrue(searchResultsPage.isHpProductPresent());
	   assertFalse(searchResultsPage.isHpProductPresent());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String text) {
		searchPage.searchProduct(text);  
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		assertEquals("There is no product that matches the search criteria.",searchResultsPage.noProductMatchText());	
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
	}




}
