package MyApp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddProviderMyApp {

    public boolean iiEnterValidUsernamePassword(String username, String password){

        try (PrintWriter writer = new PrintWriter(new FileWriter("provider_data.txt", true))) {
            // Append the new user's data to the file
            writer.println(username + "," + password);
            System.out.println("You have signed up successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }          return  true;}

}