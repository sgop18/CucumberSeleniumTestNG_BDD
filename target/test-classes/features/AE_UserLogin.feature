Feature: To check successful user login

  Background: Verify Login link works
    Given User is on the home page
    When User clicks on the Signup and Login Link
    Then User is taken to the New User Signup or login page

  @smoke @Regression
  Scenario Outline: To check if User is able to login
    When user enter email "<email>" and "<password>"
    And user clicks on the login button
    Then user is successfully logged in
    And user verifies the "Logged in as " message

    Examples: 
      | email                | password   |
      | CucumberTester@gmail.com | Testing123 |
