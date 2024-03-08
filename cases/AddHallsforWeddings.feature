Feature: Add Halls for Weddings

  Scenario: Provider adds a hall with empty name
    Given the provider wants to add a hall for weddings
    When the provider enters an empty name "hallname" for the hall
    Then an error should be displayed indicating that the hall name is required

  Scenario: Provider adds a hall with empty capacity
    Given the provider wants to add a hall for weddings
    When the provider enters an empty capacity "capacity" for the hall
    Then an error should be displayed indicating that the capacity is required

  Scenario: Provider adds a hall with non-positive capacity
    Given the provider wants to add a hall for weddings
    When the provider enters a non-positive capacity "capacity" for the hall
    Then an error should be displayed indicating that the capacity must be a positive value

  Scenario: Provider adds a hall with capacity containing letters
    Given the provider wants to add a hall for weddings
    When the provider enters a capacity "capacity" with letters for the hall
    Then an error should be displayed indicating that the capacity must be a numeric value

  Scenario: Provider adds a hall with empty price
    Given the provider wants to add a hall for weddings
    When the provider enters an empty price "price" for the hall
    Then an error should be displayed indicating that the price is required

  Scenario: Provider adds a hall with non-positive price
    Given the provider wants to add a hall for weddings
    When the provider enters a non-positive price "price" for the hall
    Then an error should be displayed indicating that the price must be a positive value

  Scenario: Provider adds a hall with price containing letters
    Given the provider wants to add a hall for weddings
    When the provider enters a price "price" with letters for the hall
    Then an error should be displayed indicating that the price must be a numeric value

  Scenario: Provider adds a hall with empty location
    Given the provider wants to add a hall for weddings
    When the provider enters an empty location "location" for the hall
    Then an error should be displayed indicating that the location is required

  Scenario:user try to assert an existing Hall name
    Given the system has an existing Hall with Hallname "Hallname"
    When I try to assert with Hallname "Hallname" in file "Halls.txt"
    Then there is no duplicated Hall "Hallname" on the "Halls.txt" file