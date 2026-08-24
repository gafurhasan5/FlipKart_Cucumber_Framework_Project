 Feature: Flipkart Add to Cart functionality

 As a user
  I want to add product in addTocart for products on Flipkart
  So that I can view relevant search results
  
  Background:
  Given launch the Flipkart Application
  When close the pop
  Then It should Navigate to Home Pages
  
 

  
  Scenario: Verify user can add a product to cart
    Given user is on Flipkart homepage
    When user searches for "iPhone 15"
    And user selects the product from the search results
    And user clicks on Add to Cart
    Then the product should be added to the cart
    And the cart should display the selected product