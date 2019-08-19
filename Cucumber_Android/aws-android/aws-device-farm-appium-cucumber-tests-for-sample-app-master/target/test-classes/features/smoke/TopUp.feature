##Credit cards don't work because of the web view
#
#Feature: Test the Top Up feature
#
#  Background:
#
#    Given I am logged in
#
#    And I press button "Fab"
#
#    And I press button "Top Up"
#
#  Scenario: Open the Top up screen
#
#    Then I see text "Enter your Top Up amount"
#
#  Scenario: Select account in the Top Up screen
#
#    And I press button "Ends with"
#
#    Then I see title or header "Manage payment methods"
#
#  Scenario: Close the Top Up screen
#
#    And I press button "Close button"
#
#    Then I see text "monthly limit"
#
#  #As an user, I should be able to select a bank account and see it displayed at the bottom
#  Scenario: Select another account
#
#    And I press button "Ends with"
#
#    And I press button "BELFIUS BANK"
#
#    Then I see text "BELFIUS BANK"
#
#  #I should be able to add a new bank account from the top up window
#  Scenario: Add a new Bank Account from top up
#
#    And I press button "Add"
#
#    And I press button "BANK ACCOUNT"
#
#    Then I see title or header "Add bank account"
#
#  #I should be able to add a new bank account from the manage payment methods window
#  Scenario: Add a new Bank Account
#
#    And I press button "Ends with"
#
#    And I press button "Add"
#
#    And I press button "BANK ACCOUNT"
#
#    Then I see title or header "Add bank account"
#
#  Scenario: Cancel the adding of a new account
#
#    And I press button "Ends with"
#
#    And I press button "Add"
#
#    And I press button "CANCEL"
#
#    Then I do not see pop-up with header "Add bank or credit card"