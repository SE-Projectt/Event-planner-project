package org.example.AcceptanceTest;

import myapp.PayPageMyApp;
import myapp.SignUpMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class AddHallsTest {

    PayPageMyApp payPageMyApp;
    SignUpMyApp signup=new SignUpMyApp();
    public AddHallsTest ()
    {

        payPageMyApp = new PayPageMyApp();
    }

    @When("the provider enters an empty name {string} for the hall")
    public void theProviderEntersAnEmptyNameForTheHall(String hallname) {
        hallname = "";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(hallname));
    }
    @Then("an error should be displayed indicating that the hall name is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheHallNameIsRequired() {

    }



    @When("the provider enters an empty capacity {string} for the hall")
    public void theProviderEntersAnEmptyCapacityForTheHall(String capacity) {
        capacity = "";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(capacity));
    }
    @Then("an error should be displayed indicating that the capacity is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheCapacityIsRequired() {

    }


    @When("the provider enters a non-positive capacity {string} for the hall")
    public void theProviderEntersANonPositiveCapacityForTheHall(String capacity) {
        capacity="-3";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(capacity));

    }
    @Then("an error should be displayed indicating that the capacity must be a positive value")
    public void anErrorShouldBeDisplayedIndicatingThatTheCapacityMustBeAPositiveValue() {

    }



    @When("the provider enters a capacity {string} with letters for the hall")
    public void theProviderEntersACapacityWithLettersForTheHall(String capacity) {
        capacity="12w";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(capacity));
    }
    @Then("an error should be displayed indicating that the capacity must be a numeric value")
    public void anErrorShouldBeDisplayedIndicatingThatTheCapacityMustBeANumericValue() {

    }



    @When("the provider enters an empty price {string} for the hall")
    public void theProviderEntersAnEmptyPriceForTheHall(String price) {
        price="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(price));
    }
    @Then("an error should be displayed indicating that the price is required")
    public void anErrorShouldBeDisplayedIndicatingThatThePriceIsRequired() {

    }



    @When("the provider enters a non-positive price {string} for the hall")
    public void theProviderEntersANonPositivePriceForTheHall(String price) {
        price="-3";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(price));

    }
    @Then("an error should be displayed indicating that the price must be a positive value")
    public void anErrorShouldBeDisplayedIndicatingThatThePriceMustBeAPositiveValue() {

    }



    @When("the provider enters a price {string} with letters for the hall")
    public void theProviderEntersAPriceWithLettersForTheHall(String price) {
        price="12w";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(price));
    }
    @Then("an error should be displayed indicating that the price must be a numeric value")
    public void anErrorShouldBeDisplayedIndicatingThatThePriceMustBeANumericValue() {

    }




    @Given("the provider wants to add a hall for weddings")
    public void theProviderWantsToAddAHallForWeddings() {

    }
    @When("the provider enters an empty location {string} for the hall")
    public void theProviderEntersAnEmptyLocationForTheHall(String location) {
        location="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName( location));
    }
    @Then("an error should be displayed indicating that the location is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheLocationIsRequired() {

    }

    @Given("the system has an existing Hall with Hallname {string}")
    public void theSystemHasAnExistingHallWithHallname(String string) {

    }
    @When("I try to assert with Hallname {string} in file {string}")
    public void iTryToAssertWithHallnameInFile(String Hallname, String FileName) {
        Hallname="alameer";
        FileName="Halls.txt";
        assertFalse(signup.thereIsNoDuplicatedUserOnTheFile(Hallname,FileName));

    }
    @Then("there is no duplicated Hall {string} on the {string} file")
    public void thereIsNoDuplicatedHallOnTheFile(String string, String string2) {

 }


}