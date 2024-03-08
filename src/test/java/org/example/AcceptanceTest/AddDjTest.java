package org.example.AcceptanceTest;

import MyApp.PayPageMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddDjTest {
    PayPageMyApp payPageMyApp;

    public AddDjTest ()
    {
        payPageMyApp = new PayPageMyApp();

    }

    @Given("the provider wants to add a Dj for weddings")
    public void theProviderWantsToAddADjForWeddings() {

    }
    @When("the provider enters an empty name {string} for the Dj")
    public void theProviderEntersAnEmptyNameForTheDj(String djname) {
 djname="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(djname));

    }
    @Then("an error should be displayed indicating that the Dj name is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheDjNameIsRequired() {

    }

    @When("the provider enters an empty price {string} for the Dj")
    public void theProviderEntersAnEmptyPriceForTheDj(String price) {
        price="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(price));

    }


    @When("the provider enters a non-positive price {string} for the Dj")
    public void theProviderEntersANonPositivePriceForTheDj(String  price) {
        price="-3";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(price));

    }

    @When("the provider enters a price {string} with letters for the Dj")
    public void theProviderEntersAPriceWithLettersForTheDj(String  price) {

        price="12w";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(price));
    }






}
