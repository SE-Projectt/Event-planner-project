Feature: LoggerUtility Testing

  Scenario: Logging an info message
    Given I have a logger
    When I log an info message with format "Test message"
    Then The log message should be "Test message"
