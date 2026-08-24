package com.Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resuableFunctions.ReusableFunctions;

public class UptoAddCartPage extends ReusableFunctions {

	String parentWindow;
	public UptoAddCartPage(WebDriver driver) {
		super(driver);
	}

	private static final By LOGINLINK_LOCATOR = By.xpath("//span[text()='Login']");
	private static final By FLIPKART_PLUS_ZONE_LOCATOR = By.xpath("//div[text()='Flipkart Plus Zone']");
	private static final By HOME_FURNITURE_LINK_LOCATOR = By.xpath("//span[text()='Home & Furniture']");
	private static final By WALL_LAMP_LOCATOR = By.linkText("Wall Lamp");
	private static final By LAMP_LINK_LOCATOR = By.xpath("//div[@data-id='WLMHDVGUBHYBZHK5']");
	private static final By SELECT_DELIVERY_LOCATION_LINK_LOCATOR = By.xpath("//div[text()='Select delivery location']");
	private static final By SELECT_WHITE_LOCATOR = By.xpath("//div[text()='White']");
	private static final By PINCODE_INPUT_LOCATOR =
	        By.xpath("//input[@placeholder='Search by area, street name, pin code']");
	//div[@class='_1psv1zeb9 _1psv1ze0 _1psv1zedl']
	//span[text()='Home & Furniture']
	private static final By GETTEXT_LOCATOR = By.xpath("//div[text()='Selected Dimension (H\" x W\"):']");
	private static final By SELECT_PINCODE_LOCATOR=By.xpath("(//*[normalize-space()='Marunji'])[1]");
	private static final By CONFIRM_PINCODE_LOCATOR=By.xpath("//div[text()='Confirm']");
	//div[text()='Confirm']
	public void movetologinlink() throws InterruptedException
	{
		mouseHover(LOGINLINK_LOCATOR);
		
	}
	public void clickToFlipkartPlusZone()
	{
		click(FLIPKART_PLUS_ZONE_LOCATOR);
	}
	public void moveHOmeFurnitureLink()
	{
		moveToElement(HOME_FURNITURE_LINK_LOCATOR );
		
		
	}
	public void clickWallLamp() 
	{
		//waitForClickable(WALL_LAMP_LOCATOR);
		//click(WALL_LAMP_LOCATOR);
		moveToElement(WALL_LAMP_LOCATOR);
		
	}
	public void clickparticularresult() {

	    scrollToElement(LAMP_LINK_LOCATOR);

	    switchToNewWindow(LAMP_LINK_LOCATOR);

	    wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            SELECT_WHITE_LOCATOR
	        )
	    );

	    System.out.println("Product page loaded");
	}
	
	public void clickwhite() {

	    By whiteColor = By.xpath("//div[normalize-space()='White']");
		 //By SELECT_WHITE_LOCATOR1 = By.xpath("//div[text()='White']");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    for (int i = 0; i < 3; i++) {
	        try {
	            WebElement white = wait.until(
	                    ExpectedConditions.elementToBeClickable(whiteColor)
	            );

	            white.click();
	            break;

	        } catch (StaleElementReferenceException e) {
	            System.out.println("White element became stale. Retrying...");
	        }
	    }
	}
	public void selectdeliverylocation() {
		scrollToElement(SELECT_DELIVERY_LOCATION_LINK_LOCATOR );
		waitForClickable(SELECT_DELIVERY_LOCATION_LINK_LOCATOR );
		jsClick(SELECT_DELIVERY_LOCATION_LINK_LOCATOR );
	}
	public void enterpincode()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement pincode = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                PINCODE_INPUT_LOCATOR
		        )
		);

		pincode.clear();
		pincode.sendKeys("411057");
		click(SELECT_PINCODE_LOCATOR);
		click(CONFIRM_PINCODE_LOCATOR);
	}
	public void verify()
	{
		getTitle();
	}
	
}
