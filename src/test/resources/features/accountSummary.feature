Feature: Account Summary
  Background:
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "username" and "password"
    Then The user should see username menu

    Scenario: Title check
      Given Go to the "Online Banking" page
      When Go to the "Account Summary" module
      Then Verify that "Zero - Account Summary" title

    Scenario: Account type check
      Given Go to the "Online Banking" page
      When Go to the "Account Summary" module
      Then Validate all table are on the page
      |Cash Accounts|
      |Investment Accounts|
      |Credit Accounts|
      |Loan Accounts|

    Scenario: The columns of Credit Account check
    Given Go to the "Online Banking" page
    When Go to the "Account Summary" module
    Then Validate all column are on the "Credit Accounts" page
    |Account|
    |Credit Card|
    |Balance|