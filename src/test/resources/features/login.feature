Feature: Login

  Scenario: Login with positive test
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "username" and "password"
    And The user should click back
    Then The user should see username menu

  Scenario Outline: Login with negative test
    Given The user should go to the website
    When The user should be on the login page
    And The user should be login "<name>" and "<password>"
    Then The user sould see "Login and/or password are wrong." message
    Examples:
      | name     | password |
      |          | password |
      | username |          |
      | wrong    | password |
      | username | wrong    |
      | wrong    | wrong    |
