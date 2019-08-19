#Feature: Withdraw money
#  As a Mercedes Pay user I should be able to withdraw money from my e-wallet and
#  transfer it to my account.
#
#  Scenario Outline: Make some valid withdrawals with different amounts
#
#    Given I am logged in
#
#    And I press button "Side Menu"
#
#    And I press button "Withdrawal"
#
#    When I type in amount "<amount>"
#
#      Then I see text "Withdrawal successful"
#
#      Then I press button "Ok"
#
#   # Careful these are euro cents. Should be euros soon.
#    Examples:
#    |amount|
#    | 1    |
#    | 5    |

# As an user I should not be able to make withdrawals with a higher amount than the current balance
#  Scenario Outline: Make some invalid withdrawals with different amounts
#
#    Given I am logged in

#    And I press button "Side Menu"
#
#    And I press button "Withdrawal"
#
#    When I type an amount of "<amount>" euro cents
#
#       Then I see text "Withdrawal failed"
#
#    And I press button "Try again"
#
#    Examples:
#      |amount |
#      |235 |
#      |250 |