package MyApp;

import Entity.Admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginMyApp {
    static Admin admin = new Admin() ;
    public static boolean iEnterValidUsernameAndIncorrectPassword(String username, String password) {
        String filePath = "user_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line in the file represents a user with the format "username,password"
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && !(parts[1].equals(password))) {
                    return true; // Username and password combination found in the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Username and password combination not found in the file
    }


    public boolean theSystemHasRegisteredUserWithUsernameAndPassword(String username, String password) {
        String filePath = "user_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line in the file represents a user with the format "username,password"
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && (parts[1].equals(password))) {
                    return true; // Username and password combination found in the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    public static boolean iEnterUsernameAndPassword(String adminname, String password)
    {
        if (adminname.equals(admin.getA()) && password.equals(admin.getP()))
            return true ;
        else return false ;
    }

}
