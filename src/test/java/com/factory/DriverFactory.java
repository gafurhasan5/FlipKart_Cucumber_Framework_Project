package com.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(String browser, boolean headless) {

        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
        }

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

        case "chrome":

            ChromeOptions chromeOptions = new ChromeOptions();

            if (headless) {
                chromeOptions.addArguments("--headless=new");
            }

            chromeOptions.addArguments("--start-maximized");

            webDriver = new ChromeDriver(chromeOptions);

            break;

        case "firefox":

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            if (headless) {
                firefoxOptions.addArguments("-headless");
            }

            webDriver = new FirefoxDriver(firefoxOptions);

            break;

        case "edge":

            EdgeOptions edgeOptions = new EdgeOptions();

            if (headless) {
                edgeOptions.addArguments("--headless=new");
            }

            edgeOptions.addArguments("--start-maximized");

            webDriver = new EdgeDriver(edgeOptions);

            break;

        default:

            throw new RuntimeException(
                    "Browser not supported: " + browser);

        }

        driver.set(webDriver);

        getDriver().manage()
                   .timeouts()
                   .implicitlyWait(Duration.ofSeconds(10));

        if (!headless) {
            getDriver().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();
        }
    }
}