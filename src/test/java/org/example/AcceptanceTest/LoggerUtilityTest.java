import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.logging.*;

public class LoggerUtilityStepDefinitions {
    private Logger logger;
    private String logMessage;
    private boolean logMessageCaptured;

    @Given("the logger is initialized")
    public void initializeLogger() {
        logger = Logger.getLogger(LoggerUtility.class.getName());
    }

    @When("a message {string} is logged at INFO level")
    public void logMessage(String message) {
        LoggerUtility.logInfo(logger, message);
        logMessage = message;
    }

    @Then("the log message {string} should be captured")
    public void verifyLogMessage(String expectedMessage) {
        logMessageCaptured = false;
        for (Handler handler : logger.getHandlers()) {
            if (handler instanceof MemoryHandler) {
                MemoryHandler memoryHandler = (MemoryHandler) handler;
                String loggedMessage = new String(memoryHandler.getPushedRecords().get(0).getMessage());
                if (loggedMessage.contains(expectedMessage)) {
                    logMessageCaptured = true;
                    break;
                }
            }
        }
        assertTrue("Log message not captured: " + logMessage, logMessageCaptured);
    }

    @When("the logger setup is verified")
    public void verifyLoggerSetup() {
        assertFalse(logger.getUseParentHandlers());
        Handler[] handlers = logger.getHandlers();
        boolean consoleHandlerFound = false;
        for (Handler handler : handlers) {
            if (handler instanceof ConsoleHandler) {
                consoleHandlerFound = true;
                assertEquals(handler.getFormatter().getClass(), SimpleFormatter.class);
            }
        }
        assertTrue(consoleHandlerFound);
    }
}
