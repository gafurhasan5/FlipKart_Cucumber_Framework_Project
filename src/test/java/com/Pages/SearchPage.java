package com.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.resuableFunctions.ReusableFunctions;
import com.utilities.ExcelUtility;
import com.utilities.LoggerManager;

public class SearchPage extends ReusableFunctions {

    private static final Logger logger =
            LoggerManager.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
        logger.info("SearchPage initialized");
    }

    private static final By SEARCH_BTN_LOCATOR =
            By.xpath("//input[@name='q']");

    private static final By POP_BTN_LOCATOR =
            By.xpath("//span[@class='b3wTlE']");

    private static final By HEADING_TEXT_LOCATOR =
            By.xpath("//span[contains(text(),'mobile')]");

    private static final By HOME_PAGE_NAVIGATE_LOCATOR =
            By.xpath("//html[@lang='en-IN']");

    private static final By LIST_OF_DATA_MOBILE_LOCATOR =
            By.xpath("//div[@class='col col-7-12']");


    public void homeScreen() {

        boolean displayed =
                isDisplayed(HOME_PAGE_NAVIGATE_LOCATOR);

        logger.info("Home page displayed: {}", displayed);
    }


    public void EnterTextInSearchField(String text) {

        logger.info("Entering product in search field: {}", text);

        enterText(SEARCH_BTN_LOCATOR, text);

        logger.debug("Product entered successfully: {}", text);
    }


    public void clickSearch() {

        logger.info("Clicking search button");

        WebElement searchBox =
                waitForVisibility(SEARCH_BTN_LOCATOR);

        searchBox.sendKeys(Keys.ENTER);

        logger.info("Search submitted successfully");
    }


    public void clickPopUp() {

        logger.info("Attempting to close popup");

        click(POP_BTN_LOCATOR);

        logger.info("Popup closed successfully");
    }


    public String getHeading() {

        String heading = getText(HEADING_TEXT_LOCATOR);

        logger.info("Search result heading: {}", heading);

        return heading;
    }


    public List<String> SearchwithExcel() throws IOException {

        ExcelUtility eu = new ExcelUtility();

        List<String> searchedProducts = new ArrayList<>();
        List<String> results = new ArrayList<>();

        int lastRow = eu.getRowCount("Sheet1");

        logger.info("Total Excel rows found: {}", lastRow);

        for (int i = 1; i <= lastRow; i++) {

            String product = eu.excelread("Sheet1", i, 0);

            if (product == null || product.trim().isEmpty()) {

                logger.warn(
                    "Skipping empty product at Excel row: {}",
                    i
                );

                continue;
            }

            logger.info(
                "Searching product from Excel row {}: {}",
                i,
                product
            );

            enterText(SEARCH_BTN_LOCATOR, product);

            logger.debug(
                "Product entered into search box: {}",
                product
            );

            clickSearch();

            searchedProducts.add(product);

            logger.info(
                "Search completed for product: {}",
                product
            );

            String actualResult = driver.getPageSource();

            results.add(product + "||" + actualResult);

            logger.debug(
                "Page source captured for product: {}",
                product
            );

            back();

            logger.info(
                "Navigated back after searching product: {}",
                product
            );
        }

        logger.info(
            "Excel search completed. Total products searched: {}",
            searchedProducts.size()
        );

        return results;
    }
}