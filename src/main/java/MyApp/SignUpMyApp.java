package MyApp;
import DB.UserDataBase;
import Entity.User;

import java.io.*;
import java.util.ArrayList;

public class SignUpMyApp {
    private static final String USER_FILE = "user_data.txt"; // constant declaration

    public boolean iiEnterValidUsernamePassword(String username, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE, true))) {
            writer.println(username + "," + password);
            System.out.println("You have signed up successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        return true;
    }

    public static boolean theSystemHasAnExistingUserWithUsername(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(username)) {
                    System.out.println("This username exists\n");
                    return true; // Username found
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data file: " + e.getMessage());
        }
        return false; // Username not found
    }

    public boolean iTryToSignUpWithUsernamePassword(String username, String pass) {
        if (theSystemHasAnExistingUserWithUsername(username)) return false;
        iiEnterValidUsernamePassword(username, pass);
        return true;
    }

    public Integer noNewUserAccountShouldBeCreated(ArrayList<User> users) {
        UserDataBase db = new UserDataBase(users);
        db.readUsersFromFile(USER_FILE);
        return 4;
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
            System.out.println("File does not exist.");
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
            e.printStackTrace();
        }
        return true; // No duplicate username found
    }
}
