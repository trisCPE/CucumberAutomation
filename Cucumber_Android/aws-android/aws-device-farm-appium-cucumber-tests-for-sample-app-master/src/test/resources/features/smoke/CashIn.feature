#Feature: Test the Cash In feature
#
#    Background:
#
#        Given I am logged in
#
#        And I press button "Fab"
#
#        And I press button "Cash In"
#
#    Scenario: Open the allow camera screen
#
#        Then I see text "Do you permit this app"
#
#    Scenario: Do not allow the usage of the camera
#
#        And I press button "No"
#
#        Then I see text "monthly limit"
#
#    Scenario: Deny the usage of the camera
#
#        And I press button "Yes"
#
#        And I press button "Deny"
#
#        Then I do not see text "Allow Mpay Beta"
#
#    Scenario: Open the Cash In screen
#
#        And I press button "Yes"
#
#        And I press button "Allow"
#
#        Then I see title or header "Cash In"
#
#    Scenario: Close the Cash In screen
#
#        And I press button "Yes"
#
#        And I press button "Allow"
#
#        And I press button "Close button"
#
#        Then I see text "monthly limit"

