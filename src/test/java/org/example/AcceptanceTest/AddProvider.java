package org.example.AcceptanceTest;

import myapp.AddProviderMyApp;
import myapp.SignUpMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddProvider {
SignUpMyApp signUpMyApp;
AddProviderMyApp addProviderMyApp ;
    public AddProvider() {
        signUpMyApp=new SignUpMyApp() ;
        addProviderMyApp=new AddProviderMyApp();
    }

    @Given("the Provider file exists")
    public void theProviderFileExists() {
    }
    @When("I add a new provider {string} and password {string}")
    public void iAddANewProviderAndPassword(String username, String password) {
        username ="noor";
        password="12345";
      assertTrue(addProviderMyApp.iiEnterValidUsernamePassword(username,password));
    }
    @Then("the Provider file should contain the new provider {string} and password {string} on file {string}")
    public void theProviderFileShouldContainTheNewProviderAndPasswordOnFile(String Filename, String username, String password) throws IOException {
      Filename = "provider_data.txt";
      username="noor";
      password="12345";
      assertTrue(signUpMyApp.theUsernamePasswordShouldBeSavedToTheFile(Filename, username, password));
    }


}
