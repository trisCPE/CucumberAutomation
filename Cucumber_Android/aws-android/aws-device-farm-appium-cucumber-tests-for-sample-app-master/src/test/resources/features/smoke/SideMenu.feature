#Feature: All buttons accessible directly from the welcome page
#
#  Background:
#
#    Given I am logged in
#
#    And I press button "Side Menu"

#  Scenario Outline: Open all the screens available in the side menu without scrolling
#
#    And I press button "<buttonName>"
#
#    Then I see title or header "<title>"
#
#    Examples:
#      | buttonName | title |
#      | Transactions  | Transactions  |
#      | Banks & cards | Banks & cards |
#      #error
#      | Withdrawal    | Withdrawals    |

#  Scenario Outline: Open all the screens available in the side menu without scrolling
#
#    And I press button "<buttonName>"
#
#    Then I see text "<text>"
#
#    Examples:
#      | buttonName | text |
#      | Edit personal data| Name |
#      | Vouchers      | No vouchers at the moment |
#      | Security      | Security       |
#      | Logout        | Login          |

#  Scenario Outline: Open all the screens available in the side menu with scrolling
#
#    And I scroll on the "Side Menu" page
#
#    And I press button "<buttonName>"
#
#    Then I see text "<text>"
#
#    Examples:
#      | buttonName | text |
#      | About Mercedes pay | About Mercedes pay |
#      | App permissions  | App Permissions  |
#      | FAQs | Select a topic |
#
## Don't work !!!
#      | General Terms & Conditions | General Terms and Conditions |
#      | Privacy Statement | Privacy Statement|
#      | Cookies Policy | Cookies Policy |
