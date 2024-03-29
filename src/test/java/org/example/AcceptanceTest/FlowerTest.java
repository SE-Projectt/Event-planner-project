package org.example.AcceptanceTest;

import myapp.PayPageMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlowerTest {


    PayPageMyApp payPageMyApp;

    public FlowerTest ()
    {
        payPageMyApp = new PayPageMyApp();

    }
    @Given("the provider wants to add a Flower for weddings")
    public void theProviderWantsToAddAFlowerForWeddings() {


    }
    @When("the provider enters an empty name {string} for the Flower")
    public void theProviderEntersAnEmptyNameForTheFlower(String flowername) {
        flowername="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName( flowername));

    }
    @Then("an error should be displayed indicating that the Flower name is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheFlowerNameIsRequired() {

    }



    @When("the provider enters an empty price {string} for the Flower")
    public void theProviderEntersAnEmptyPriceForTheFlower(String   price) {

        price="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(price));

    }
    @Then("an error should be displayed indicating that the Flower is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheFlowerIsRequired() {


    }



    @When("the provider enters a non-positive price {string} for the Flower")
    public void theProviderEntersANonPositivePriceForTheFlower(String price) {
        price="-3";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(price));

    }



    @When("the provider enters a price {string} with letters for the Flower")
    public void theProviderEntersAPriceWithLettersForTheFlower(String price) {

        price="12w";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(price));
    }
}
