Feature: Wedding Planning

  Scenario: Choose a Wedding Hall
    Given the user has started planning
    When the user chooses a  wedding hall named "Elegant Gardens Hall" from file "Halls.txt"
    Then the selected wedding hall named "Elegant Gardens Hall" should be recorded on file "Reservations.txt"

  Scenario: Select main course
    Given the user has started planning
    When the user selects  main course "main course" from file "maincourse.txt"
    Then the chosen main course "testy" course should be recorded on file "Reservations.txt"

  Scenario: Select desert course
    Given the user has started planning
    When the user selects  desert "desert" from file "desert.txt"
    Then the chosen desert "desert" course should be recorded on file "Reservations.txt"

  Scenario: Hire a DJ
    Given the user has started planning
    When the user hires a DJ "DJ" from file "Dj.txt"
    Then the selected DJ "djname" should be recorded on file "Reservations.txt"

  Scenario: Book a Photography Studio
    Given the user has started planning
    When the user books a photography studio "photography studio" from file "studio.txt"
    Then the booked photography studio "studio" should be recorded on file "Reservations.txt"

  Scenario: Order Flowers
    Given the user has started planning
    When the user selects flowers "flowers" from file "flowers.txt"
    Then the ordered flowers  "flower" should be recorded on file "Reservations.txt"



  Scenario: Choose a Wedding Hall2
    Given the user has started planning
    When the user chooses a  wedding hall named "Elegant Gardens Hall" from file "Halls.txt"
    Then the user check if selected wedding hall named "Elegant Gardens Hall" and the wedding date "YYYY-MM-DD" are visible at file "reservedHalls.txt"
    And store the hall "Elegant Gardens Hall" and the wedding date "YYYY-MM-DD" at "Reservation.txt" file
