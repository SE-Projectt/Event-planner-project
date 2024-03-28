Feature: Yearly Booking Calendar Creation

  Scenario: Hall Booking Calendar Creation
    Given a hall name "Hall A"
    When the application creates a yearly booking calendar for the hall
    Then the booking calendar for "Hall A" should be successfully created

  Scenario: Hall Name Trimming
    Given a hall name "  Hall B  "
    When the application creates a yearly booking calendar for the trimmed hall name
    Then the booking calendar for "Hall B" should be successfully created
