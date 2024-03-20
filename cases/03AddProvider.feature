Feature: Add provider

  Scenario: Add a new provider to the Provider file
    Given the Provider file exists
    When I add a new provider "NewProvider" and password "123456"
    Then the Provider file should contain the new provider "NewProvider" and password "123456" on file "file.txt"
