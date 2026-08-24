//package com.factory;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class DriverFactory {
//
//    private static WebDriver driver;
//
//    public static WebDriver initializeDriver(String browser) {
//
//        if (browser.equalsIgnoreCase("chrome")) {
//
//            driver = new ChromeDriver();
//
//        } else if (browser.equalsIgnoreCase("firefox")) {
//
//            driver = new FirefoxDriver();
//
//        } else if (browser.equalsIgnoreCase("edge")) {
//
//            driver = new EdgeDriver();
//
//        } else {
//
//            throw new RuntimeException(
//                    "Browser not supported : " + browser);
//        }
//
//        return driver;
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//}
package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {
        if (browser == null || browser.isEmpty()) {
            browser = "chrome"; // default
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
