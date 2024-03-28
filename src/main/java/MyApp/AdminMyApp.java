package MyApp;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class AdminMyApp {
    public static int Counts(String fileName) throws IOException {
        int lineCount = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                // Increment line count for each non-empty line
                if (!line.trim().isEmpty()) {
                    lineCount++;
                }
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // Handle the potential IOException from closing the BufferedReader
                    e.printStackTrace();
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
        boolean deleted = false; // Flag to track if the file is deleted

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // Split the current line by comma (assuming username and password are separated by comma)
                String[] parts = currentLine.split(",");
                if (!parts[0].trim().equals(username)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                } else {
                    deleted = true; // Set flag to true if a line is deleted
                }
            }
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Proceed with file deletion and renaming only if the writing and reading operations succeeded
        if (deleted) {
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

            System.out.println("Delete successful");
        } else {
            System.out.println("No lines were deleted");
        }
    }

    public static boolean isUsernameExists(String filename, String username) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to separate username and other parts
                String[] parts = line.split(",");
                // Trim to remove leading/trailing spaces from the username
                String existingUsername = parts[0].trim();
                // Check if the username matches
                if (existingUsername.equals(username)) {
                    // Username exists, return true
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

}
