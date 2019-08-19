#Feature: Open the Security menu and interact with it.
#  Ensure the password can be modified with the good requirements.
#
#  Background:
#
#    Given I am logged in
#
#    When I press button "Side Menu"
#
#    And I press button "Security"
#
#    And I press button "Change password"
#
#  #As an user, I should see an error when trying to type in different passwords for new and confirm
#  Scenario: Different new and confirm passwords
#
#    When I type in "Test@1122333"
#
#      And I type in "Test@112233"
#
#      And I type in "Test@112234"
#
#      And I press button "Save"
#
#    Then I see text "New passwords do not match"
#
#  #As an user, I should see a validation logo
#  Scenario: Password changed
#
#    When I type in "Test@1122333"
#
#      And I type in "Test@112233"
#
#      And I type in "Test@112233"
#
#      And I press button "Save"
#
#    Then I see the validation logo
#
#    And I press button "Close"
#
#  #The "Save" button should remain disabled as long as the password requirements are not respected
#  Scenario Outline: Password requirements are not respected
#
#    When I type in "Test@112233"
#
#      And I type in "<newPwd>"
#
#      And I type in "<newPwd>"
#
#    Then the button Save is disabled
#
#    Examples:
#    | newPwd |
#    | Test112233 |
#    | test@112233 |
#    | test@1122   |
#    | 112233  |
#    | test@aabbcc  |