User

package org.example.AcceptanceTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoggerUtility;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
public class LoggerUtilityTest {

    private Logger logger;
    private String logMessage;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Given("I have a logger")
    public void iHaveALogger() {
        logger = LoggerUtility.getLogger();
        System.setOut(new PrintStream(outContent));
    }
    @When("I log an info message with format {string}")
    public void iLogAnInfoMessageWithFormat(String format) {
        LoggerUtility.logInfo(logger, format, "Test");
        logMessage = outContent.toString().trim();
    }
    @Then("The log message should be {string}")
    public void theLogMessageShouldBe(String expectedMessage) {
        assertEquals("", logMessage);
 }
}

