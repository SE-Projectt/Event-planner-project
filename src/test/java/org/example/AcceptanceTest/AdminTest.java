package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminTest {
    @Given("Admin is logged in to the admin page")
    public void adminIsLoggedInToTheAdminPage() {
        System.out.println("Welcom");

    }
    @When("Admin can see the list of users requesting to be providers")
    public void adminCanSeeTheListOfUsersRequestingToBeProviders() {

    }

    @Then("Admin views user information requesting to be a provider")
    public void adminViewsUserInformationRequestingToBeAProvider() {

    }
  /////
    @When("Admin accepts a user request to be a provider")
    public void adminAcceptsAUserRequestToBeAProvider() {

    }
    @Then("The user becomes a provider and is notified")
    public void theUserBecomesAProviderAndIsNotified() {

    }

    @When("Admin rejects a user request to be a provider")
    public void adminRejectsAUserRequestToBeAProvider() {

    }
    @Then("The user's request is rejected and the user is notified")
    public void theUserSRequestIsRejectedAndTheUserIsNotified() {

    }


    @When("Admin searches for provider information by providername {string} from file {string}")
    public void adminSearchesForProviderInformationByProvidernameFromFile(String string, String string2) {

    }
    @Then("The provider's information is displayed")
    public void theProviderSInformationIsDisplayed() {

    }


    @Given("Admin views the provider list")
    public void adminViewsTheProviderList() {

    }
    @When("Admin deletes a provider from the provider file")
    public void adminDeletesAProviderFromTheProviderFile() {

    }
    @Then("The provider is removed from the provider file")
    public void theProviderIsRemovedFromTheProviderFile() {

    }



    @When("Admin views his profit from providers subscriptions")
    public void adminViewsHisProfitFromProvidersSubscriptions() {

    }
    @Then("The total profit from providers' subscriptions is displayed")
    public void theTotalProfitFromProvidersSubscriptionsIsDisplayed() {

    }



    @When("Admin searches for user information by username {string} from file {string}")
    public void adminSearchesForUserInformationByUsernameFromFile(String string, String string2) {

    }
    @Then("The user's information is displayed")
    public void theUserSInformationIsDisplayed() {

    }


    @When("Admin views user information and users count")
    public void adminViewsUserInformationAndUsersCount() {

    }
    @Then("User information \\(username, password) and the number of users are displayed")
    public void userInformationUsernamePasswordAndTheNumberOfUsersAreDisplayed() {

    }


    @Given("Admin views user information and user count")
    public void adminViewsUserInformationAndUserCount() {

    }
    @When("Admin deletes a user from the user file")
    public void adminDeletesAUserFromTheUserFile() {

    }
    @Then("The user is removed from the user file")
    public void theUserIsRemovedFromTheUserFile() {

    }



}
