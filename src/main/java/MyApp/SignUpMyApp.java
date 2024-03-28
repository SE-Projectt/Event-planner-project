import java.io.*;
import java.util.ArrayList;

public class SignUpMyApp {
    int flag = 0;
    static String userFile = "user_data.txt";

    public boolean iiEnterValidUsernamePassword(String username, String password) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(userFile, true))) {
            // Append the new user's data to the file
            writer.println(username + "," + password);
            System.out.println("You have signed up successfully!");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your needs
            return false; // Return false indicating signup failure
        }

        return true; // Return true indicating signup success
    }

    public static boolean theSystemHasAnExistingUserWithUsername(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(username)) {
                    return true; // User with the given username found
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your needs
        }

        return false; // No user with the given username found
    }

    public Integer noNewUserAccountShouldBeCreated(ArrayList<User> A) {
        UserDataBase DB = new UserDataBase(A);
        DB.readUsersFromFile(userFile);

        return null; // return some meaningful value
    }

    public static boolean thereIsNoDuplicatedUserOnTheFile(String usernameToCheck, String passwordToCheck) {
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(usernameToCheck) && parts[1].equals(passwordToCheck)) {
                    return false; // Duplicated username and password found
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your needs
        }

        return true; // No duplicate username found
    }
}
