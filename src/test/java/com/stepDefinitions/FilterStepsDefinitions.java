package com.stepDefinitions;

import com.Pages.FilterPage;
import com.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterStepsDefinitions {

	private FilterPage fp = null;

	@And("select the brand")
	public void select_the_brand() throws InterruptedException {
		fp = new FilterPage(DriverFactory.getDriver());
		fp.clickBrand();

	}

	@And("select the Ram")
	public void select_the_ram() {

		fp.clickRam();
		System.out.println("Ram Selected");
	}

	@Then("Select the battery capacity")
	public void select_the_battery_capacity() {
		fp.clickBatteryArrow();

	}

	@And("select minimum and maximum amount")
	public void select_minimum_and_maximum_amount() {
		fp.clickMinAndMaxPrice();
	}

	@Then("it should display the relevant result")
	public void it_should_display_the_relevant_result() {

	}

	//Earbuds Step Definition

	

	@And("select the EarBudsbrand")
	public void select_the_ear_budsbrand() {
		fp = new FilterPage(DriverFactory.getDriver());
          fp.clickBrandHeader();
          fp.selectBrandEarbuds();
	}

	@And("select brandminimum and brandmaximum amount")
	public void select_brandminimum_and_brandmaximum_amount() {
		fp.clickEarbudsMinAndMaxPrice();
	}

	@And("select the features")
	public void select_the_features() {
		  fp.clickFeature();
        
      
	}
	@And("select the color")
	public void select_the_color() {
		fp.clickColorHeader();
         fp.SelectColor();
      
	}
	
	

	@Then("it should display the relevant earbuds result")
	public void it_should_display_the_relevant_earbuds_result() {

	}

}
