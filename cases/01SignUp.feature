Feature: User Sign-Up
  Scenario:user sign-up successfully
    Given the system is ready for user sign-up
    When I enter valid username "johndoe", password "password123"
    Then the username "johndoe", password "password123" should be saved to the "users.txt" file

  Scenario:user try to sign-up with an existing user name
    Given the system has an existing user with username "johndoe"
    When I try to sign up with username "johndoe", password "mypassword"
    Then there is no duplicated user "johndoe" on the "users.txt" file


  Scenario:user leave the username field empty
    Given the system is ready for user sign-up
    When I leave the username field empty
    And I enter password "helloworld"
    Then no new user account should be created


  Scenario:user leave the password field empty
    Given the system is ready for user sign-up
    When I leave the password field empty
    And I enter username "helloworld"
    Then no new user account should be created
