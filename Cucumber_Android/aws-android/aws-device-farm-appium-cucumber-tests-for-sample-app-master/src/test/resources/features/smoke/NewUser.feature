@j002+1
Feature: Smoke test for a new user

  Scenario: No transactions have been processed yet

    Given I am logged in

    And I see text "No transaction history"

    And I scroll horizontally

    And I see text "No transaction history"

    And I scroll horizontally

    And I see text "No transaction history"

  Scenario: No transactions have been processed yet from Transaction tab

    Given I am logged in

    And I press button "Side Menu"

    And I press button "Transactions"

    And I see text "No transaction history"

    And I scroll horizontally

    And I see text "No transaction history"

  Scenario: No transactions have been processed yet from Transaction tab

    Given I am logged in

    And I press button "Side Menu"

    And I press button "Transactions"

    And I press button "Paid"

    And I see text "No transaction history"

    And I press button "Received"

    And I see text "No transaction history"


  #As a new user, I should not be able to access top-up before having added a payment asset
  Scenario: No payment asset has been added yet

    Given I am logged in

    And I press button "Fab"

    And I press button "Top Up"

    Then I see pop-up with header "No payment method"

