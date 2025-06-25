Feature: End-to-End Purchase Flow for Logged-in Users

  @smoke @Regression
  Scenario Outline: Verify if user is already logged in
    Given User is on the home page
    When User clicks on the Signup and Login Link
    Then User is taken to the New User Signup or login page
    When user enter email "<email>" and "<password>"
    And user clicks on the login button
    Then user is successfully logged in
    And user verifies the "Logged in as " message
    When User clicks on the Products link
    And User expands the category against Women's products in the accordion
    And User clicks on Dress
    And User clicks on View Product link on the first product
    And User enters the quantity as 2
    And User clicks on Add to Cart
    And User verifies the "Added" message in the modal
    And User clicks on view cart
    And User checks the quantity is equal to 2
    And User clicks on Proceed to Checkout
    And User enters the comments
    And User clicks on Place Order
    And user enters Name cardNumber cvc expiration year
    And User clicks on Pay and Confirm Order
    Then User checks the order placed Confirmation message
    And User clicks on continue button
    And User clicks on the Logout link
    Then User is logged out successfully

    Examples: 
      | email                | password   |
      | CucumberTester@gmail.com | Testing123 |
