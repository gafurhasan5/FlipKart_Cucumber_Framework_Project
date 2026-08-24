package com.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.Pages.MultiSearchPages;
import com.Pages.SearchPage;
import com.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultiSearchStepDefinitions {
	 MultiSearchPages msp;
	  String searchText;
	
	@Given("Enter the {string} in the searchfield")
	public void enter_the_in_the_searchfield(String Text) {
		 searchText = Text;
	    msp = new MultiSearchPages(DriverFactory.getDriver());
	    msp.EnterTextInSearchField(searchText);
	}
	
	@Then("It should navigate the next page and validate the corresponding page")
	public void it_should_navigate_the_next_page_and_validate_the_corresponding_page() {

	    // Get actual page title
	    String actualTitle = msp.getTitle();

	    System.out.println("Search Text: " + searchText);
	    System.out.println("Actual Page Title: " + actualTitle);

	    // Validate that search text is present in page title
	    Assert.assertTrue(
	            actualTitle.toLowerCase().contains(searchText.toLowerCase()),
	            "Title validation failed. Expected search text: '"
	                    + searchText
	                    + "' but actual title was: '"
	                    + actualTitle
	                    + "'"
	    );

	    System.out.println("Title validation PASSED for: " + searchText);

	    // Create safe screenshot name
	    String screenshotName = (searchText == null || searchText.trim().isEmpty())
	            ? "search"
	            : searchText.trim().replaceAll("[^a-zA-Z0-9-_]", "_");

	    // Unique timestamp
	    String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss_SSS")
	            .format(new java.util.Date());

	    String screenshotPath = System.getProperty("user.dir")
	            + "/src/test/resources/Screenshots/"
	            + screenshotName + "_" + timestamp + ".png";

	    // Take screenshot
	   // msp.takeScreenshot(screenshotPath);

	    //System.out.println("Screenshot added: " + screenshotPath);
	}
	
}
