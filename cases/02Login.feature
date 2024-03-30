Feature: User Login

  Scenario: User login successfully
    Given the system has registered user with username "johndoe" and password "password123"
    When  I enter valid username "johndoe" and password "password123" has already registered
    Then I should be successfully logged in

  Scenario: User login with non-existing username and password
    Given the system has no registered user with username "nonexistentuser" and password "somepassword"
    When I enter non-existing username "nonexistentuser" and password "somepassword"
    Then I should not be logged in

  Scenario: User login with incorrect password
    Given the system has registered user with username "johndoe" and password "password123"
    When I enter valid username "johndoe" and incorrect password "wrongpassword"
    Then I should not be logged in


  Scenario: User login with empty username
    When I leave the username field empty
    Then I should not be logged in

  Scenario: User login with empty password
    When I  leave the password field empty
    Then I should not be logged in

  Scenario: User enters username with special characters and correct password
    Given the system has registered user with username "user$123" and password "password123"
    When I enter valid username "user$123" and password "password123" has already registered
    Then I should be successfully logged in

  Scenario: User logs in with no registered users
    Given the system has no registered user
    When I enter non-existing username "nonexistent" and password "password123"
    Then I should not be logged in

  
