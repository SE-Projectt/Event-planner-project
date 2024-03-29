package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

public class LoggerUtilityTest {
    private Logger logger;
    private String logMessage;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

@Given("I have a logger")
public void iHaveALogger() {
    // Write code here that turns the phrase above into concrete actions

}
@When("I log an info message with format {string}")
public void iLogAnInfoMessageWithFormat(String string) {
    // Write code here that turns the phrase above into concrete actions
   
}
@Then("The log message should be {string}")
public void theLogMessageShouldBe(String string) {
    // Write code here that turns the phrase above into concrete actions
 
}
}
