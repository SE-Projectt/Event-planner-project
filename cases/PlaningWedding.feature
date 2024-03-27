Feature: User Planning Wedding

  Scenario: User starts planning and chooses a hall
    Given a user chose to start planning
    When the user clicks to choose a hall
    And display all halls available in the file "Halls.txt"
    Then Check if the entrance hall name "Hall" is in the file "Halls.txt"
    And store the chosen hall "Hall" in the file "event.txt"
    And store the chosen hall "Hall" with chosen Date "dd-mm-yyyy" in the file "bookingHall.txt"

  Scenario: User starts planning and chooses a Dj
    Given a user chose to start planning
    When the user clicks to choose a Dj
    And display all Djs available in the file "Dj.txt"
    Then Check if the entrance Dj name "Dj" is in the file "Dj.txt"
    And store the chosen Dj "Dj" in the file "event.txt"
    And store the chosen Dj "Dj" with chosen Date "dd-mm-yyyy" in the file "BookingDJ.txt"

  Scenario: User starts planning and chooses a Studio
    Given a user chose to start planning
    When the user clicks to choose a Studio
    And display all Studios available in the file "studio.txt"
    Then Check if the entrance Studio name "studio" is in the file "studio.txt"
    And store the chosen Studio "studio" in the file "event.txt"
    And store the chosen Studio "studio" with chosen Date "dd-mm-yyyy" in the file "bookingStudio.txt"

  Scenario: User starts planning and chooses a Flower
    Given a user chose to start planning
    When the user clicks to choose a Flower
    And display all Flowers available in the file "flower.txt"
    Then Check if the entrance Flower "studio"  name is in the file "flower.txt"
    And store the chosen Flower "studio" in the file "event.txt"

  Scenario: User starts planning and chooses a Maincourse
    Given a user chose to start planning
    When the user clicks to choose a Maincourse
    And display all Maincourses available in the file "maincourse.txt"
    Then Check if the entrance Maincourse name "Maincourse" is in the file "maincourse.txt"
    And store the chosen Maincourse "Maincourse" in the file "event.txt"

  Scenario: User starts planning and chooses a Desert
    Given a user chose to start planning
    When the user clicks to choose a Desert
    And display all Deserts available in the file "desert.txt"
    Then Check if the entrance Desert name "Desert" is in the file "desert.txt"
    And store the chosen Desert "Desert" in the file "event.txt"