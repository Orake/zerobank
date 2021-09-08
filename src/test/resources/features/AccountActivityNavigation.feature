
@smoke
Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on "Loan" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Loan" selected