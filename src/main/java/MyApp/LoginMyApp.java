package MyApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class LoginMyApp {
    static Admin admin = new Admin();

    private static final Logger logger = Logger.getLogger(LoginMyApp.class.getName());

    public static boolean iEnterValidUsernameAndIncorrectPassword(String username, String password) {
        String filePath = "user_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && !(parts[1].equals(password))) {
                    return true; // Username and password combination found in the file
                }
            }
        } catch (IOException e) {
            // Log the error
            logger.log(Level.SEVERE, "An IOException occurred while reading user data", e);
        }

        return false;
    }

    public boolean theSystemHasRegisteredUserWithUsernameAndPassword(String username, String password) {
        String filePath = "user_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && (parts[1].equals(password))) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Log the error
            logger.log(Level.SEVERE, "An IOException occurred while reading user data", e);
        }

        return false;
    }

    public static boolean iEnterUsernameAndPassword(String adminname, String password) {
        return adminname.equals(admin.getmyA()) && password.equals(admin.getmyPP());
    }
}
