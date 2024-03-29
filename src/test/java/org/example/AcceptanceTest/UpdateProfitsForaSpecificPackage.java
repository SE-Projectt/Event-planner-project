package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.HallProfitUpdaterPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;

public class UpdateProfitsForaSpecificPackage  {
    private String packageFilePath;
    private String profitsPackageFilePath;

    @Given("the profits package file exists")
    public void profitsPackageFileExists() {
        profitsPackageFilePath = "profitsPackage.txt";
    }

    @Given("the package file exists")
    public void packageFileExists() {
        packageFilePath = "Package.txt";
    }

    @When("I update or print profits for the package {string}")
    public void updateOrPrintProfitsPackage(String packageName) {
        HallProfitUpdaterPackage.updateOrPrintProfitsPackage(packageName);
    }

    @Then("the profits package file should be updated with the correct profits")
    public void verifyProfitsPackageUpdated() throws IOException {
        String firstLine = null;
        String file="profitsPackage.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            firstLine = br.readLine(); // Read the first line
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write your assertions to verify if the profits package file is updated correctly

        assertEquals("Hiba,22712", firstLine, "Profits file should be updated correctly");
 }
}
