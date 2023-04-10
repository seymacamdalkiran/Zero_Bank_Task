Feature: Pay Bills

  Background:
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "username" and "password"
    Then The user should see username menu

  Scenario: Title check
    Given Go to the "Online Banking" page
    When Go to the "Pay Bills" module
    Then Verify that "Zero - Pay Bills" title

  Scenario: Positive Test For Paying
    Given Go to the "Online Banking" page
    When Go to the "Pay Bills" module
    And Fill the amount box "2025" and date box "22122023" and description box "QA Salary"
    Then User should see "The payment was successfully submitted." message

  Scenario Outline: Negative Test With Invalid Credantials
    Given Go to the "Online Banking" page
    When Go to the "Pay Bills" module
    And Fill the amount box "<amount>" and date box "<date>" and description box "<description>"
    Then User should be "<url>" success page
    Examples:
      | amount   | date        | description | url                                                            |
      | 99-?     | 22122023    | description | http://zero.webappsecurity.com/bank/pay-bills-saved-payee.html |
      |          | 22122023    | description | http://zero.webappsecurity.com/bank/pay-bills-saved-payee.html |
      | 9999     |             | description | http://zero.webappsecurity.com/bank/pay-bills-saved-payee.html |
      |          |             | description | http://zero.webappsecurity.com/bank/pay-bills-saved-payee.html |
      | amount99 | 22122023    | description | http://zero.webappsecurity.com/bank/pay-bills-saved-payee.html |
      | 9876     | 20nisan2023 | description | http://zero.webappsecurity.com/bank/pay-bills-saved-payee.html |
      | 9876     | [20nisan-?} | description | http://zero.webappsecurity.com/bank/pay-bills-saved-payee.html |

  Scenario Outline: Negative Test With Empty Credentials
    Given Go to the "Online Banking" page
    When Go to the "Pay Bills" module
    And Fill the amount box "<amount>" and date box "<date>" and description box "<description>"
    Then If amount box "<amount>" or date box "<date>" are empty user should see "Please fill out this field." text
    Examples:
      | amount | date     | description |
      | 9999   |          | description |
      |        | 22122023 | description |
      |        |          | description |