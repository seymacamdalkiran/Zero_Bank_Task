@regression
Feature: Add new payee under pay bills

  Background:
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "username" and "password"
    Then The user should click back
    And Go to the "Online Banking" page
    Then Go to the "Pay Bills" module


  Scenario: Add a new payee
    Given Go to "Add New Payee" tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    When Taps on add button
    Then message The new payee The Law Offices of Hyde, Price & Scharks was should successfully created should be displayed