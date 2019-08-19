#Feature: Test the pay feature
#
#  Background:
#
#    Given I am logged in
#
#    And I press button "Fab"
#      #Button "Pay" among payment methods
#    And I press button "FabPay"
#
## #########################################
## ##                                     ##
## ##             ADD COMMENT             ##
## ##                                     ##
## #########################################
##
##  Scenario: Add a comment to your payment
##
##    And I press button "Add comment"
##
##    Then I see title or header "Note"
##
##  Scenario: Add a comment to you payment and decide to Go Back
##
##    And I press button "Add comment"
##
##    And I type in "Thank you for the coffee."
##
##    Then I see title or header "Note"
##    #Go back directly in the after hook
##
##  #As an user, I should be able to see the comment I have just saved
##  Scenario: Add a comment to you payment and save it
##
##    And I press button "Add comment"
##
##    When I type in "Hello, I am paying 0.01 to you now."
##
##      And I press button "Save"
##
##    Then I see text "Hello, I am paying 0.01 to you now."
##
##  #As an user, I should be able to remove the comment I have just saved
##  Scenario: Add then remove a comment on the Pay screen
##
##    When I type in amount "0.01"
##
##      And I press button "Add comment"
##
##      And I type in "Hello, I am paying 0.01 to you now."
##
##      And I press button "Save"
##
##      And I press button "Remove comment"
##
##    Then I see text "Add comment"
##
##  #As an user, I should be able to pay adding a comment
##  Scenario: Pay 0.01 € adding a comment
##
##    And I type in amount "0.01"
##
##    And I press button "Add comment"
##
##    When I type in "Hello, I am paying 0.01 to you now."
##
##      And I press button "Save"
##
##      And I press button "Pay"
##
##    Then I see text "0,01"
##
## #########################################
## ##                                     ##
## ##               PAYMENT               ##
## ##                                     ##
## #########################################
##
 # I should process a payment without any comment
#  Scenario: Proceed with simple payment
#
#    And I type in amount "0.01"
#
#    And I press button "Pay"
#
#    Then I see text "Present QR code to be scanned"

#  Scenario: See pop-up when about to close
#
#    When I type in amount "0.01"
#
#      And I press button "Pay"
#
#    And I press button "Close button"
#
#    Then I see pop-up with header "You are about to cancel your action"

#  #As an user, I should be able to cancel a payment
#  Scenario: Cancel payment
#
#    When I type in amount "0.01"
#
#      And I press button "Pay"
#
#    And I press button "Close button"
#
#    And I press button "CANCEL"
#
#    #fails
#    Then I see text "monthly limits"
#
#  #As an user, I should be able to continue after attempting to close the window
#  Scenario: Cancel payment after proceed and pay a note
#
#    When I type in amount "0.01"
#
#      And I press button "Pay"
#
#      And I press button "Close button"
#
#      And I press button "CONTINUE"
#
#    Then I see text "Present QR code to be scanned"
#
#  Scenario: Display the QR Code in full screen on the Pay screen
#
#    When I type in amount "0.01"
#
#      And I press button "Add comment"
#
#      And I type in "Hello, I am paying 0.01 to you now."
#
#      And I press button "Save"
#
#      And I press button "Pay"
#
#      And I press button "QR Code"
#
#    Then I see QR Code in full screen
#
#  #I should be able to close the page and come back to home
#  Scenario: Cancel payment after having displayed the QR Code
#
#    When I type in amount "0.01"
#
#      And I press button "Add comment"
#
#    When I type in "Hello, I am paying 0.01 to you now."
#
#      And I press button "Save"
#
#      And I press button "Pay"
#
#      And I press button "QR Code"
#
#      And I press button "Close button"
#
#      And I press button "CANCEL"
#
#    Then I see text "monthly limit"
###
#  Scenario: Continue payment after having displayed the QR Code
#
#    When I type in amount "0.01"
#
#      And I press button "Pay"
#
#      And I press button "QR Code"
#
#      And I press button "Close button"
#
#      And I press button "CONTINUE"
#
#    Then I see QR Code in full screen

  #I should be able to come back to the pay screen after zooming the QR Code
#  Scenario: Come back to the Pay screen
#
#    When I type in amount "0.01"
#
#      And I press button "Add comment"
#
#      And I type in "Hello, I am paying 0.01 to you now."
#
#      And I press button "Save"
#
#      And I press button "Pay"
#
#      And I press button "QR Code"
#
#      And I press button "QR Code"
#
#    Then I see text "Present QR code to be scanned"