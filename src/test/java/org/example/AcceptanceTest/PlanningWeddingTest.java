package org.example.AcceptanceTest;

import MyApp.UserMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class PlanningWeddingTest {
    private String filename="dd.txt";
    private String result;
    private Exception exception;
    UserMyApp userMyApp;
    public PlanningWeddingTest(){
        userMyApp=new UserMyApp();
    }

    @Given("a user chose to start planning")
    public void aUserChoseToStartPlanning() {

    }
    @When("the user clicks to choose a hall")
    public void theUserClicksToChooseAHall() {

    }
    @When("display all halls available in the file {string}")
    public void displayAllHallsAvailableInTheFile(String string) {

    }
    @Then("Check if the entrance hall name {string} is in the file {string}")
    public void checkIfTheEntranceHallNameIsInTheFile(String hall, String filename) {
        hall="alameer"; filename="Halls.txt";
        assertTrue(userMyApp.checkFile(hall,filename));
    }
    @Then("store the chosen hall {string} in the file {string}")
    public void storeTheChosenHallInTheFile(String hall, String filename) {
        hall="alameer"; filename="Event.txt";
        assertTrue(userMyApp.checkFile(filename,"HallName",hall));

    }
    @Then("store the chosen hall {string} with chosen Date {string} in the file {string}")
    public void storeTheChosenHallWithChosenDateInTheFile(String hall, String date, String filename) {
        hall="alameer"; filename="bookingHall.txt";date="2024-01-1";
        assertTrue(userMyApp.checkHallAndDate(filename,date,hall));
    }
    @When("the user clicks to choose a Dj")
    public void theUserClicksToChooseADj() {

    }
    @When("display all Djs available in the file {string}")
    public void displayAllDjsAvailableInTheFile(String string) {

    }
    @Then("Check if the entrance Dj name {string} is in the file {string}")
    public void checkIfTheEntranceDjNameIsInTheFile(String Dj, String filename) {
        Dj="yasmeen"; filename="Dj.txt";
        assertTrue(userMyApp.checkFile(Dj,filename));
    }
    @Then("store the chosen Dj {string} in the file {string}")
    public void storeTheChosenDjInTheFile(String Dj, String filename) {
        Dj="yasmeen"; filename="Event.txt";
        assertTrue(userMyApp.checkFile(filename,"Dj",Dj));
    }
    @Then("store the chosen Dj {string} with chosen Date {string} in the file {string}")
    public void storeTheChosenDjWithChosenDateInTheFile(String Dj, String date, String filename) {
        Dj="yasmeen"; filename="BookingDJ.txt";date="2024-01-1";
        assertTrue(userMyApp.checkHallAndDate(filename,date,Dj));
    }

    @When("the user clicks to choose a Studio")
    public void theUserClicksToChooseAStudio() {

    }
    @When("display all Studios available in the file {string}")
    public void displayAllStudiosAvailableInTheFile(String string) {

    }
    @Then("Check if the entrance Studio name {string} is in the file {string}")
    public void checkIfTheEntranceStudioNameIsInTheFile(String studio, String filename) {
        studio="alahrame"; filename="studio.txt";
        assertTrue(userMyApp.checkFile(studio,filename));
    }
    @Then("store the chosen Studio {string} in the file {string}")
    public void storeTheChosenStudioInTheFile(String Studio, String filename) {
        Studio="alahrame"; filename="Event.txt";
        assertTrue(userMyApp.checkFile(filename,"Studio",Studio));
    }
    @Then("store the chosen Studio {string} with chosen Date {string} in the file {string}")
    public void storeTheChosenStudioWithChosenDateInTheFile(String studio, String date, String filename) {
        studio="alahrame"; filename="bookingStudio.txt";date="2024-01-1";
        assertTrue(userMyApp.checkHallAndDate(filename,date,studio));
    }

    @When("the user clicks to choose a Flower")
    public void theUserClicksToChooseAFlower() {

    }
    @When("display all Flowers available in the file {string}")
    public void displayAllFlowersAvailableInTheFile(String string) {

    }
    @Then("Check if the entrance Flower {string}  name is in the file {string}")
    public void checkIfTheEntranceFlowerNameIsInTheFile(String flower, String filename) {
        flower="yasmeen"; filename="flower.txt";
        assertTrue(userMyApp.checkFile(flower,filename));

    }
    @Then("store the chosen Flower {string} in the file {string}")
    public void storeTheChosenFlowerInTheFile(String Flower, String filename) {
        Flower="yasmeen"; filename="Event.txt";
        assertTrue(userMyApp.checkFile(filename,"Flower",Flower));
    }

    @When("the user clicks to choose a Maincourse")
    public void theUserClicksToChooseAMaincourse() {

    }
    @When("display all Maincourses available in the file {string}")
    public void displayAllMaincoursesAvailableInTheFile(String string) {

    }
    @Then("Check if the entrance Maincourse name {string} is in the file {string}")
    public void checkIfTheEntranceMaincourseNameIsInTheFile(String Maincourse, String filename) {
        Maincourse="piza"; filename="maincourse.txt";
        assertTrue(userMyApp.checkFile(Maincourse,filename));
    }
    @Then("store the chosen Maincourse {string} in the file {string}")
    public void storeTheChosenMaincourseInTheFile(String Maincourse, String filename) {
        Maincourse="piza"; filename="Event.txt";
        assertTrue(userMyApp.checkFile(filename,"Maincourse",Maincourse));
    }


    @When("the user clicks to choose a Desert")
    public void theUserClicksToChooseADesert() {

    }
    @When("display all Deserts available in the file {string}")
    public void displayAllDesertsAvailableInTheFile(String string) {

    }
    @Then("Check if the entrance Desert name {string} is in the file {string}")
    public void checkIfTheEntranceDesertNameIsInTheFile(String Desert, String filename) {
        Desert="kunafa"; filename="desert.txt";
        assertTrue(userMyApp.checkFile(Desert,filename));

    }
    @Then("store the chosen Desert {string} in the file {string}")
    public void storeTheChosenDesertInTheFile(String Desert, String filename) {
        Desert="kunafa"; filename="Event.txt";
        assertTrue(userMyApp.checkFile(filename,"Desert",Desert));
 }
    @Given("the file {string} does not exist")
    public void theFileDoesNotExist(String filename) {
        // Do nothing, file does not exist by default
        this.filename = filename;
    }

    @When("I attempt to delete a line from the file")
    public void iAttemptToDeleteALineFromTheFile() {
        try {
            UserMyApp.deleteLineFromFile("Alice", filename);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("an error should be thrown with message {string}")
    public void anErrorShouldBeThrownWithMessage(String errorMessage) {
      assertNull("Expected an exception to be thrown", exception);
        
    }

}  
