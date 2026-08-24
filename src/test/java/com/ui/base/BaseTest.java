package com.ui.base;

import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.LoggerManager;

public class BaseTest {

    private static final Logger logger =
            LoggerManager.getLogger(BaseTest.class);

    ConfigReader config;

    public void launchApplication() {

        logger.info("Starting browser launch");

        try {

            config = new ConfigReader();

            logger.info(
                    "Browser configured: {}",
                    config.getBrowser());

            DriverFactory.initializeDriver(
                    config.getBrowser());

            logger.info("WebDriver initialized successfully");

            DriverFactory.getDriver()
                    .manage()
                    .window()
                    .maximize();

            logger.info("Browser window maximized");

            logger.info(
                    "Navigating to application URL: {}",
                    config.getUrl());

            DriverFactory.getDriver()
                    .get(config.getUrl());

            logger.info("Application launched successfully");

        } catch (Exception e) {

            logger.error(
                    "Failed to launch application",
                    e);

            throw e;
        }
    }

    public void tearDown() {

        try {

            if (DriverFactory.getDriver() != null) {

                logger.info("Closing browser");

                DriverFactory.getDriver().quit();

                logger.info("Browser closed successfully");

            } else {

                logger.warn(
                        "WebDriver is null. Browser already closed or was not initialized");
            }

        } catch (Exception e) {

            logger.error(
                    "Error occurred while closing browser",
                    e);
        }
    }
}