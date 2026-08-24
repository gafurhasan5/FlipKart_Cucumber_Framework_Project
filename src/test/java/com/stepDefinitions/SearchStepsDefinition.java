package com.stepDefinitions;

import org.testng.Assert;

import com.Pages.SearchPage;
import com.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepsDefinition {
    private SearchPage sp;

    @Given("launch the Flipkart Application")
    public void launch_flipkart_application() {
        System.out.println("launch browser");
        // Driver is already initialized in Hook
        sp = new SearchPage(DriverFactory.getDriver());
    }

    @When("close the pop")
    public void close_the_pop() {
        System.out.println("close the pop");
        sp.clickPopUp();
    }


	@Then("It should Navigate to Home Pages")
	public void it_should_navigate_to_home_pages() {
		 System.out.println("Navigate Home Page");
		 sp.homeScreen();

	}
	@Given("user enter the text in search field")
	public void user_enter_the_text_in_search_field() {
		 System.out.println("Enter Text Field");
		 sp.EnterTextInSearchField("mobile");
	}
	@When("user click the search button")
	public void user_click_the_search_button() {
		 System.out.println("click Search Button");
		 sp.clickSearch();
	}   
//	@Then("It should be navigates the search result page and display relevant details")
//	public void it_should_be_navigates_the_search_result_page_and_display_relevant_details() {
//		 System.out.println("Validates");
//		 Assert.assertEquals(sp.getHeading(),"mobile");
//	}
//	@Then("Extract the results and print in console")
//	public void extract_the_results_and_print_in_console() {
//	    sp.printEntireResult();
//	}


//	@Then("Print the third result and keep it in console")
//	public void print_the_third_result_and_keep_it_in_console() {
//	    
//	}
	
	@Given("user enter {string} in search field")
	public void user_enter_in_search_field(String product) {
		 sp.EnterTextInSearchField(product);
	}
	

}
