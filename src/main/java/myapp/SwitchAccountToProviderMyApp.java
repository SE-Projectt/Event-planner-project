package myapp;
import java.io.*;

public class SwitchAccountToProviderMyApp {

    public static boolean thisUsernamePasswordHaveAccessToBeProvider(String username, String password) {
        boolean found = false;
        String filename = "provider_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        found = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
           
        }

        return found;
    }




}