Feature: Switch Account to Provider

  Scenario:User have not Access to switch his account to become a provider
    Given I am logged in as a regular user
    And This username "username",password "password" have access to be a provider
    When I choose to switch my account type to become a provider
    Then I should be redirected to the information page

  Scenario: User have Access to switch his account to become a provider
    Given I am logged in as a regular user
    And This username "username",password "password" have not access to be a provider
    When I choose to switch my account type to a provider
    Then I should be redirected to the provider page