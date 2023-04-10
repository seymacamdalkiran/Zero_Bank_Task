@wip
Feature: Navigating to specific accounts in Accounts Activity
  Background:
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "username" and "password"
    Then The user should see username menu
    Given Go to the "Online Banking" page
    When Go to the "Account Summary" module

  Scenario: Savings account redirect
    Then the user clicks on "Savings" link on the Account Summary page
    And Verify that "Zero - Account Activity" title
    Then Account drop down should have "Savings" selected

  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then Verify that "Zero - Account Activity" title
    And Account drop down should have "Brokerage" selected

  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then Verify that "Zero - Account Activity" title
    And Account drop down should have "Checking" selected

  Scenario: Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then Verify that "Zero - Account Activity" title
    And Account drop down should have "Credit Card" selected

  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then Verify that "Zero - Account Activity" title
    And Account drop down should have "Loan" selected