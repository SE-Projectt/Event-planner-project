package org.example.AcceptanceTest;

import myapp.PayPageMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class dessertTest {

    PayPageMyApp payPageMyApp;

    public dessertTest ()
    {
        payPageMyApp = new PayPageMyApp();

    }

    @When("the provider enters an empty name {string} for the dessert")
    public void theProviderEntersAnEmptyNameForTheDessert(String dessertname) {

        dessertname="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName( dessertname));

    }
    @Then("an error should be displayed indicating that the dessert name is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheDessertNameIsRequired() {

    }



    @When("the provider enters an empty price {string} for the dessert")
    public void theProviderEntersAnEmptyPriceForTheDessert(String  price) {
        price="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(price));

    }
    @Then("an error should be displayed indicating that the dessert is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheDessertIsRequired() {

    }



    @Given("the provider wants to add a dessert for weddings")
    public void theProviderWantsToAddADessertForWeddings() {

    }
    @When("the provider enters a non-positive price {string} for the dessert")
    public void theProviderEntersANonPositivePriceForTheDessert(String price ){
        price="-3";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(price));

    }



    @Given("the provider wants to add a dessertr for weddings")
    public void theProviderWantsToAddADessertrForWeddings() {

    }
    @When("the provider enters a price {string} with letters for the dessert")
    public void theProviderEntersAPriceWithLettersForTheDessert(String  price) {
        price="12w";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(price));
    }

}
