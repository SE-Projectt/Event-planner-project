package org.example.AcceptanceTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Entity.User;
import MyApp.SignUpMyApp;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class SignUpTest {
    SignUpMyApp SignUp;
    User user = new User();

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

    @Then("the username {string}, password {string} should be saved to the {string} file")
    public void theUsernamePasswordShouldBeSavedToTheFile(String filename, String username, String pass) throws IOException {
        filename = "user_data.txt";
        username = "rema";
        pass = "rema123";

        assertTrue(SignUp.theUsernamePasswordShouldBeSavedToTheFile(filename, username, pass));

    }


    @Given("the system has an existing user with username {string}")
    public void theSystemHasAnExistingUserWithUsername(String username) {
        username = "rema";
        assertTrue(SignUpMyApp.theSystemHasAnExistingUserWithUsername(username));

    }

    @When("I try to sign up with username {string}, password {string}")
    public void iTryToSignUpWithUsernamePassword(String username, String password) {
        username = "rema";
        password = "rema123";
        assertFalse(SignUp.iTryToSignUpWithUsernamePassword(username, password));

    }

    @Then("there is no duplicated user {string} on the {string} file")
    public void thereIsNoDuplicatedUserOnTheFile(String username, String filepath) {
        username="rema";
        filepath="user_data.txt" ;
        assertFalse(SignUp.thereIsNoDuplicatedUserOnTheFile(username,filepath));

    }
    @When("I leave the username field empty")
    public void iLeaveTheUsernameFieldEmpty() {
        String s = "";
        s.isEmpty();
        assertTrue(SignUp.iLeaveTheUsernameFieldEmpty(s));
    }
    @When("I enter password {string}")
    public void iEnterPassword(String pass) {

    }
    @Then("no new user account should be created")
    public void noNewUserAccountShouldBeCreated() throws IOException {


        // Check if the file does not contain the user information
        assertFalse(SignUp.theUsernamePasswordShouldBeSavedToTheFile("user_data.txt", " ",""));

    }





    @When("I leave the password field empty")
    public void iLeaveThePasswordFieldEmpty() {
        String s = "";
        s.isEmpty();
        assertTrue(SignUp.iLeaveThePasswordFieldEmpty(s));

    }

    @When("I enter username {string}")
    public void iEnterUsername(String string) {

    }




}