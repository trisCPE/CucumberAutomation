Feature: Test the functions on the Transactions screen

  Background:

    Given I am logged in

    When I press button "Side Menu"

    And I press button "Transactions"

  #As an user, I should de able to see the three tabs selected when I click on them
  Scenario: Open the different tabs

    And I press button "Paid"

    Then I see "Paid" is selected

    And I press button "Received"

    Then I see "Received" is selected

    And I press button "Reserved"

    Then I see "Reserved" is selected

   #As an user, I should de able to see the three tabs selected when I scroll horizontally

   Scenario: Display the different tabs by swiping horizontally

    When I scroll horizontally

      Then I see "Paid" is selected

    When I scroll horizontally

      Then I see "Received" is selected

    When I scroll horizontally

      Then I see "Reserved" is selected