package com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.stepDefinitions", "com.ui.hooks"},
    plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }, 
   tags = "@tc006",
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}