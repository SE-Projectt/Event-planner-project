package MyApp;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class AdminMyApp {
    public static int Counts(String fileName) throws IOException {
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Increment line count for each non-empty line
                if (!line.trim().isEmpty()) {
                    lineCount++;
                }
            }
        }


        return lineCount;
    }

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
            System.out.println("Could not delete original file");
            return;
        }

        // Rename the temporary file to the original file name
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temporary file");
            return;
        }

        // Print "Delete successful" if a line was deleted
        if (deleted) {
            System.out.println("Delete successful");
        } else {
            System.out.println("No lines were deleted");
        }
    }
    public static boolean isUsernameExists(String filename, String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to separate username and password
                String[] parts = line.split(",");
                // Trim to remove leading/trailing spaces
                String existingUsername = parts[0].trim();
                // Check if the username matches
                if (existingUsername.equals(username)) {
                    // Username already exists, return false
                    return false;
                }
            }
        } catch (IOException e) {
          
        }
        // Username not found, return true
        return true;
    }
}
