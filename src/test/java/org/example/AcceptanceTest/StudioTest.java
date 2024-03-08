package org.example.AcceptanceTest;

import MyApp.PayPageMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudioTest {
    PayPageMyApp payPageMyApp;

    public StudioTest(){
        payPageMyApp=new PayPageMyApp();
    }
    @Given("the provider wants to add a Studio for weddings")
    public void theProviderWantsToAddAStudioForWeddings() {

    }
    @When("the provider enters an empty name {string} for the Studio")
    public void theProviderEntersAnEmptyNameForTheStudio(String StudioName) {
        StudioName = "";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(StudioName));
    }
    @Then("an error should be displayed indicating that the Studio name is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheStudioNameIsRequired() {

    }

    @When("the provider enters an empty price {string} for the Studio")
    public void theProviderEntersAnEmptyPriceForTheStudio(String price) {
        price="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(price));
    }

    @When("the provider enters a non-positive price {string} for the Studio")
    public void theProviderEntersANonPositivePriceForTheStudio(String price) {
        price="-3";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(price));
    }
    @When("the provider enters a price {string} with letters for the Studio")
    public void theProviderEntersAPriceWithLettersForTheStudio(String price) {
        price="12w";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(price));
 }

}