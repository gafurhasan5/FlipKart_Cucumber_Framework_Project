Feature: Flipkart Search functionality

 As a user
  I want to search for products on Flipkart
  So that I can view relevant search results
  
  Background:
  Given launch the Flipkart Application
  When close the pop
  Then It should Navigate to Home Pages
   
    @tc001 
  Scenario: To validate the search functionality
  
  Given user enter the text in search field
  When user click the search button
  And select the brand
  And select the Ram
  And Select the battery capacity
  And select minimum and maximum amount 
  Then it should display the relevant result
  
    @tc002  
    Scenario: To validate the search functionality for earbuds

    Given user enter "Earbuds" in search field
    When user click the search button
    And select the EarBudsbrand
    And select brandminimum and brandmaximum amount
    And select the features
    And select the color
    Then it should display the relevant earbuds result
   @tc003 
 Scenario: To validate the Fashion functionality 

    Given user click the fashion link 
    
     And I select the Sneakers category
    Then I should be redirected to the Sneakers listing page
    
    
   @tc004
 Scenario Outline: To validate search functionality with different values
    Given Enter the "<searchText>" in the searchfield
    And user click the search button
    Then It should navigate the next page and validate the corresponding page

Examples:
    | searchText |
    | Mobile     |
    | TV         |
    | Speaker    |
    | Laptop     |
  
   @tc005  
 Scenario:validate upto addcart functionality
 Given user move to login link
 When user click the flipkart plus zone
 And mouse move to homeAndfurniture link
 And click the wall lamp
 And scroll down and click any particular result
 And Enter delivery pincode and click check link
 Then pincode should check and displayed verify titles
 
   @tc006

  Scenario: Validate product search using Excel
    Given user is on Flipkart home page
    When user enter searches products from Excel
    Then relevant search results should be displayed