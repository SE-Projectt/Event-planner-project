package myapp;
import java.io.*;
import java.util.logging.*;

public class AdminMyApp {
    private static final Logger logger = Logger.getLogger(AdminMyApp.class.getName());

    public static void deleteLine(String fileName, String username) throws IOException {
        File inputFile = new File(fileName);
        File tempFile = new File("temp.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        boolean deleted = false; // Flag to track if the file is deleted
        while ((currentLine = reader.readLine()) != null) {
            // Split the current line by comma (assuming username and password are separated by comma)
            String[] parts = currentLine.split(",");
            if (!parts[0].trim().equals(username)) {
                writer.write(currentLine + System.getProperty("line.separator"));
            } else {
                deleted = true; // Set flag to true if a line is deleted
            }
        }
        writer.close();
        reader.close();
        // Delete the original file
        if (!inputFile.delete()) {
            logger.log(Level.WARNING, "Could not delete original file");
            return;
        }
        // Rename the temporary file to the original file name
        if (!tempFile.renameTo(inputFile)) {
            logger.log(Level.WARNING, "Could not rename temporary file");
            return;
        }
        // Log if a line was deleted
        if (deleted) {
            logger.info("Delete successful");
        } else {
            logger.info("No lines were deleted");
        }
    }

    public static boolean isUsernameExists(String filename, String username) {
        BufferedReader reader = null;
        boolean usernameExists = true;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to separate username and password
                String[] parts = line.split(",");
                // Trim to remove leading/trailing spaces
                String existingUsername = parts[0].trim();
                // Check if the username matches
                if (existingUsername.equals(username)) {
                    // Username already exists, set flag to false
                    usernameExists = false;
                    break;
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading file", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Error closing BufferedReader", e);
                }
            }
        }
        return usernameExists;
    }
}
