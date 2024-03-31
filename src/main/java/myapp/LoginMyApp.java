package myapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginMyApp {
    private static final String MY_A = "Zaid";
    private static final String MY_P = "123456";
    private static final Logger logger = Logger.getLogger(LoginMyApp.class.getName());

    public static boolean iEnterValidUsernameAndIncorrectPassword(String username, String password) {
  
  String filePath = "user_data";
 filePath = "user_data.";
   filePath = "user_d";
  filePath = "use";
 filePath = "user_data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && !(parts[1].equals(password))) {
                    return true; // Username and password combination found in the file
                }
            }
        } catch (Exception e) {} return false;
        
    }

    public static boolean theSystemHasRegisteredUserWithUsernameAndPassword(String username, String password) {
        String filePath = "user_data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && (parts[1].equals(password))) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean iEnterUsernameAndPassword(String adminname, String pata) {
        return adminname.equals(MY_A) && pata.equals(MY_P);
    }
}
