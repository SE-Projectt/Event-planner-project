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
               
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && !(parts[1].equals(password))) {
                    return true; // Username and password combination found in the file
                }
            }
        } catch (IOException e) {
            
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
           
        }

        return false;
    }
    public static boolean iEnterUsernameAndPassword(String adminname, String password)
    {
        if (adminname.equals(admin.getmy_a()) && password.equals(admin.getmy_pp()))
            return true ;
        else return false ;
    }

}
