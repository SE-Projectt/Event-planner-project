package org.example.AcceptanceTest;

import myapp.PayPageMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddMainCourseTest {
    PayPageMyApp payPageMyApp;

    public AddMainCourseTest(){
        payPageMyApp=new PayPageMyApp();
    }
    @Given("the provider wants to add a Main Course for weddings")
    public void theProviderWantsToAddAMainCourseForWeddings() {

    }
    @When("the provider enters an empty name {string} for the Main Course")
    public void theProviderEntersAnEmptyNameForTheMainCourse(String MainCourse) {
        MainCourse = "";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(MainCourse));
    }
    @Then("an error should be displayed indicating that the Main Course name is required")
    public void anErrorShouldBeDisplayedIndicatingThatTheMainCourseNameIsRequired() {

    }


    @When("the provider enters an empty price {string} for the Main Course")
    public void theProviderEntersAnEmptyPriceForTheMainCourse(String price) {
        price="";
        assertTrue(payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(price));
    }


    @When("the provider enters a non-positive price {string} for the Main Course")
    public void theProviderEntersANonPositivePriceForTheMainCourse(String price) {
        price="-3";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(price));
    }



    @When("the provider enters a price {string} with letters for the Main Course")
    public void theProviderEntersAPriceWithLettersForTheMainCourse(String price) {
        price="12w";
        assertFalse(payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(price));
 }

}