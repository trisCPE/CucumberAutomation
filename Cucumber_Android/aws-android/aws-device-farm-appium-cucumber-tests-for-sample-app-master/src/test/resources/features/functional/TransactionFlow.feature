#Feature: Test the transaction display on Overview
#
#  #I should be able to see the balance has changed and the withdrawal has been added
#  Scenario: Check whether withdrawal was processed on Overview
#
#    Given I am logged in
#
#    And I press button "Side Menu"
#
#    And I press button "Withdrawal"
#
#    When I type in amount "0.01"
#
#      And I press button "Next"
#
#      And I press button "Ok"
#
#    Then I see text "223,94€"
#
#    And I see text "-0,01 €"
#
#      And I scroll horizontally
#
#    Then I see text "0,00€"
#
#    Then I see text "-0,01 €"
#
#  #I should be able to see the balance has changed and the top-up has been added
#  Scenario: Check whether top-up was processed on Overview
#
#    Given I am logged in
#
#    And I press button "Fab"
#
#    And I press button "Top Up"
#
#    When I type in amount "0.01"
#
#      And I press button "Pay"
#
#      And I press button "Ok"
#
#    Then I see text "223,95€"
#
#    And I see text "+0,01 €"
#
#    And I scroll horizontally
#
#    ##Scroll two times to reach Received tab
#    And I scroll horizontally
#
#    Then I see text "0,08€"
#
#  #I should be able to see the balance has changed and the pay has been added
#  Scenario: Check whether pay was processed on Overview
#
#    Given I am logged in
#
#    And I press button "Fab"
#
#    And I press button "FabPay"
#
#    When I type in amount "0.01"
#
#      And I press button "Pay"
#
#      And I press button "Close button"
#
#      And I press button "CANCEL"
#
#    Then I see text "-0,01 €"
#
#    And I scroll horizontally
#
#    Then I see text "-0,01 €"
#
