package org.example.AcceptanceTest;
import MyApp.AdminMyApp;
import MyApp.PayPageMyApp;
import MyApp.UserMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class PackageTest {

    UserMyApp userMyApp;

    public PackageTest() {

        userMyApp = new UserMyApp();
    }
    @Given("the provider wants to add a package named {string} to the file {string}")
    public void theProviderWantsToAddAPackageNamedToTheFile(String string, String string2) {

    }
    @When("the provider adds the package  to the file")
    public void theProviderAddsThePackageToTheFile() {

    }

    @Given("the provider wants to delete a package named {string} from the file {string}")
    public void theProviderWantsToDeleteAPackageNamedFromTheFile(String string, String string2) {

    }
    @When("the provider deletes the package from the file")
    public void theProviderDeletesThePackageFromTheFile() {

    }
    @Given("the user wants to choose a package named {string}")
    public void theUserWantsToChooseAPackageNamed(String string) {

    }
    @When("the user adds the package to the file {string}")
    public void theUserAddsThePackageToTheFile(String string) {

    }
    @Then("the package {string} should be added successfully to the file {string}")//Provider
    public void thePackageShouldBeAddedSuccessfullyToTheFile(String Packagename, String filenaame) {
        Packagename = "ahmadPackage";
        filenaame="Package.txt";
        UserMyApp.addPackageToFile(Packagename,filenaame);
        assertTrue(UserMyApp.checkFile(Packagename,filenaame)) ;

    }
  @Given("the user wants to enter a budget of {string}")
    public void theUserWantsToEnterABudgetOf(String string) {

    }
    @When("the user chooses a suitable package named {string} based on the budget")
    public void theUserChoosesASuitablePackageNamedBasedOnTheBudget(String string) {

    }
    @Then("the package {string} should be added to the file {string}") //user
    public void thePackageShouldBeAddedToTheFile(String Packagename, String filenaame) {

    }
    @Then("the package {string} should be deleted successfully from the file {string}") ///Prvider
    public void thePackageShouldBeDeletedSuccessfullyFromTheFile(String Packagename, String filenaame) throws IOException {
        Packagename = "ahmadPackage";
        filenaame="Package.txt";
        UserMyApp.deleteLineFromFile(Packagename,filenaame);
        assertFalse(UserMyApp.checkFile(Packagename,filenaame));
    }

}