package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.resuableFunctions.ReusableFunctions;

public class MultiSearchPages extends ReusableFunctions {

    
    public MultiSearchPages(WebDriver driver) {
        super(driver);
    }

    

    private By searchField =
            By.name("q");

   
    public void EnterTextInSearchField(String searchText) {

        enterText(searchField, searchText);
    }

    // =========================================================
    // GET PAGE TITLE
    // =========================================================

    public String getTitle() {

        return driver.getTitle();
    }
}
