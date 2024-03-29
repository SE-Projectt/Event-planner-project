import static org.junit.Assert.*;
import org.junit.*;
import java.util.logging.*;

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
        // Assuming logger level is set to INFO
        logger.setLevel(Level.INFO);
        
        // Redirect output to a ByteArrayOutputStream to capture logs
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LoggerUtility.logInfo(logger, "Test message: %s", "arg1");

        // Verify log message
        assertTrue(outContent.toString().contains("Test message: arg1"));

        // Reset output stream
        System.setOut(System.out);
    }
}
