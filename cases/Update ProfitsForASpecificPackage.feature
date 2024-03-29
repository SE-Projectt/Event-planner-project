Feature: Update profits for a specific package

  Scenario: Update profits for existing package
    Given the profits package file exists
    And the package file exists
    When I update or print profits for the package "PackageName"
    Then the profits package file should be updated with the correct profits
