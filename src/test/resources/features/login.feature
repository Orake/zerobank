

Feature: User should be able to login



  Scenario: Login as a user
    Given the user is on the login page
    When the user enters the information
    Then the user should be able to login

  Scenario: Login as a wrong user
    Given the user is on the login page
    When the user enters the invalid information
    Then the user should be able to see the error message login