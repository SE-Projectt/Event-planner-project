package MyApp;

public class PayPageMyApp {
    public boolean theUserSubmitsThePaymentFormWithoutEnteringACardNumber(String CardNumber) {
        if(CardNumber.isEmpty())  return true;
        return false;
    }

    public  boolean theUserSubmitsThePaymentFormWithACardNumberContainingLetters(String userInput) {
        // Loop through each character in the string
        for (char c : userInput.toCharArray()) {
            // Check if the character is not a digit
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        // If all characters are digits, return true
        return true;
    }
    public boolean theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(String userInput) {

        // Convert the user input to a double
        Long number = Long.parseLong(userInput);

        // Check if the number is non-negative
        if (number < 0) {
            return false; // If it's negative, return false
        }
        return true; // If it's non-negative, return true

    }
    public  boolean theUserSubmitsThePaymentFormWithACardNumberStartingWith(String userInput) {
        // Check if the input starts with the character '0'
        return userInput.startsWith("0");
    }

    public boolean theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(String userInput) {
        // Check if the length of the input string is 15 or 16
        int length = userInput.length();
        return length == 16;
    }

    public boolean theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(String CardOwnerName) {
        if(CardOwnerName.isEmpty())  return true;
        return false;
    }

    public  boolean theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(String userInput) {
        // Loop through each character in the input string
        for (char c : userInput.toCharArray()) {
            // Check if the character is not a letter
            if (!Character.isLetter(c)) {
                return true; // If it's not a letter, return true
            }
        }
        return false; // If all characters are letters, return false
    }
    public boolean theUserSubmitsThePaymentFormWithoutEnteringTheCVC(String CVC) {
        if(CVC.isEmpty())  return true;
        return false;
    }

    public boolean theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(String userInput) {

        // Convert the user input to a double
        Long number = Long.parseLong(userInput);

        // Check if the number is non-negative
        if (number < 0) {
            return false; // If it's negative, return false
        }
        return true; // If it's non-negative, return true

    }
    public boolean theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(String userInput) {
        // Check if the length of the input string is 15 or 16
        int length = userInput.length();
        return length == 4;
    }

    public  boolean theUserSubmitsThePaymentFormWithACVCContainingLetters(String userInput) {
        // Loop through each character in the string
        for (char c : userInput.toCharArray()) {
            // Check if the character is not a digit
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        // If all characters are digits, return true
        return true;
    }

    public  boolean theUserSubmitsThePaymentFormWithACVCStartingWith(String userInput) {
        // Check if the input starts with the character '0'
        return userInput.startsWith("0");
    }

}
