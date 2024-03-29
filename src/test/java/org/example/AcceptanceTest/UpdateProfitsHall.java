package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.HallProfitUpdater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UpdateProfitsHall {
    private String hallsFilePath;
    private String profitsFilePath;

    @Given("the profits file exists")
    public void profitsFileExists() {
        profitsFilePath = "profits.txt";
    }

    @Given("the halls file exists")
    public void hallsFileExists() {
        hallsFilePath = "Halls.txt";
    }

    @When("I update or print profits for the hall {string}")
    public void updateOrPrintProfits(String hallName) {
        // Call your method to update or print profits
        HallProfitUpdater.updateOrPrintProfits(hallName);
    }

    @Then("the profits file should be updated with the correct profits")
    public void verifyProfitsUpdated() throws IOException {
        String firstLine = null;
        String file="profits.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            firstLine = br.readLine(); // Read the first line
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Write your assertion to verify if the profits file is updated correctly
        assertEquals("Hiba,18000", firstLine, "Profits file should be updated correctly");
    }
}
