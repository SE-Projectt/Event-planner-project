Feature: Update or print profits for a specific hall

  Scenario: Profits file not found
    Given the profits file does not exist
    When I update or print profits for the hall "HallName"
    Then a warning message about profits file should be logged

  Scenario: Error reading profits file
    Given the profits file exists but cannot be read
    When I update or print profits for the hall "HallName"
    Then an error message about reading profits file should be logged

  Scenario: Error reading halls file
    Given the profits file exists
    And the halls file exists but cannot be read
    When I update or print profits for the hall "HallName"
    Then an error message about reading halls file should be logged

  Scenario: Hall not found in halls file
    Given the profits file exists
    And the halls file exists
    And the hall "HallName" does not exist in the halls file
    When I update or print profits for the hall "HallName"
    Then no changes should be made to the profits file

  Scenario: Update profits for existing hall
    Given the profits file exists
    And the halls file exists
    And the hall "HallName" exists in the halls file
    When I update or print profits for the hall "HallName"
    Then the profits file should be updated with the correct profits
