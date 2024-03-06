Feature: Admin Page

  Scenario: Admin views user information requesting to be a provider
    Given Admin is logged in to the admin page
    When Admin can see the list of users requesting to be providers
    Then Admin views user information requesting to be a provider

  Scenario: Admin accepts a user request to be a provider
    Given Admin is logged in to the admin page
    And Admin views user information requesting to be a provider
    When Admin accepts a user request to be a provider
    Then The user becomes a provider and is notified

  Scenario: Admin rejects a user request to be a provider
    Given Admin is logged in to the admin page
    And Admin views user information requesting to be a provider
    When Admin rejects a user request to be a provider
    Then The user's request is rejected and the user is notified

  Scenario: Admin searches for user information by providername
    Given Admin is logged in to the admin page
    When Admin searches for provider information by providername "rema" from file "provider_data.txt"
    Then The provider's information is displayed

  Scenario: Admin deletes a provider from the provider file
    Given Admin is logged in to the admin page
    And Admin views the provider list
    When Admin deletes a provider from the provider file
    Then The provider is removed from the provider file

  Scenario: Admin views his profit from providers subscriptions
    Given Admin is logged in to the admin page
    When Admin views his profit from providers subscriptions
    Then The total profit from providers' subscriptions is displayed

  Scenario: Admin searches for user information by username
    Given Admin is logged in to the admin page
    When Admin searches for user information by username "rema" from file "user_data.txt"
    Then The user's information is displayed

  Scenario: Admin views user information and users count
    Given Admin is logged in to the admin page
    When Admin views user information and users count
    Then User information (username, password) and the number of users are displayed

  Scenario: Admin deletes a user from the user file
    Given Admin is logged in to the admin page
    And Admin views user information and user count
    When Admin deletes a user from the user file
    Then The user is removed from the user file