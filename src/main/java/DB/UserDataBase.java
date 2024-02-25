package DB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Entity.User;



public class UserDataBase {

    private ArrayList <User> UserData;
    public UserDataBase() {
        UserData = new ArrayList<User>();
    }

    public UserDataBase(ArrayList<User> userData) {
        UserData = readUsersFromFile("user_data.txt");
    }

    public static ArrayList<User> readUsersFromFile(String fileName) {
        ArrayList<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    userList.add(new User(username, password));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user data file: " + e.getMessage());
        }
        return userList;
    }


}
