Feature: Logging Utility Functionality

  Scenario: Logging a message
    Given the logger is initialized
    When a message "Test message: arg1" is logged at INFO level
    Then the log message "Test message: arg1" should be captured

  Scenario: Logger setup verification
    Given the logger is initialized
    When the logger setup is verified
    Then the logger should have appropriate configuration
