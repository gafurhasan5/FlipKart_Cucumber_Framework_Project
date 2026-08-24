package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.resuableFunctions.ReusableFunctions;

public class FilterPage extends ReusableFunctions {

	public FilterPage(WebDriver driver) {
		super(driver);
	}

	private static final By BRAND_LOCATOR = By.xpath("//div[@title='vivo']//label");

	private static final By RAM_LOCATOR = By.xpath("//div[@title='3 GB']//label");
	private static final By BATTERY_HEADER = By.xpath("//div[normalize-space()='Battery Capacity']");

	private static final By BATTERY_OPTION = By.xpath("//div[@title='3000 - 3999 mAh']");

	private static final By MIN_PRICE_LOCATOR = By.xpath("//div[@class='FrhiFV']/select");

	private static final By MAX_PRICE_LOCATOR = By.xpath("//div[@class='WoGl7t']/select");

	private static final By _LOCATOR = By.xpath("//div[@class='WoGl7t']/select");

	public void clickBrand() throws InterruptedException {

		WebElement brand = wait.until(ExpectedConditions.presenceOfElementLocated(BRAND_LOCATOR));

		System.out.println("vivo brand option found");

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
				brand);

		wait.until(ExpectedConditions.visibilityOf(brand));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", brand);

		System.out.println("vivo brand clicked");
		Thread.sleep(2000);
	}

	public void clickRam() {

		WebElement ram = wait.until(ExpectedConditions.presenceOfElementLocated(RAM_LOCATOR));

		System.out.println("3 GB RAM option found");

		// Scroll RAM option into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
				ram);

		// Wait until visible
		wait.until(ExpectedConditions.visibilityOf(ram));

		// Click the label
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ram);

		System.out.println("3 GB RAM Selected");
	}

	public void clickBatteryArrow() {

		System.out.println("Looking for Battery Capacity...");
		

		// Find heading
		/*WebElement batteryHeader = wait.until(ExpectedConditions.presenceOfElementLocated(BATTERY_HEADER));

		System.out.println("Battery Capacity heading found");

		// Scroll to heading
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
				batteryHeader);

		// Click heading to expand
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", batteryHeader);

		System.out.println("Battery Capacity clicked");

		// Wait for battery option
		WebElement batteryOption = wait.until(ExpectedConditions.presenceOfElementLocated(BATTERY_OPTION));

//         System.out.println("3000 - 3999 mAh option found");
		//
		//
//         // Scroll to option
//         ((JavascriptExecutor) driver).executeScript(
//                 "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
//                 batteryOption
//         );
		//
		//
//         // Find label
//         WebElement label = batteryOption.findElement(
//                 By.xpath(".//label")
//         );
		//
		//
//         // Click label
//         ((JavascriptExecutor) driver).executeScript(
//                 "arguments[0].click();",
//                 label
//         );

		// System.out.println("3000 - 3999 mAh Selected");*/
	}

	public void clickMinAndMaxPrice() {

		scrollToElement(MIN_PRICE_LOCATOR);

		Select minPrice = new Select(waitForVisibility(MIN_PRICE_LOCATOR));

		minPrice.selectByValue("10000");

		scrollToElement(MAX_PRICE_LOCATOR);

		Select maxPrice = new Select(waitForVisibility(MAX_PRICE_LOCATOR));

		maxPrice.selectByValue("15000");
	}

	// earbuds search scenarios

	private static final By EARBUDSBRANDHEADER_LOCATOR = By
			.xpath("//section[contains(@class,'KNnSWQ')][.//div[normalize-space()='Brand']]");

	public void clickBrandHeader() {
		click(EARBUDSBRANDHEADER_LOCATOR);
	}

	private static final By EARBUDSBRAND_LOCATOR = By.xpath("//div[text()='OPPO']/preceding-sibling::div");

	public void selectBrandEarbuds() {
		click(EARBUDSBRAND_LOCATOR);
	}

	public void clickEarbudsMinAndMaxPrice() {

		scrollToElement(MIN_PRICE_LOCATOR);

		//Select minPrice = new Select(waitForVisibility(MIN_PRICE_LOCATOR));

		//minPrice.selectByValue("600");
		waitForClickable(MIN_PRICE_LOCATOR);
		//selectByValue(MIN_PRICE_LOCATOR,"600");
		selectByIndex(MIN_PRICE_LOCATOR,1);
		//scrollToElement(MAX_PRICE_LOCATOR);

		Select maxPrice = new Select(waitForVisibility(MAX_PRICE_LOCATOR));

		maxPrice.selectByValue("10000");
	}
	public void clickFeature()
	{
		scrollToElement(FEATUREHEADER_LOCATOR);
		waitForClickable(FEATUREHEADER_LOCATOR);
		click(FEATUREHEADER_LOCATOR);
		//waitForClickable(FEATURE_LOCATOR);
		click(FEATURE_LOCATOR);
		System.out.println("feature  Clicked");
	}
	private static final By COLOURHEADING_LOCATOR = By.xpath(" //div[text()='Color']");

	public void clickColorHeader() {
		scrollToElement(COLOURHEADING_LOCATOR);
		click(COLOURHEADING_LOCATOR);
		System.out.println("Color Heading Click");
	}

	private static final By COLOUR_LOCATOR = By.xpath("//div[@title='Black']//label");
	private static final By FEATUREHEADER_LOCATOR = By.xpath("//div[text()='Features']/parent::div");
	private static final By FEATURE_LOCATOR = By.xpath("//div[@title='Fast Charging']//label//input[@type='checkbox']");
	
	public void SelectColor() {
		
		waitForClickable(COLOUR_LOCATOR);
		click(COLOUR_LOCATOR);
		System.out.println("Color  Click");
	}
	

}