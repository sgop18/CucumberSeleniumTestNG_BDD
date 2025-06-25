Feature: To verify search product,add to cart and delete from cart

  Background: User is already logged in
    Given User is on the home page
    When User clicks on the Signup and Login Link
    Then User is taken to the New User Signup or login page
    When user enters email and password
      | email    | CucumberTester@gmail.com |
      | password | Testing123           |
    When user clicks on login button
    
  Scenario: User searches for a product
    When User clicks on the Products link
    When User searches for a Dress in the search box
    When User clicks on the search icon
    And Verify if all the products displayed are dresses

  Scenario: User adds a product to the cart
  	When User clicks on the Products link
    When User expands the category against Women's products in the accordion
    And User clicks on Dress
    And User clicks on View Product link on the first product
    And User enters the quantity as 2
    And User clicks on Add to Cart
    And User verifies the "Added" message in the modal
    And User clicks on view cart
    And User checks the quantity is equal to 2

  Scenario: User deletes a product from the cart
    When User clicks on Cart
    When User clicks on the X button to delete the product from the cart
    Then User verifies if "Cart is empty!" message is displayed
