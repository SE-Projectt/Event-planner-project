Feature: Package Management

  Scenario: Provider adds package named "ahmadpackage" to the file "Package.txt"
    Given the provider wants to add a package named "ahmadpackage" to the file "Package.txt"
    When the provider adds the package  to the file
    Then the package "ahmadpackage" should be added successfully to the file "Package.txt"

  Scenario: Provider deletes package named "ahmadpackage" from the file "Package.txt"
    Given the provider wants to delete a package named "ahmadpackage" from the file "Package.txt"
    When the provider deletes the package from the file
    Then the package "ahmadpackage" should be deleted successfully from the file "Package.txt"

  Scenario: User chooses a package named "ahmadpackage" and adds it to file "Event.txt"
    Given the user wants to choose a package named "ahmadpackage"
    When the user adds the package to the file "Event.txt"
    Then the package "ahmadpackage" should be added to the file "Event.txt"

  Scenario: User enters a budget "6000" and chooses suitable package "ahmadpackage" for the user
    Given the user wants to enter a budget of "6000"
    When the user chooses a suitable package named "ahmadpackage" based on the budget
    Then the package "ahmadpackage" should be added to the file "Event.txt"
