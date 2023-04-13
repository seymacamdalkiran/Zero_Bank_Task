@regression
Feature: Find Transactions in Account Activity
Background:
  Given The user should go to the website
  When The user should be on the login page
  And The user should be login "username" and "password"
  Then The user should click back
  And Go to the "Online Banking" page
  Then Go to the "Account Activity" module
  And The user accesses the "Find Transactions" tab

  Scenario: Search date range
    When The user enters date range from "2012-09-01" to "2012-09-06"
    And Clicks search
    Then Results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And The results should be sorted by most recent date

  Scenario: Search description
    When The user enters description "ONLINE"
    And Clicks search
    Then Results table should only show descriptions containing “ONLINE”

  Scenario: Type-1
    And Clicks search
    Then Results table should show at least one result under Deposit
    Then Results table should show at least one result under Withdrawal

  Scenario: Type-2
    When The user selects type "Deposit" and clicks on Find
    And Clicks search
    Then Results table should show at least one result under Deposit
    But Results table should show no result under Withdrawal

  Scenario: Type-3
    When The user selects type "Withdrawal" and clicks on Find
    And Clicks search
    Then Results table should show at least one result under Withdrawal
    But Results table should show no result under Deposit