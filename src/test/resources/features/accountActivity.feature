Feature: Account Activity

  Background:

  Background:
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "username" and "password"
    Then The user should see username menu

  Scenario: Title check
    Given Go to the "Online Banking" page
    When Go to the "Account Activity" module
    Then Verify that "Zero - Account Activity" title

  Scenario: Default account check
    Given Go to the "Online Banking" page
    When Go to the "Account Activity" module
    Then Account drop down should have "Savings" selected


  Scenario: Check the account drop down menu
    Given Go to the "Online Banking" page
    When Go to the "Account Activity" module
    Then Verify that account drop down menu
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    Scenario: Check the transactions column
    Given Go to the "Online Banking" page
    When Go to the "Account Activity" module
    Then Validate all column are on the page
    |Date|
    |Description|
    |Deposit|
    |Withdrawal|

