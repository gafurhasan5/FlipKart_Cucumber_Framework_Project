package com.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.SearchPage;
import com.factory.DriverFactory;
import com.utilities.LoggerManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchWithExcelStepsDefinitions {

    private WebDriver driver;
    private SearchPage searchPage;

    private List<String> searchResults;

    private static final Logger logger =
            LoggerManager.getLogger(
                    SearchWithExcelStepsDefinitions.class);

    @Given("user is on Flipkart home page")
    public void user_is_on_flipkart_home_page() {

        logger.info("User is on Flipkart home page");

        driver = DriverFactory.getDriver();

        searchPage = new SearchPage(driver);

        logger.info("SearchPage object created");
    }

    @When("user enter searches products from Excel")
    public void userSearchesProductsFromExcel()
            throws IOException {

        logger.info(
                "Starting product search using Excel");

        searchResults =
                searchPage.SearchwithExcel();

        logger.info(
                "Excel product search completed");
    }

    @Then("relevant search results should be displayed")
    public void relevant_search_results_should_be_displayed() {

        logger.info(
                "Starting search result validation");

        Assert.assertNotNull(
                searchResults,
                "Search results should not be null");

        for (String result : searchResults) {

            String[] data =
                    result.split("\\|\\|", 2);

            String product = data[0];

            String pageSource = data[1];

            logger.info(
                    "Validating product: " + product);

            boolean resultDisplayed =
                    pageSource
                            .toLowerCase()
                            .contains(product.toLowerCase());

            if (resultDisplayed) {

                logger.info(
                        "PASS: Product found - "
                                + product);

            } else {

                logger.error(
                        "FAIL: Product not found - "
                                + product);
            }

            Assert.assertTrue(
                    resultDisplayed,
                    "Search result not displayed for: "
                            + product);
        }

        logger.info(
                "Search validation completed successfully");
    }
}
    /*@When("user enter searches products from Excel")
    public void userSearchesProductsFromExcel() throws IOException {
    	 searchPage.SearchwithExcel();
    }
    @Then("relevant search results should be displayed")
    public void relevant_search_results_should_be_displayed() {

        System.out.println(
                "Search completed successfully for Excel data"
        );
    }
}*/
   /* @When("user enter searches products from Excel")
    public void userSearchesProductsFromExcel() throws IOException {

        excel = new ExcelUtility(
                "src/test/resources/TestData/FlipkartTestData.xlsx",
                "Sheet1"
        );

        int rowCount = excel.getRowCount();

        for (int i = 1; i <= rowCount; i++) {

            String product = excel.getCellData(i, 0);

            if (product == null || product.trim().isEmpty()) {
                continue;
            }

            System.out.println("Searching product: " + product);

            searchPage.EnterTextInSearchField(product);

            searchPage.clickSearch();

            driver.navigate().back();
        }

        excel.closeWorkbook();
    }*/

    