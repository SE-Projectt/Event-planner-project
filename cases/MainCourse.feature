Feature: Add Studio for Weddings

  Scenario: Provider adds a Studio with empty name
    Given the provider wants to add a Studio for weddings
    When the provider enters an empty name "StudioName" for the Studio
    Then an error should be displayed indicating that the Studio name is required



  Scenario: Provider adds a Studio with empty price
    Given the provider wants to add a Studio for weddings
    When the provider enters an empty price "price" for the Studio
    Then an error should be displayed indicating that the price is required

  Scenario: Provider adds a Studio with non-positive price
    Given the provider wants to add a Studio for weddings
    When the provider enters a non-positive price "price" for the Studio
    Then an error should be displayed indicating that the price must be a positive value

  Scenario: Provider adds a Studio with price containing letters
    Given the provider wants to add a Studio for weddings
    When the provider enters a price "price" with letters for the Studio
    Then an error should be displayed indicating that the price must be a numeric value