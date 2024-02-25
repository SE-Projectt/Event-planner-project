package org.example;
import Entity.User;
import MyApp.SignUpMyApp;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Scanner;
import static DB.UserDataBase.readUsersFromFile;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        SignUpMyApp myApp=new SignUpMyApp();
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        int flag=0;
while (true){

    ArrayList<User> userList = readUsersFromFile("user_data.txt");
    for (User user : userList) {
        System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
    }

        System.out.print("Enter your username: ");
         username = scanner.nextLine();
        if (myApp.iLeaveTheUsernameFieldEmpty(username)) {
            System.out.print("Username field is required    \n");
            continue;
        }
while (true) {
    System.out.print("Enter your password: ");
    password = scanner.nextLine();
    if (myApp.iLeaveThePasswordFieldEmpty(password)) {
        System.out.print("Password field is required    \n");
continue;
    }

break;}

      if(SignUpMyApp.checkCredentials(username)){
          continue;
      }
        myApp.iiEnterValidUsernamePassword(username,password);
        break;
    }}
}