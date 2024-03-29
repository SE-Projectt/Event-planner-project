package MyApp;

import java.io.*;
import java.util.logging.Logger;

public class AdminMyApp {
    private static final Logger LOGGER = Logger.getLogger(AdminMyApp.class.getName());

    // Private constructor to hide the implicit public one
    private AdminMyApp() {
        throw new IllegalStateException("Utility class");
    }

    public static void deleteLine(String fileName, String username) throws IOException {
        File inputFile = new File(fileName);
        File tempFile = new File("temp.txt");
        boolean deleted = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].trim().equals(username)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                } else {
                    deleted = true;
                }
            }
        } catch (IOException e) {
            LOGGER.severe("Error while reading or writing files: " + e.getMessage());
            throw e;
        }

        // Close the BufferedWriter outside the try-with-resources block
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
            if (deleted) {
                if (!java.nio.file.Files.delete(inputFile.toPath())) {
                    LOGGER.severe("Could not delete original file");
                    return;
                }
                if (!tempFile.renameTo(inputFile)) {
                    LOGGER.severe("Could not rename temporary file");
                    return;
                }
                LOGGER.info("Delete successful");
            } else {
                LOGGER.info("No lines were deleted");
            }
        } finally {
            if (tempFile.exists() && !java.nio.file.Files.delete(tempFile.toPath())) {
                LOGGER.severe("Could not delete temporary file");
            }
        }
    }

    public static boolean isUsernameExists(String filename, String username) {
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
            LOGGER.severe("Error while reading file: " + e.getMessage());
        }
        return false;
    }
}
