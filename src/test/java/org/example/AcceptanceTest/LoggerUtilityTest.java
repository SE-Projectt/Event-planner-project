import static org.junit.Assert.*;
import org.junit.*;
import java.util.logging.*;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.example.LoggerUtility;

public class LoggerUtilityTest {
    private Logger logger;
    private ByteArrayOutputStream logOutput;

    @Before
    public void setUp() {
        logger = LoggerUtility.getLogger();
        logOutput = new ByteArrayOutputStream();
        Handler memoryHandler = null;
        try {
            memoryHandler = new MemoryHandler(new StreamHandler(logOutput, new SimpleFormatter()), 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.addHandler(memoryHandler);
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
        LoggerUtility.logInfo(logger, "Test message: %s", "arg1");

        // Flush the memory handler to ensure the log message is written to the ByteArrayOutputStream
        logger.getHandlers()[0].flush();

        // Verify log message
        assertTrue(logOutput.toString().contains("Test message: arg1"));
    }
}
