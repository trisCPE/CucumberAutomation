#Feature: Open the Security menu and interact with it
#
#  Background:
#
#    Given I am logged in
#
#    When I press button "Side Menu"
#
#    And I press button "Security"
#
#  Scenario: Change password
#
#    And I press button "Change password"
#
#    And I see text "Change password"
#
#   #I should be able to open the pop-up containing the password requirements
#  Scenario: Open the password requirements
#
#    And I press button "Change password"
#
#    And I press button "Password requirements"
#
#    Then I see text "Please use a secure password"
#
#  #I should be able to toggle show/hide for every password
#  Scenario: Testing all the show/hide in change password menu
#
#    And I press button "Change password"
#
#    When I type in "Test@112233"
#
#      And I type in "Test@1122333"
#
#      And I type in "Test@1122333"
#
#    And I press button number 0 displaying "Show"
#
#    Then I see password number 0
#
#    And I press button number 0 displaying "Hide"
#
#    Then I do not see password number 0
#
#    And I press button number 1 displaying "Show"
#
#    Then I see password number 1
#
#    And I press button number 1 displaying "Hide"
#
#    Then I do not see password number 1
#
#    And I press button number 2 displaying "Show"
#
#    Then I see password number 2
#
#    And I press button number 2 displaying "Hide"
#
#    Then I do not see password number 2
#
#  #I should be able to display and see the "Clear cookies" confirmation pop-up
#  Scenario: Clear cookies
#
#    And I press button "Clear cookies"
#
#    Then I see text "Clear cookies"
#
# #I should be able to close the "Clear cookies" pop-up
#  Scenario: Cancel clearing cookies
#
#    And I press button "Clear cookies"
#
#    And I press button "No"
#
#    Then I see text "Clear cookies"