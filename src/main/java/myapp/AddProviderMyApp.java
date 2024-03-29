package myapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;


public class AddProviderMyApp {

    private static final Logger LOGGER = Logger.getLogger(AddProviderMyApp.class.getName());

    public boolean iiEnterValidUsernamePassword(String username, String password){

        try (PrintWriter writer = new PrintWriter(new FileWriter("provider_data.txt", true))) {
            // Append the new user's data to the file
            writer.println(username + "," + password);
            LOGGER.info("You have signed up successfully!");
        } catch (IOException e) {
            LOGGER.severe("Error writing to file: " + e.getMessage());
            return false;
        }
        return true;
    }
}
