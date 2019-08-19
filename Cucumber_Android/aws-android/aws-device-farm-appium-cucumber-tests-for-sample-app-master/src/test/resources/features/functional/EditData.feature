#Feature: Open the Edit Personal Data menu and interact with it
#We want to be able to edit the user's name moreover deleting the account
#
#  Background:
#
#    Given I am logged in
#
#    When I press button "Side Menu"
#
#      And I press button "Edit personal data"
#
#      And I press button "Name"
#
#  #As an user, I should not be able to change more than two characters in the name or surname.
#  Scenario: Change more than 2 characters in name
#
#      And I type in "James"
#
#      And I type in "Smith"
#
#      And I press button "EditSave"
#
#      Then I see text "You are not allowed to change more than 2 characters"
#
#  #If the name has not changed, an error should be printed.
#  Scenario: Name has not changed
#
#      And I type in "Joao"
#
#      And I type in "Portuguess"
#
#      And I press button "EditSave"
#
#      Then I see text "No changes detected compared to the original first name/last name"
#
#  #As an user, I should not be able to change the name more than once.
#  Scenario: Change name when changed already once
#
#      And I type in "Joao"
#
#      And I type in "Portugues"
#
#      And I press button "EditSave"
#
#     Then I see text "You have already changed your name once."
#
#  #As an user, I should not be able to see the Close account pop-up
#  Scenario: Close account
#
#     And I scroll on the "Edit Data" page
#
#     And I press button "Close account"
#
#     Then I see text "Close account"
#
