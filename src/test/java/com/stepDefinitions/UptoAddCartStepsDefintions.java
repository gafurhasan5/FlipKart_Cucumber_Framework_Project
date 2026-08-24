package com.stepDefinitions;

import com.Pages.FashionPage;
import com.Pages.UptoAddCartPage;
import com.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UptoAddCartStepsDefintions {
   private UptoAddCartPage uap;
	@Given("user move to login link")
	public void user_move_to_login_link() throws InterruptedException{
	    uap = new UptoAddCartPage(DriverFactory.getDriver());
		uap.movetologinlink(); 
	}

	@When("user click the flipkart plus zone")
	public void user_click_the_flipkart_plus_zone() {
        uap.clickToFlipkartPlusZone();
	}

	@And("mouse move to homeAndfurniture link")
	public void mouse_move_to_home_andfurniture_link(){
		 uap.moveHOmeFurnitureLink();
		 
	}

	@And("click the wall lamp")
	public void click_the_wall_lamp() {
		 uap.clickWallLamp();
	}

	@When("scroll down and click any particular result")
	public void scroll_down_and_click_any_particular_result() {
        uap.clickparticularresult();
        uap.clickwhite();
	}

	@And("Enter delivery pincode and click check link")
	public void enter_delivery_pincode_and_click_check_link() {
		//uap.clickwhite();
		uap.selectdeliverylocation();
		uap.enterpincode();
	}

	@Then("pincode should check and displayed verify titles")
	public void pincode_should_check_and_displayed_verify_titles() {
         System.out.println("Titile+ is: "+ uap.getTitle());
	
	}

}
