Feature: Eating cucumbers

  @smoke
  Scenario: Many cucumbers
    Given I have already eaten 99 cucumbers
    When I eat 47 cucumbers
    Then I should have 52 cucumbers in my belly

  Scenario: Few cucumbers
    Given I have already eaten 5 cucumbers
    When I eat 2 cucumbers
    Then I should have 3 cucumbers in my belly