Feature: Add Flower for Weddings

  Scenario: Provider adds a Flower with empty name
    Given the provider wants to add a Flower for weddings
    When the provider enters an empty name "Flowername" for the Flower
    Then an error should be displayed indicating that the Flower name is required



  Scenario: Provider adds a Flower with empty price
    Given the provider wants to add a Flower for weddings
    When the provider enters an empty price "price" for the Flower
    Then an error should be displayed indicating that the Flower is required

  Scenario: Provider adds a Flower with non-positive price
    Given the provider wants to add a Flower for weddings
    When the provider enters a non-positive price "price" for the Flower
    Then an error should be displayed indicating that the price must be a positive value

  Scenario: Provider adds a Flower with price containing letters
    Given the provider wants to add a Flower for weddings
    When the provider enters a price "price" with letters for the Flower
    Then an error should be displayed indicating that the price must be a numeric value


