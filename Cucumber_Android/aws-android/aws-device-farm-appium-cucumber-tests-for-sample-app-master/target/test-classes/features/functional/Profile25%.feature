## This feature works with any 25% completed profile
#Feature: Add payment methods when completing profile
#
#  @j002+1
#  Scenario: Add a bank account where there is none registered
#    from the complete profile
#
#    Given I am logged in
#
#    When I scroll on the "Home" page
#
#      And I press button "Complete your profile"
#
#      And I press button "Payment method"
#
#    When I type "LU100102179449131169" as IBAN
#
#      And I press button "Next"
#
#      And I press button "Finish"
#
#    Then I see text "Fortuna Banque s.c."
#
#  @j002+1
#  Scenario: Add a bank account where there is none registered
#    from banks & cards
#
#    Given I am logged in
#
#    When I press button "Side Menu"
#
#      And I press button "Banks & cards"
#
#      And I press button "Add bank account"
#
#    When I type "LU110107361582291454" as IBAN
#
#      And I press button "Next"
#
#      And I press button "Finish"
#
#    Then I see text "Fortuna Banque s.c."
#
