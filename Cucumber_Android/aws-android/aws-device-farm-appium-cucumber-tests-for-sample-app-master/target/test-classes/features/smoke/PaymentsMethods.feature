#Feature: All payment methods pages accessible from the home page, transactions page
#  and vouchers page
#
#  Scenario Outline: Open the screens for each payment method
#  """
#  When I press the button on the right bottom, and I press a button accessing
#  to a payment method, I see the title on the top of the page.
#  """
#
#    Given I am logged in
#
#    When I press button "Fab"
#
#      And I press button "<buttonName>"
#
#    Then I see text "<text>"
#
#    Examples:
#      | buttonName | text |
#      | FabPay     | Pay  |
#      | Top Up     | Top Up |
#      | Send Money | Send Money |
#      | Cash in    | Do you permit this app |
#      | Direct Pay | Direct Pay limit |
#
#  Scenario Outline: Open the screens for each payment method from the Transactions page
#  """
#  Given I am on the transactions page, I press the button on the right bottom,
#  and I press a button, I see the right title on the top of the page.
#  """
#
#    Given I am logged in
#
#    When I press button "Side Menu"
#
#      And I press button "Transactions"
#
#      And I press button "Fab"
#
#      And I press button "<buttonName>"
#
#    Then I see text "<text>"
#
#    Examples:
#      | buttonName | text |
#      | FabPay     | Pay  |
#      | Top Up     | Top Up |
#      | Send Money | Send Money |
#      | Cash in    | Do you permit this app |
#      | Direct Pay | Present QR code to be scanned |
#
#
#  Scenario Outline: Open the screens for each payment method from the Vouchers page
#  """
#  Given I am on the transactions page,
#  When I press the button on the right bottom, and I press a button, I see the right title
#  on the top of the page
#  """
#
#    Given I am logged in
#
#    When I press button "Side Menu"
#
#    And I press button "Vouchers"
#
#    And I press button "Fab"
#
#    And I press button "<buttonName>"
#
#    Then I see text "<text>"
#
#    Examples:
#      | buttonName | text |
#      | FabPay     | Pay  |
#      | Top Up     | Top Up |
#      | Send Money | Send Money |
#      | Cash in    | Do you permit this app |
#      | Direct Pay | Present QR code to be scanned |
