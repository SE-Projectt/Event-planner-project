Feature: Add dessert for Weddings

  Scenario: Provider adds a dessert with empty name
    Given the provider wants to add a dessert for weddings
    When the provider enters an empty name "Flowername" for the dessert
    Then an error should be displayed indicating that the dessert name is required



  Scenario: Provider adds a dessert with empty price
    Given the provider wants to add a dessert for weddings
    When the provider enters an empty price "price" for the dessert
    Then an error should be displayed indicating that the dessert is required

  Scenario: Provider adds a dessert  with non-positive price
    Given the provider wants to add a dessert for weddings
    When the provider enters a non-positive price "price" for the dessert
    Then an error should be displayed indicating that the price must be a positive value

  Scenario: Provider adds a dessert with price containing letters
    Given the provider wants to add a dessert for weddings
    When the provider enters a price "price" with letters for the dessert
    Then an error should be displayed indicating that the price must be a numeric value


