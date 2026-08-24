package com.stepDefinitions;

import com.Pages.FashionPage;
import com.Pages.FilterPage;
import com.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FashionStepsDefinitions {
	private FashionPage fashionpage=null;
	
	@Given("user click the fashion link")
	public void user_click_the_fashion_link() {
		fashionpage = new FashionPage(DriverFactory.getDriver());
		fashionpage.clickfashionlink();
	}
//	@And("I move the category carousel to the right")
//	public void i_move_the_category_carousel_to_the_right() {
//		fashionpage.movesneakers();
//	}
	@And("I select the Sneakers category")
	public void i_select_the_sneakers_category() {
		fashionpage.clickSneakers();
		fashionpage.hoverMenElement();
	}
	@Then("I should be redirected to the Sneakers listing page")
	public void i_should_be_redirected_to_the_sneakers_listing_page() {
	    
	}
}
