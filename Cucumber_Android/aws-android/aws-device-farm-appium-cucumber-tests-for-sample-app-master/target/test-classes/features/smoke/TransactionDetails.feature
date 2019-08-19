Feature: Transaction details

  Scenario : Display the details of a transaction on the home page

    Given I am logged in

    And I press button "Anonymous"

    Then I see text "Mercedes pay balance"

    Then I see text "Timeout"

    Then I see text "Undefined"

  Scenario: Display the details of a paid transaction

    Given I am logged in

    And I scroll horizontally

    And I press button "Anonymous"

    Then I see text "Mercedes pay balance"

    Then I see text "Timeout"

    Then I see text "Undefined"

  Scenario: Display the details of a received transaction

    Given I am logged in

    And I scroll horizontally

    And I press button "Joao Portuguess"

    Then I see text "Bank (-0191)"

    Then I see text "Processed"

    Then I see text "Top up"