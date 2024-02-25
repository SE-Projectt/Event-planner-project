package MyApp;
import DB.UserDataBase;
import Entity.User;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

import static DB.UserDataBase.readUsersFromFile;


public class SignUpMyApp {

   public boolean iiEnterValidUsernamePassword(String username, String password){      try (PrintWriter writer = new PrintWriter(new FileWriter("user_data.txt", true))) {
       // Append the new user's data to the file
       writer.println(username + "," + password);
       System.out.println("You have signed up successfully!");
   } catch (IOException e) {
       System.err.println("Error writing to file: " + e.getMessage());
   }          return  true;}


        public static boolean checkCredentials(String username) {
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




}
