Feature: Payment Page Validation

  Scenario: Empty Card Number
    Given the user is on the payment page
    When the user submits the payment form without entering a card number
    Then they should see a message indicating that the card number is required

  Scenario: Non-Positive Card Number
    Given the user is on the payment page
    When the user submits the payment form with a non-positive number in the card number field
    Then they should see a message indicating that a valid card number is required

  Scenario: Letter in Card Number
    Given the user is on the payment page
    When the user submits the payment form with a card number containing letters
    Then they should see a message indicating that the card number should only contain digits

  Scenario: Card Number Starting with 0
    Given the user is on the payment page
    When the user submits the payment form with a card number starting with 0
    Then they should see a message indicating that the card number should not start with 0

  Scenario: Invalid Card Number Length
    Given the user is on the payment page
    When the user submits the payment form with a card number that is not  16 digits long
    Then they should see a message indicating that the card number should be 16 digits long

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

  Scenario: CVC Can Contain Letter
    Given the user is on the payment page
    When the user submits the payment form with a CVC containing letters
    Then they should see a message indicating that the CVC should only contain digits

  Scenario: CVC Starting with 0
    Given the user is on the payment page
    When the user submits the payment form with a CVC starting with 0
    Then they should see a message indicating that the CVC should not start with 0

  Scenario: CVC Not 3 Digits
    Given the user is on the payment page
    When the user submits the payment form with a CVC that is not 3 digits long
    Then they should see a message indicating that the CVC should be a 3 digit number
