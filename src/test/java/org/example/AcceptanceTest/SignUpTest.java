package org.example.AcceptanceTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import MyApp.SignUpMyApp;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpTest {
    SignUpMyApp SignUp;

    public SignUpTest() {
        SignUp = new SignUpMyApp();
    }


    @Given("the system is ready for user sign-up")
    public void theSystemIsReadyForUserSignUp() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I enter valid username {string}, password {string}")
    public void iEnterValidUsernamePassword(String username, String password) {
        username = "rema";
        password = "rema123";

        assertTrue(SignUp.iiEnterValidUsernamePassword(username, password));


    }

    @Given("the system has an existing user with username {string}")
    public void theSystemHasAnExistingUserWithUsername(String username) {
        username = "rema";
        assertTrue(SignUpMyApp.checkCredentials(username));

    }

    @When("I try to sign up with username {string}, password {string}")
    public void iTryToSignUpWithUsernamePassword(String username, String password) {
        username = "rema";
        password = "rema123";

        assertTrue(SignUp.iiEnterValidUsernamePassword(username, password));
    }


    @Then("no new user account should be created")
    public void noNewUserAccountShouldBeCreated() {
int x =5;


    }

    @When("I leave the username field empty")
    public void iLeaveTheUsernameFieldEmpty() {
String s="";
        s.isEmpty();
       assertTrue(SignUp.iLeaveTheUsernameFieldEmpty(s));
    }

    @When("I enter password {string}")
    public void iEnterPassword(String string) {

    }

    @When("I leave the password field empty")
    public void iLeaveThePasswordFieldEmpty() {
        String s="";
        s.isEmpty();
        assertTrue(SignUp.iLeaveThePasswordFieldEmpty(s));

    }

    @When("I enter username {string}")
    public void iEnterUsername(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the user information should be saved to the {string} file")
    public void theUserInformationShouldBeSavedToTheFile(String string) {
        // Write code here that turns the phrase above into concrete actions


    }
}