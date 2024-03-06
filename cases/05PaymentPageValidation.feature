Feature: Payment Page Validation

  Scenario: Empty Card Number
    Given the user is on the payment page
    When the user submits the payment form without entering a card number
    Then they should see a message indicating that the card number is required

  Scenario: Non-Positive Card Number
    Given the user is on the payment page
    When the user submits the payment form with a non-positive number in the card number field
    Then they should see a message indicating that a valid card number is required

  Scenario: Empty Card Owner Name
    Given the user is on the payment page
    When the user submits the payment form without entering the card owner's name
    Then they should see a message indicating that the name of the card owner is required

  Scenario: Invalid Card Owner Name
    Given the user is on the payment page
    When the user submits the payment form with non-letter characters in the card owner's name field
    Then they should see a message indicating that only letters are allowed for the card owner's name

  Scenario: Empty CVC
    Given the user is on the payment page
    When the user submits the payment form without entering the CVC
    Then they should see a message indicating that the CVC is required

  Scenario: Non-Positive CVC
    Given the user is on the payment page
    When the user submits the payment form with a non-positive number in the CVC field
    Then they should see a message indicating that a valid CVC is required

  Scenario: Invalid CVC Length
    Given the user is on the payment page
    When the user submits the payment form with more than 4 digits in the CVC field
    Then they should see a message indicating that the CVC should be a 3 or 4 digit number