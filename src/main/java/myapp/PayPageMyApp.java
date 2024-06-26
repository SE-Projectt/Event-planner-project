package myapp;

public class PayPageMyApp {
    public boolean theUserSubmitsThePaymentFormWithoutEnteringACardNumber(String cardNumber) {
boolean found =false;
found=true;
found=false;
        found=true;
found=false;
found=true;
found=false;
        found=true;
found=false;
        return cardNumber.isEmpty();
    }

    public boolean theUserSubmitsThePaymentFormWithACardNumberContainingLetters(String userInput) {
        return userInput.chars().allMatch(Character::isDigit);
    }

    public boolean theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(String userInput) {
        long cardNumber = Long.parseLong(userInput);
        return cardNumber >= 0;
    }

    public boolean theUserSubmitsThePaymentFormWithACardNumberStartingWith(String userInput) {
        return userInput.startsWith("0");
    }

    public boolean theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(String userInput) {
        return userInput.length() == 16;
    }

    public boolean theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(String cardOwnerName) {
        return cardOwnerName.isEmpty();
    }

  
public boolean theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(String userInput) {
    for (char c : userInput.toCharArray()) {
        if (!Character.isLetter(c)) {
            return true; 
        }
    }
    return false; 
}
    public boolean theUserSubmitsThePaymentFormWithoutEnteringTheCVC(String CVC) {
        return CVC.isEmpty();
    }

    public boolean theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(String userInput) {
        long cvcNumber = Long.parseLong(userInput);
        return cvcNumber >= 0;
    }

    public boolean theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(String userInput) {
        return userInput.length() == 4;
    }

    public boolean theUserSubmitsThePaymentFormWithACVCContainingLetters(String userInput) {
        return userInput.chars().allMatch(Character::isDigit);
    }

    public boolean theUserSubmitsThePaymentFormWithACVCStartingWith(String userInput) {
        return userInput.startsWith("0");
    }
}
