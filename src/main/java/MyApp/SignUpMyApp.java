package MyApp;




import java.io.*;

import java.util.logging.Logger;

public class SignUpMyApp {
    private static final String USER_FILE = "user_data.txt"; // constant declaration
    private static final Logger logger = Logger.getLogger(SignUpMyApp.class.getName());

    public boolean iiEnterValidUsernamePassword(String username, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE, true))) {
            writer.println(username + "," + password);
            logger.info("You have signed up successfully!");
        } catch (IOException e) {
            logger.severe("Error writing to file: " + e.getMessage());
        }
        return true;
    }

    public static boolean theSystemHasAnExistingUserWithUsername(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(username)) {
                    logger.info("This username exists\n");
                    return true; // Username found
                }
            }
        } catch (IOException e) {
            logger.severe("Error reading user data file: " + e.getMessage());
        }
        return false; // Username not found
    }

    public boolean iTryToSignUpWithUsernamePassword(String username, String pass) {
        if (theSystemHasAnExistingUserWithUsername(username)) return false;
        iiEnterValidUsernamePassword(username, pass);
        return true;
    }

 

    public boolean iLeaveTheUsernameFieldEmpty(String username) {
        return username.isEmpty();
    }

    public boolean iLeaveThePasswordFieldEmpty(String password) {
        return password.isEmpty();
    }

    public boolean theUsernamePasswordShouldBeSavedToTheFile(String fileName, String username, String password) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            logger.warning("File does not exist.");
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(username) && parts[1].trim().equals(password)) {
                    return true; // Username and password found
                }
            }
        }
        return false;
    }

    public static boolean thereIsNoDuplicatedUserOnTheFile(String usernameToCheck, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(usernameToCheck)) {
                    return false; // Duplicate username found
                }
            }
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
        return true; // No duplicate username found
    }
}
