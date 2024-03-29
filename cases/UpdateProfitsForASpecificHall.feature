Feature: Update profits for a specific hall

  Scenario: Update profits for existing hall
    Given the profits file exists
    And the halls file exists
    When I update or print profits for the hall "HallName"
    Then the profits file should be updated with the correct profits
