package com.resuableFunctions;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.LoggerManager;

public class ReusableFunctions {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final Logger logger =
            LoggerManager.getLogger(ReusableFunctions.class);

    public ReusableFunctions(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        logger.info("ReusableFunctions initialized");
    }

    // ==========================
    // CLICK METHODS
    // ==========================

    public void click(By locator) {

        logger.debug("Clicking element: {}", locator);

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

        logger.debug("Element clicked successfully: {}", locator);
    }

    public void jsClick(By locator) {

        logger.debug("Performing JavaScript click: {}", locator);

        WebElement element = waitForVisibility(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        logger.debug("JavaScript click completed: {}", locator);
    }

    // ==========================
    // TEXT METHODS
    // ==========================

    public void enterText(By locator, String text) {

        logger.debug("Entering text '{}' into element: {}", text, locator);

        WebElement element = waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);

        logger.debug("Text entered successfully: {}", text);
    }

    public String getText(By locator) {

        logger.debug("Getting text from element: {}", locator);

        String text = waitForVisibility(locator).getText();

        logger.debug("Retrieved text: {}", text);

        return text;
    }

    // ==========================
    // WAIT METHODS
    // ==========================

    public WebElement waitForVisibility(By locator) {

        logger.debug("Waiting for visibility of: {}", locator);

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {

        logger.debug("Waiting for element to be clickable: {}", locator);

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForInvisibility(By locator) {

        logger.debug("Waiting for element to become invisible: {}", locator);

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForAlert() {

        logger.debug("Waiting for alert");

        wait.until(ExpectedConditions.alertIsPresent());

        logger.debug("Alert is present");
    }

    public boolean waitForTitle(String title) {

        logger.debug("Waiting for title containing: {}", title);

        return wait.until(ExpectedConditions.titleContains(title));
    }

    public boolean waitForUrl(String url) {

        logger.debug("Waiting for URL containing: {}", url);

        return wait.until(ExpectedConditions.urlContains(url));
    }

    // ==========================
    // DROPDOWN METHODS
    // ==========================

    public void selectByVisibleText(By locator, String value) {

        logger.info(
                "Selecting dropdown value '{}' using visible text",
                value);

        Select select = new Select(waitForVisibility(locator));

        select.selectByVisibleText(value);

        logger.info("Dropdown value selected: {}", value);
    }

    public void selectByValue(By locator, String value) {

        logger.info(
                "Selecting dropdown value '{}' using value",
                value);

        Select select = new Select(waitForVisibility(locator));

        select.selectByValue(value);

        logger.info("Dropdown value selected: {}", value);
    }

    public void selectByIndex(By locator, int index) {

        logger.info(
                "Selecting dropdown option using index: {}",
                index);

        Select select = new Select(waitForVisibility(locator));

        select.selectByIndex(index);

        logger.info("Dropdown option selected using index: {}", index);
    }

    // ==========================
    // ACTIONS METHODS
    // ==========================

    public void mouseHover(By locator) {

        logger.info("Moving mouse over element: {}", locator);

        Actions actions = new Actions(driver);

        actions.moveToElement(waitForVisibility(locator)).perform();

        logger.info("Mouse hover completed");
    }

    public void moveToElement(By locator) {

        logger.info("Moving to and clicking element: {}", locator);

        Actions actions = new Actions(driver);

        actions.moveToElement(
                waitForVisibility(locator))
                .click()
                .build()
                .perform();

        logger.info("Move and click completed");
    }

    public void doubleClick(By locator) {

        logger.info("Double clicking element: {}", locator);

        Actions actions = new Actions(driver);

        actions.doubleClick(
                waitForVisibility(locator)).perform();

        logger.info("Double click completed");
    }

    public void rightClick(By locator) {

        logger.info("Right clicking element: {}", locator);

        Actions actions = new Actions(driver);

        actions.contextClick(
                waitForVisibility(locator)).perform();

        logger.info("Right click completed");
    }

    // ==========================
    // ALERT METHODS
    // ==========================

    public void acceptAlert() {

        logger.info("Accepting alert");

        waitForAlert();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        logger.info("Alert accepted");
    }

    public void dismissAlert() {

        logger.info("Dismissing alert");

        waitForAlert();

        Alert alert = driver.switchTo().alert();

        alert.dismiss();

        logger.info("Alert dismissed");
    }

    public String getAlertText() {

        logger.info("Getting alert text");

        waitForAlert();

        String text = driver.switchTo().alert().getText();

        logger.info("Alert text: {}", text);

        return text;
    }

    // ==========================
    // SCROLL METHODS
    // ==========================

    public void scrollToElement(By locator) {

        logger.debug("Scrolling to element: {}", locator);

        WebElement element = waitForVisibility(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                element);

        logger.debug("Scroll to element completed");
    }

    public void scrollDown() {

        logger.debug("Scrolling down");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");
    }

    public void scrollUp() {

        logger.debug("Scrolling up");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,-500)");
    }

    // ==========================
    // NAVIGATION METHODS
    // ==========================

    public void navigateTo(String url) {

        logger.info("Navigating to URL: {}", url);

        driver.navigate().to(url);

        logger.info("Navigation completed");
    }

    public void refreshPage() {

        logger.info("Refreshing page");

        driver.navigate().refresh();

        logger.info("Page refreshed");
    }

    public void back() {

        logger.info("Navigating back");

        driver.navigate().back();

        logger.info("Navigated back successfully");
    }

    public void forward() {

        logger.info("Navigating forward");

        driver.navigate().forward();

        logger.info("Navigated forward successfully");
    }

    // ==========================
    // VALIDATION METHODS
    // ==========================

    public boolean isDisplayed(By locator) {

        logger.debug("Checking whether element is displayed: {}", locator);

        boolean result = waitForVisibility(locator).isDisplayed();

        logger.info(
                "Element displayed status [{}]: {}",
                locator,
                result);

        return result;
    }

    public boolean isEnabled(By locator) {

        logger.debug("Checking whether element is enabled: {}", locator);

        boolean result = waitForVisibility(locator).isEnabled();

        logger.info(
                "Element enabled status [{}]: {}",
                locator,
                result);

        return result;
    }

    public boolean isSelected(By locator) {

        logger.debug("Checking whether element is selected: {}", locator);

        boolean result = waitForVisibility(locator).isSelected();

        logger.info(
                "Element selected status [{}]: {}",
                locator,
                result);

        return result;
    }

    // ==========================
    // TITLE METHODS
    // ==========================

    public String getTitle() {

        String title = driver.getTitle();

        logger.info("Current page title: {}", title);

        return title;
    }

    // ==========================
    // MULTIPLE ELEMENT METHODS
    // ==========================

    public void printElementsText(List<WebElement> results) {

        logger.info(
                "Total elements found: {}",
                results.size());

        for (WebElement e : results) {

            logger.debug("Element text: {}", e.getText());
        }
    }

    // ==========================
    // SCREENSHOT METHOD
    // ==========================

    public String takeScreenshot(String screenshotName) {

        String folderPath =
                "src/test/resources/Screenshots/";

        File folder = new File(folderPath);

        if (!folder.exists()) {

            folder.mkdirs();

            logger.info(
                    "Screenshot directory created: {}",
                    folderPath);
        }

        String filePath =
                folderPath + screenshotName + ".png";

        try {

            logger.info(
                    "Taking screenshot: {}",
                    screenshotName);

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            File destination =
                    new File(filePath);

            FileUtils.copyFile(
                    source,
                    destination);

            logger.info(
                    "Screenshot saved successfully: {}",
                    filePath);

            return filePath;

        } catch (Exception e) {

            logger.error(
                    "Failed to take screenshot: {}",
                    screenshotName,
                    e);

            return null;
        }
    }

    // ==========================
    // WINDOW METHODS
    // ==========================

    public void switchToNewWindow(By locator) {

        logger.info(
                "Switching to new window using locator: {}",
                locator);

        String parentWindow =
                driver.getWindowHandle();

        driver.findElement(locator).click();

        logger.debug(
                "Parent window handle: {}",
                parentWindow);

        WebDriverWait windowWait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10));

        windowWait.until(
                driver ->
                        driver.getWindowHandles().size() > 1);

        Set<String> windows =
                driver.getWindowHandles();

        logger.info(
                "Number of windows found: {}",
                windows.size());

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                logger.info(
                        "Switched to new window: {}",
                        window);

                break;
            }
        }
    }
}