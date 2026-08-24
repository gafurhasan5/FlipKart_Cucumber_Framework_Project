package com.ui.hooks;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.resuableFunctions.ReusableFunctions;
import com.ui.base.BaseTest;
import com.utilities.LoggerManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    private static final Logger logger =
            LoggerManager.getLogger(Hook.class);

    BaseTest bt = new BaseTest();

    @Before
    public void setUp() {

        logger.info("==============================");
        logger.info("Cucumber @Before hook started");
        logger.info("==============================");

        try {

            bt.launchApplication();

            logger.info(
                    "Browser setup completed successfully");

        } catch (Exception e) {

            logger.error(
                    "Browser setup failed",
                    e);

            throw e;
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        logger.info("==============================");
        logger.info(
                "Cucumber @After hook started for scenario: {}",
                scenario.getName());

        try {

            if (scenario.isFailed()) {

                logger.error(
                        "TEST FAILED: {}",
                        scenario.getName());

                logger.info(
                        "Taking screenshot for failed scenario");

                String screenshotName =
                        scenario.getName()
                                .replaceAll(
                                        "[^a-zA-Z0-9]",
                                        "_");

                logger.debug(
                        "Screenshot name: {}",
                        screenshotName);

                /*
                 * Use the same driver created by BaseTest
                 */
                if (DriverFactory.getDriver() != null) {

                    ReusableFunctions rs =
                            new ReusableFunctions(
                                    DriverFactory.getDriver());

                    String screenshotPath =
                            rs.takeScreenshot(
                                    screenshotName);

                    if (screenshotPath != null) {

                        logger.info(
                                "Screenshot saved at: {}",
                                screenshotPath);

                        byte[] screenshot =
                                Files.readAllBytes(
                                        Paths.get(
                                                screenshotPath));

                        scenario.attach(
                                screenshot,
                                "image/png",
                                screenshotName);

                        logger.info(
                                "Screenshot attached to Cucumber report");

                    } else {

                        logger.error(
                                "Screenshot path is null");
                    }

                } else {

                    logger.error(
                            "Cannot take screenshot because WebDriver is null");
                }

            } else {

                logger.info(
                        "TEST PASSED: {}",
                        scenario.getName());
            }

        } catch (Exception e) {

            logger.error(
                    "Screenshot/reporting process failed",
                    e);

        } finally {

            logger.info(
                    "Closing browser after scenario: {}",
                    scenario.getName());

            bt.tearDown();

            logger.info(
                    "Cucumber @After hook completed");
        }
    }
}