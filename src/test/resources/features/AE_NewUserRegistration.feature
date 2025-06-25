Feature: To register a new user

  Background: Verify SignUp link works
    Given User is on the home page
    When User clicks on the Signup and Login Link
    Then User is taken to the New User Signup or login page

  @smoke @Regression
  Scenario Outline: New User Registration
    When User enters name "<name>"
    When User enters email "<email>"
    And user clicks on Signup button
    And User enters the following account Details
      | Title    | Female     |
      | Password | Testing123 |
      | Day      |         10 |
      | Month    | October    |
      | Year     |       1990 |
    And User enters the following Address Details
      | Tester | SG | S N0:1 cross road | India | TN | Chennai | 620001 | 1231231234 |
    Then User clicks on createAccount button
    And User account created successfully

    Examples: 
      | name     | email                |
      | CucumberTester | CucumberTester@gmail.com |
