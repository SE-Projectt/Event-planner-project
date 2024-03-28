package MyApp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AdminMyApp {
    private static final Logger LOGGER = Logger.getLogger(AdminMyApp.class.getName());
    private static final String ERROR_CLOSE_BR = "Error while closing BufferedReader: ";

    public static int Counts(String fileName) throws IOException {
        int lineCount = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lineCount++;
                }
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOGGER.severe(ERROR_CLOSE_BR + e.getMessage());
                }
            }
        }
        return lineCount;
    }

    public static void deleteLine(String fileName, String username) throws IOException {
        File inputFile = new File(fileName);
        File tempFile = new File("temp.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        boolean deleted = false;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (!parts[0].trim().equals(username)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                } else {
                    deleted = true;
                }
            }
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOGGER.severe("Error while closing BufferedWriter: " + e.getMessage());
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.severe(ERROR_CLOSE_BR + e.getMessage());
                }
            }
        }
        if (deleted) {
            if (!inputFile.delete()) {
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
    }

    public static boolean isUsernameExists(String filename, String username) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
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
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.severe(ERROR_CLOSE_BR + e.getMessage());
                }
            }
        }
        return false;
    }
}
