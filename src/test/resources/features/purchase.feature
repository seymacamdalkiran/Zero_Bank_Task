@regression
Feature: Purchase Foreign Currency
  Background:
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "username" and "password"
    Then The user should click back
    And Go to the "Online Banking" page
    Then Go to the "Pay Bills" module
    When Go to "Purchase Foreign Currency" tab


  Scenario: Available currencies
    Then Following currencies should be available
      |Australia (dollar) |
      |Canada (dollar) |
      |Switzerland (franc) |
      |China (yuan) |
      |Denmark (krone) |
      |Eurozone (euro) |
      |Great Britain (pound)|
      |Japan (yen) |
      |Mexico (peso) |
      |Norway (krone) |
      |New Zealand (dollar) |
      |Singapore (dollar) |

  @wip
  Scenario: Error message for not selecting currency
    When User tries to calculate cost without selecting a currency
    Then Error message should be displayed