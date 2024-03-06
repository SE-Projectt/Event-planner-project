package org.example.AcceptanceTest;
import Entity.PayInformation;
import MyApp.LoginMyApp;
import MyApp.PayPageMyApp;
import MyApp.SignUpMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class PaymentPageValidationTest{
    PayPageMyApp Pay;
    PayInformation PayI=new PayInformation();
    public PaymentPageValidationTest(){

        Pay=new PayPageMyApp();
    }
    @Given("the user is on the payment page")
    public void theUserIsOnThePaymentPage() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form without entering a card number")
    public void theUserSubmitsThePaymentFormWithoutEnteringACardNumber() {
        String s = "";
        s.isEmpty();
        assertTrue(Pay.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(s));

    }
    @Then("they should see a message indicating that the card number is required")
    public void theyShouldSeeAMessageIndicatingThatTheCardNumberIsRequired() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with a non-positive number in the card number field")
    public void theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField() {
        String s= "-4";
        assertFalse(Pay.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(s));
    }
    @Then("they should see a message indicating that a valid card number is required")
    public void theyShouldSeeAMessageIndicatingThatAValidCardNumberIsRequired() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with a card number containing letters")
    public void theUserSubmitsThePaymentFormWithACardNumberContainingLetters() {
        String s="q";
        assertFalse(Pay.theUserSubmitsThePaymentFormWithACardNumberContainingLetters(s));

    }
    @Then("they should see a message indicating that the card number should only contain digits")
    public void theyShouldSeeAMessageIndicatingThatTheCardNumberShouldOnlyContainDigits() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with a card number starting with {int}")
    public void theUserSubmitsThePaymentFormWithACardNumberStartingWith(Integer int1) {

        assertTrue(Pay.theUserSubmitsThePaymentFormWithACardNumberStartingWith("044444"));
    }
    @Then("they should see a message indicating that the card number should not start with {int}")
    public void theyShouldSeeAMessageIndicatingThatTheCardNumberShouldNotStartWith(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with a card number that is not  {int} digits long")
    public void theUserSubmitsThePaymentFormWithACardNumberThatIsNotDigitsLong(Integer int1) {
        assertTrue(Pay.theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong("asasasasasasasaa"));

    }
    @Then("they should see a message indicating that the card number should be {int} digits long")
    public void theyShouldSeeAMessageIndicatingThatTheCardNumberShouldBeDigitsLong(Integer int1) {


    }

    @When("the user submits the payment form without entering the card owner's name")
    public void theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName() {
        String s = "";
        s.isEmpty();
        assertTrue(Pay.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(s));

    }
    @Then("they should see a message indicating that the name of the card owner is required")
    public void theyShouldSeeAMessageIndicatingThatTheNameOfTheCardOwnerIsRequired() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with non-letter characters in the card owner's name field")
    public void theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField() {
        String s="zasd9+";
        assertTrue(Pay.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(s));

    }
    @Then("they should see a message indicating that only letters are allowed for the card owner's name")
    public void theyShouldSeeAMessageIndicatingThatOnlyLettersAreAllowedForTheCardOwnerSName() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form without entering the CVC")
    public void theUserSubmitsThePaymentFormWithoutEnteringTheCVC() {
        String S="";
        assertTrue(Pay.theUserSubmitsThePaymentFormWithoutEnteringTheCVC(S));

    }
    @Then("they should see a message indicating that the CVC is required")
    public void theyShouldSeeAMessageIndicatingThatTheCVCIsRequired() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with a non-positive number in the CVC field")
    public void theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField() {
        String s= "-4";
        assertFalse(Pay.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(s));

    }
    @Then("they should see a message indicating that a valid CVC is required")
    public void theyShouldSeeAMessageIndicatingThatAValidCVCIsRequired() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("the user submits the payment form with a CVC containing letters")
    public void theUserSubmitsThePaymentFormWithACVCContainingLetters() {
        String s="hjk+_78";
        assertFalse(Pay.theUserSubmitsThePaymentFormWithACVCContainingLetters(s));

    }
    @Then("they should see a message indicating that the CVC should only contain digits")
    public void theyShouldSeeAMessageIndicatingThatTheCVCShouldOnlyContainDigits() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with a CVC starting with {int}")
    public void theUserSubmitsThePaymentFormWithACVCStartingWith(Integer int1) {
        String s= "0123123";
        assertTrue(Pay.theUserSubmitsThePaymentFormWithACVCStartingWith(s));

    }
    @Then("they should see a message indicating that the CVC should not start with {int}")
    public void theyShouldSeeAMessageIndicatingThatTheCVCShouldNotStartWith(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("the user submits the payment form with a CVC that is not {int} digits long")
    public void theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(Integer int1) {
        String s= "1234";
        assertTrue(Pay.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(s));

    }
    @Then("they should see a message indicating that the CVC should be a {int} digit number")
    public void theyShouldSeeAMessageIndicatingThatTheCVCShouldBeADigitNumber(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }
}