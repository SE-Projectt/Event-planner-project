package org.example.AcceptanceTest;

import myapp.AdminMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AdminTest {
AdminMyApp adminMyApp ;
public AdminTest ()
{
  adminMyApp = new AdminMyApp() ;
}



  @Given("the admin has access to the provider_data.txt file")
  public void theAdminHasAccessToTheProviderDataTxtFile() {

  }
  @When("the admin views the provider count")
  public void theAdminViewsTheProviderCount() {

  }
  @Then("the admin should see the total count of providers from file {string}")
  public void theAdminShouldSeeTheTotalCountOfProvidersFromFile(String fileprovider) {
  fileprovider="provider.txt";


  }




  @Given("the admin has access to the user_data.txt file")
  public void theAdminHasAccessToTheUserDataTxtFile() {

  }
  @When("the admin views the user count")
  public void theAdminViewsTheUserCount() {

  }
  @Then("the admin should see the total count of users from file {string}")
  public void theAdminShouldSeeTheTotalCountOfUsersFromFile(String string) {

  }



  @When("the admin deletes a provider")
  public void theAdminDeletesAProvider() {

  }
  @Then("the provider {string} should be removed from the file {string}")
  public void theProviderShouldBeRemovedFromTheFile(String filename, String username) throws IOException {
  filename ="provider_data.txt";
  username = "noor";
  adminMyApp.deleteLine(filename,username);
assertFalse(adminMyApp.isUsernameExists(filename,username));

  }




  @When("the admin deletes a user")
  public void theAdminDeletesAUser() {

  }
  @Then("the user {string} should be removed from the file {string}")
  public void theUserShouldBeRemovedFromTheFile(String filename, String username) throws IOException {
    filename ="user_data.txt";
    username = "rema";
    adminMyApp.deleteLine(filename,username);
    assertFalse(adminMyApp.isUsernameExists(filename,username));
  }

  @When("the admin views the count of provider")
  public void theAdminViewsTheCountOfProvider() {

  }
  @Then("the admin should calculate the total profit")
  public void theAdminShouldCalculateTheTotalProfit() {

  }




}
