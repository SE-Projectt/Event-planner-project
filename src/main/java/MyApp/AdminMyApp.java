package MyApp;

import java.io.*;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdminMyApp {
    private static final Logger LOGGER = Logger.getLogger(AdminMyApp.class.getName());

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
                try {
                    Path inputPath = Paths.get(inputFile.getPath());
                    Files.delete(inputPath);
                    if (!tempFile.renameTo(inputFile)) {
                        LOGGER.severe("Could not rename temporary file");
                        return;
                    }
                    LOGGER.info("Delete successful");
                } catch (IOException e) {
                    LOGGER.severe("Error while deleting or renaming files: " + e.getMessage());
                    throw e;
                }
            } else {
                LOGGER.info("No lines were deleted");
            }
        } finally {
            if (tempFile.exists()) {
                try {
                    Path tempPath = Paths.get(tempFile.getPath());
                    Files.delete(tempPath);
                } catch (IOException e) {
                    LOGGER.severe("Could not delete temporary file: " + e.getMessage());
                }
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
