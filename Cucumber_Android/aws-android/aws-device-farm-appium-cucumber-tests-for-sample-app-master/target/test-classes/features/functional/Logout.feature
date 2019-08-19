#Feature: Test the logout feature.
#
#  #The user should be logged out after spending more than 10 min without doing any action
#  Scenario: Check the time of the logout and compare it to the technical specification
#
#    Given I am logged in
#
#    And I start timer
#
#    Then I wait for logout pop-up
#
#    And I stop timer
#
#    Then I compare timers with "600"
