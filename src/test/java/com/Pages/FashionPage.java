package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.resuableFunctions.ReusableFunctions;

public class FashionPage extends ReusableFunctions {

	public FashionPage(WebDriver driver) {
		super(driver);
	}
	private static final By FASHIONLINK_LOCATOR = By.xpath("//div[text()='Fashion']");
	private static final By SNEAKERS_LOCATOR = By.xpath("//div[text()='Jeans ']");
	private static final By MENS_LOCATOR = By.xpath("//span[text()='Men']");
	private static final By JEANS_LOCATOR = By.xpath("//a[text()='T-Shirts']");
	private static final By PRICE_LOW_TO_HIGH_LOCATOR = By.xpath("//div[contains(text(),'Price -- Low to High')]");

	
	
	public void clickfashionlink()
	{
		click(FASHIONLINK_LOCATOR);
	}
//	public void movesneakers()
//	{
//		 Actions actions = new Actions(driver);
//
//	        actions.moveToElement((WebElement) SNEAKERS_LOCATOR)
//	                .clickAndHold()
//	                .moveByOffset(-500, 0)
//	                .release()
//	                .perform();
//	}
	 public void clickSneakers() {
		     waitForVisibility(SNEAKERS_LOCATOR);
		     click(SNEAKERS_LOCATOR);
	 }
	 public void hoverMenElement()
	 {
		 mouseHover(MENS_LOCATOR);
		 click(JEANS_LOCATOR);
		// waitForClickable(SNEAKERS_LOCATOR);
		 //click(PRICE_LOW_TO_HIGH_LOCATOR);
	 }
}