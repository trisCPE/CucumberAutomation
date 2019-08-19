#Feature: Open the Banks & Cards menu and interact with it.
#  We want to be able to manage credit cards and bank accounts
#
#  Background:
#
#    Given I am logged in
#
#    When I press button "Side Menu"
#
#    And I press button "Banks & cards"
#
#  #As an user, I should be able to add a valid bank account
#  Scenario: Add a valid bank account
#
#      And I press button "Add"
#
#      And I press button "BANK ACCOUNT"
#
#    When I type "LU100102179449131169" as IBAN
#
#      And I press button "Finish"
#
#    Then I see text "Banks & cards"
#
#  #As an user, I should be able to delete a bank account
#  Scenario: Delete a bank account
#
#      And I press button "BELFIUS BANK"
#
#      And I press button "Delete"
#
#      And I press button "DELETE"
#
#      Then I see text "Banks & cards"
#
#  #As an user, I should be able to set any valid payment method default
#  Scenario: Make a default payment method
#
#    And I press button "BELFIUS BANK"
#
#    And I tick the "make default payment" checkbox
#
#    Then I see text "DEFAULT, VERIFIED"
#
#  #As an user, I should be able to search for accepted countries
#  Scenario: Search accepted countries
#
#    And I press button "Add"
#
#    And I press button "BANK ACCOUNT"
#
#    And I press button "Accepted countries"
#
#    Then I see the country "France" is accepted
#
#    Then I see the country "Portugal" is accepted
#
#    Then I see the country "Luxembourg" is accepted
#
#  #As an user, I should be able to search for not accepted countries
#  Scenario: Not accepted countries
#
#    And I press button "Add"
#
#    And I press button "BANK ACCOUNT"
#
#    And I press button "Accepted countries"
#
#    Then I see the country "Brazil" is not accepted
#
#    Then I see the country "United States" is not accepted
#
#    Then I see the country "China" is not accepted
#
#  #An error message should be displayed when typing a wrong IBAN
#  Scenario: Invalid IBAN
#
#    And I press button "Add"
#
#    And I press button "BANK ACCOUNT"
#
#    When I type "LU3434444333576478695" as IBAN
#
#      And I press button "Next"
#
#    Then I see text "This IBAN cannot be registered"
