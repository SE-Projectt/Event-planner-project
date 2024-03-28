package MyApp;
import DB.UserDataBase;
import Entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static DB.UserDataBase.readUsersFromFile;


public class SignUpMyApp {
    int flag=0 ;
    public boolean iiEnterValidUsernamePassword(String username, String password){

        try (PrintWriter writer = new PrintWriter(new FileWriter("user_data.txt", true))) {
            // Append the new user's data to the file
            writer.println(username + "," + password);
            System.out.println("You have signed up successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }          return  true;}


    public static boolean  theSystemHasAnExistingUserWithUsername(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(username)) {

                    System.out.println("This User name is exiest  \n");
                    return true; // Username found
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data file: " + e.getMessage());
        }
        return false; // Username not found or file reading failed
    }
    public boolean iTryToSignUpWithUsernamePassword (String username , String pass)
    {
        if  (theSystemHasAnExistingUserWithUsername (username)) return false ;
        else {
            iiEnterValidUsernamePassword(username, pass);
            return true;
        }}

    public Integer noNewUserAccountShouldBeCreated(ArrayList<User> A) {

        UserDataBase DB=new UserDataBase(A);
        DB.readUsersFromFile("user_data.txt");




        return 4;}


    public boolean iLeaveTheUsernameFieldEmpty(String username) {
        if(username.isEmpty())  return true;
        return false;
    }

    public boolean iLeaveThePasswordFieldEmpty(String PASS) {
        if(PASS.isEmpty())  return true;
        return false;
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
                // Assuming each line contains a username and password separated by a comma
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(username) && parts[1].trim().equals(password)) {
                    return true; // Username and password found in the file
                }
            }
        }
        // Username and password not found in the file
        return false;
    }
    public static boolean thereIsNoDuplicatedUserOnTheFile(String usernameToCheck, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split the line into username and password
                String[] parts = line.split(",");

                // Check if the username matches the one to check
                if (parts.length >= 1 && parts[0].equals(usernameToCheck)) {
                    return false; // Duplicate username found
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception based on your needs
        }

        return true; // No duplicate username found
    }

}
