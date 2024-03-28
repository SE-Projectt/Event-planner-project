package DB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entity.User;

public class UserDataBase {

    private static final Logger logger = Logger.getLogger(UserDataBase.class.getName());
    private ArrayList<User> UserData;

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
                    logger.log(Level.WARNING, "Invalid line format: {0}", line);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading user data file: {0}", e.getMessage());
        }
        return userList;
    }
}
