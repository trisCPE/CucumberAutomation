@j009
Feature: Test the bank accounts menu

  Background:

    Given I am logged in

    When I press button "Side Menu"

    And I press button "Banks & cards"

  Scenario: See bank account verification

    And I press button "BELFIUS BANK"

    Then I see title or header "Bank fake account"

  Scenario: Enter verification code

    And I press button "BELFIUS BANK"

    And I press button "Enter your verification code"

    Then I see title or header "Bank account verification"

#  Scenario: Delete a bank account
#
#    And I press button "BELFIUS BANK"
#
#    And I press button "Delete"
#
#    Then I see text "Delete bank account?"

#  Scenario: Cancel deletion of bank account
#
#    And I press button "BELFIUS BANK"
#
#    And I press button "Delete"
#
#    And I press button "Cancel"
#
#    Then I do not see text "Delete bank account?"
#
#  Scenario: Cancel deletion of adding bank or cc
#
#    And I press button "Add"
#
#    And I press button "Cancel"
#
#    Then I see title or header "Banks & cards"

