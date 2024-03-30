package myapp;
import org.example.Main;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public final class AdminMyApp {
    private static final Logger LOGGER = LoggerUtility.getLogger() ;

    public static void deleteLine(String fileName, String username) throws IOException {
        File inputFile = new File(fileName);
        File tempFile = File.createTempFile("temp", null, new File(System.getProperty("java.io.tmpdir")));

        // Set the temporary file permissions to restrict access
        tempFile.setReadable(true, true);
        tempFile.setWritable(true, true);
        tempFile.setExecutable(false, true);

        boolean deleted = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].trim().equals(username)) {
                    writer.write(currentLine);
                    writer.newLine();
                } else {
                    deleted = true;
                }
            }
        } catch (IOException e) {
            Main.handleIOException("Error occurred while deleting line: ", e);
        }

        if (deleted) {
            try {
                Files.delete(inputFile.toPath());
                Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.ATOMIC_MOVE);
                LOGGER.info("Delete successful");
            } catch (IOException e) {
                Main.handleIOException("Error occurred while deleting or renaming files: ", e);
            }
        } else {
            LOGGER.info("No lines were deleted");
        }

        // Cleanup: Ensure temporary file is deleted
        if (!tempFile.delete()) {
            LOGGER.warning("Temporary file could not be deleted");
        }
    }

    public static boolean isUsernameExists(String filename, String username) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String existingUsername = parts[0].trim();
                if (existingUsername.equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
           Main.handleIOException("Error occurred while checking if username exists: ", e);
        }
        return false;
    }

  
}
