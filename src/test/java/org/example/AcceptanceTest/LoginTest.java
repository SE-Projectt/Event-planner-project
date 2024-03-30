package org.example.AcceptanceTest;

import MyApp.LoginMyApp;
import MyApp.SignUpMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
       // username="rema";password="rema123";
       // assertTrue(login.theSystemHasRegisteredUserWithUsernameAndPassword(username,password));
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


}
