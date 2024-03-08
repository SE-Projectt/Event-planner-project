Feature: Add Dj for Weddings

  Scenario: Provider adds a Dj with empty name
    Given the provider wants to add a Dj for weddings
    When the provider enters an empty name "Djname" for the Dj
    Then an error should be displayed indicating that the Dj name is required



  Scenario: Provider adds a Dj with empty price
    Given the provider wants to add a Dj for weddings
    When the provider enters an empty price "price" for the Dj
    Then an error should be displayed indicating that the price is required

  Scenario: Provider adds a Dj with non-positive price
    Given the provider wants to add a Dj for weddings
    When the provider enters a non-positive price "price" for the Dj
    Then an error should be displayed indicating that the price must be a positive value

  Scenario: Provider adds a Dj with price containing letters
    Given the provider wants to add a Dj for weddings
    When the provider enters a price "price" with letters for the Dj
    Then an error should be displayed indicating that the price must be a numeric value


