package org.example.AcceptanceTest;

import myapp.LoginMyApp;
import myapp.SignUpMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class LoginTest {
    SignUpMyApp SignUp;
   LoginMyApp login;
    private boolean result;
    private String username;
    private String password;
    public LoginTest(){
        login=new LoginMyApp();
        SignUp=new SignUpMyApp();
    }
    @Given("the system has registered user with username {string} and password {string}")
    public void theSystemHasRegisteredUserWithUsernameAndPassword(String username, String password) {
     this.username=username;
     this.password=password;

    }
    @When("I enter valid username {string} and password {string} has already registered")
    public void iEnterValidUsernameAndPasswordHasAlreadyRegistered(String username, String password) {
        username="rema";password="rema123";
      result=  login.theSystemHasRegisteredUserWithUsernameAndPassword(username,password);

    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {


        assertTrue(result);
    }


    @Given("the system has no registered user with username {string} and password {string}")
    public void theSystemHasNoRegisteredUserWithUsernameAndPassword(String username, String password) {
        this.username=username;
        this.password=password;
    }


    @When("I enter non-existing username {string} and password {string}")
    public void iEnterNonExistingUsernameAndPassword(String username, String password) {
        username="rrrr";password="0000";
       result=login.theSystemHasRegisteredUserWithUsernameAndPassword(username,password);
    }

    @Then("I should not be logged in")
    public void iShouldNotBeLoggedIn() {

        assertFalse(result);
    }


    @When("I enter valid username {string} and incorrect password {string}")
    public void iEnterValidUsernameAndIncorrectPassword(String username, String password) {
        username="rema";password="0000";
        assertTrue(login.iEnterValidUsernameAndIncorrectPassword(username,password));

    }

    /////
    @When("I leave the username field empty ")
    public void iLeaveTheUsernameFieldEmptyAndEnterPassword(String string) {
        String s="";
        assertTrue(SignUp.iLeaveTheUsernameFieldEmpty(s));
    }


    @When("I  leave the password field empty")
    public void iLeaveThePasswordFieldEmpty() {
        String s="";
        assertTrue(SignUp.iLeaveThePasswordFieldEmpty(s));
    }

    @Given("the system has no registered user")
    public void theSystemHasNoRegisteredUser() {
        // You can add any setup here if needed
    }


    private boolean loginResult;
    private String filePath = "user_data.txt";

    @Given("the user data file is inaccessible")
    public void theUserDataFileIsInaccessible() throws IOException {
        Files.setAttribute(Path.of(filePath), "dos:readonly", true);
        File file = new File(filePath);
        file.setReadable(false);
    }

    @When("I attempt to login with valid username {string} and password {string}")
    public void iAttemptToLoginWithValidUsernameAndPassword(String string, String string2) {
        login = new LoginMyApp();
        loginResult = login.iEnterValidUsernameAndIncorrectPassword(username, password);
    }
    @Then("the system should handle the error gracefully and return false")
    public void theSystemShouldHandleTheErrorGracefullyAndReturnFalse() {
        assertFalse(loginResult);
    }




}
