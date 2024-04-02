Feature: Yearly Booking Calendar

  Scenario: User books a date successfully
    Given The Yearly Booking Calendar is open for "HallName"
    When The user selects a date to book
    Then The date should be booked successfully for "HallName"

  Scenario: User tries to book an already booked date
    Given The Yearly Booking Calendar is open for "HallName"
    And The date is already booked for "HallName"
    When The user tries to book the same date
    Then The system should not allow booking the already booked date
