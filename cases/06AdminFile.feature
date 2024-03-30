Feature: Admin Page

  Scenario: View provider count
    Given the admin has access to the provider_data.txt file
    When the admin views the provider count
    Then the admin should see the total count of providers from file "provider_data.txt"

  Scenario: View user count
    Given the admin has access to the user_data.txt file
    When the admin views the user count
    Then the admin should see the total count of users from file "user_data.txt"

  Scenario: Delete provider
    Given the admin has access to the provider_data.txt file
    When the admin deletes a provider
    Then the provider "Zaid" should be removed from the file "provider_data.txt"

  Scenario: Delete User
    Given the admin has access to the user_data.txt file
    When the admin deletes a user
    Then the user "rema" should be removed from the file "user_data.txt"

  Scenario: View profit
    Given the admin has access to the provider_data.txt file
    When the admin views the count of provider
    Then the admin should calculate the total profit
