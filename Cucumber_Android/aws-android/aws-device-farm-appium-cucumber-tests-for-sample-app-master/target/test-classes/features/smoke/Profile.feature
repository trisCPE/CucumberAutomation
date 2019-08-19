##Only with profiles 25% and 75% completed
#Feature: Open the Profile menu and interact with it
#
#  Background:
#
#    Given I am logged in
#
#    When I scroll on the "Home" page
#
#    And I press button "Complete your profile"
#
#  @j09
#  Scenario: Check the camera access on identity verification
#
#      And I press button "Identity verification"
#
#      And I scroll on the "Profile" page
#
#      And I tick the Agree checkbox
#
#      And I press button "I agree"
#
#      And I press button "Yes"
#
#    When I press button "Allow"
#
#      Then I see text "Place the MRZ following the indication. Scan starts automatically."
#
#  @j002+1
#  Scenario: Choose a default payment method
#
#     And I press button "Payment method"
#
#     And I see text "Add a payment method"
#
#  @j002+1
#  Scenario: Choose a default payment method later
#
#      And I press button "Payment method"
#
#      And I press button "Later"
#
#    Then I see text "monthly limit"