package org.example.AcceptanceTest;
import myapp.LoginMyApp;
import myapp.SignUpMyApp;
import myapp.SwitchAccountToProviderMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SwitchAccountToProvider {
    SwitchAccountToProviderMyApp SATP;
    public SwitchAccountToProvider(){
        SATP =new SwitchAccountToProviderMyApp();

    }
    @Given("I am logged in as a regular user")
    public void iAmLoggedInAsARegularUser() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("This username {string},password {string} have access to be a provider")
    public void thisUsernamePasswordHaveAccessToBeAProvider(String username, String password) {
        username="rema";
        password="rema123";
        assertFalse(SATP.thisUsernamePasswordHaveAccessToBeProvider(username,password));

    }
    @When("I choose to switch my account type to become a provider")
    public void iChooseToSwitchMyAccountTypeToBecomeAProvider() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("I should be redirected to the information page")
    public void iShouldBeRedirectedToTheInformationPage() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Given("This username {string},password {string} have not access to be a provider")
    public void thisUsernamePasswordHaveNotAccessToBeAProvider(String username, String password) {
        username="rema";
        password="rema123";
        assertFalse(SATP.thisUsernamePasswordHaveAccessToBeProvider(username,password));

    }
    @When("I choose to switch my account type to a provider")
    public void iChooseToSwitchMyAccountTypeToAProvider() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("I should be redirected to the provider page")
    public void iShouldBeRedirectedToTheProviderPage() {


    }


}