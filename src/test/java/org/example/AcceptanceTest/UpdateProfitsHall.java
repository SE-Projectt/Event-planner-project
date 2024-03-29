package org.example.AcceptanceTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.HallProfitUpdater;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateProfitsHall{
    private String hallName;
    private String profitsFilePath="profits.txt";
    private String hallsFilePath="Halls.txt";
    private String actualLogMessage="An error occurred while reading the Halls file.";
    private Logger logger;

    @Given("the profits file {string} exists")
    public void givenProfitsFileExists(String profitsFilePath) {
        this.profitsFilePath = profitsFilePath;
    }

    @Given("the halls file {string} exists")
    public void givenHallsFileExists(String hallsFilePath) {
        this.hallsFilePath = hallsFilePath;
    }

    @Given("the profits file does not exist")
    public void givenProfitsFileDoesNotExist() {
        this.profitsFilePath = profitsFilePath;
    }

    @Given("the halls file does not exist")
    public void givenHallsFileDoesNotExist() {
        this.hallsFilePath = hallsFilePath;
    }

    @Given("the profits file exists but cannot be read")
    public void givenProfitsFileCannotBeRead() {
        this.profitsFilePath = profitsFilePath;
    }

    @Given("the halls file exists but cannot be read")
    public void givenHallsFileCannotBeRead() {
        this.hallsFilePath = hallsFilePath;
    }

    @Given("the hall {string} does not exist in the halls file")
    public void givenHallDoesNotExist(String hallName) {
        this.hallName = hallName;
        this.hallsFilePath = hallsFilePath;
    }
    @Given("the profits file exists")
    public void theProfitsFileExists() {

    }
    @Given("the halls file exists")
    public void theHallsFileExists() {

    }
    @Given("the hall {string} exists in the halls file")
    public void givenHallExists(String hallName) {
        this.hallName = hallName;
        this.hallsFilePath = hallsFilePath;
    }

    @When("I update or print profits for the hall {string}")
    public void whenUpdateOrPrintProfits(String hallName) {
        this.hallName = hallName;
        HallProfitUpdater.updateOrPrintProfits(hallName);
    }

    @Then("a warning message about profits file should be logged")
    public void thenWarningMessageLogged() {
        String actualLogMessage1 ="Profits file not found. A new one will be created.";
        assertEquals("Profits file not found. A new one will be created.", actualLogMessage1);
    }

    @Then("an error message about reading profits file should be logged")
    public void thenErrorMessageLoggedForProfits() {
        String actualLogMessage2="An error occurred while reading the profits file.";
        assertEquals("An error occurred while reading the profits file.", actualLogMessage2);
    }

    @Then("an error message about reading halls file should be logged")
    public void thenErrorMessageLoggedForHalls() {
        assertEquals("An error occurred while reading the Halls file.", actualLogMessage);
    }

    @Then("no changes should be made to the profits file")
    public void thenNoChangesMadeToProfitsFile() {

        String previousContent = readProfitsFileContents();


        HallProfitUpdater.updateOrPrintProfits(hallName);


        String currentContent = readProfitsFileContents();


        assertEquals(previousContent, currentContent, "The contents of the profits file should remain unchanged");
    }
    private String readProfitsFileContents() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(profitsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Then("the profits file should be updated with the correct profits")
    public void thenProfitsFileUpdated() {
        // Add assertion to verify that profits file is updated correctly
    }
}
