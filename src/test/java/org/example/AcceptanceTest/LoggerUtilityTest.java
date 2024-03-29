import static org.junit.Assert.*;
import org.junit.*;
import java.util.logging.*;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;
import org.example.LoggerUtility;

public class LoggerUtilityTest {
    private Logger logger;

    @Before
    public void setUp() {
        logger = LoggerUtility.getLogger();
    }

    @Test
    public void testGetLogger() {
        assertNotNull(logger);
        assertEquals(LoggerUtility.getLogger(), logger);
        assertEquals(logger.getName(), LoggerUtility.class.getName());
    }

    @Test
    public void testSetupLogger() {
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

    @Test
    public void testLogInfo() {
        // Redirect logger output to a ByteArrayOutputStream to capture logs
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers) {
            if (handler instanceof ConsoleHandler) {
                handler.setOutputStream(new PrintStream(outContent));
            }
        }

        // Assuming logger level is set to INFO
        logger.setLevel(Level.INFO);
        LoggerUtility.logInfo(logger, "Test message: %s", "arg1");

        // Verify log message
        assertTrue(outContent.toString().contains("Test message: arg1"));

        // Reset logger output stream
        for (Handler handler : handlers) {
            if (handler instanceof ConsoleHandler) {
                handler.setOutputStream(System.out);
            }
        }
    }
}
