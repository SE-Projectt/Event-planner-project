package org.example;
import Entity.PayInformation;
import MyApp.*;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        SignUpMyApp myApp = new SignUpMyApp();
        SwitchAccountToProviderMyApp switchAccountToProviderMyApp=new SwitchAccountToProviderMyApp() ;
        PayPageMyApp payPageMyApp=new PayPageMyApp();
        PayInformation payInformation =new PayInformation();
        LoginMyApp loginMyApp = new LoginMyApp();
        SignUpMyApp signup=new SignUpMyApp();
        AdminMyApp adminMyApp=new AdminMyApp();
        Scanner scanner = new Scanner(System.in);
        UserMyApp  userMyApp=new UserMyApp() ;
        String username, password, option1, useroption,Paypage, HallName,HallCapacity,HallPrice,HallLocation,ProvidernametoDeleteit,UsernameToDeleteit ;
        String UserFile = "user_data.txt",ProviderFile = "provider_data.txt";
        String hallName = null,djName= null,StudioName= null,FlowerName=null,Maincourse=null,Desert=null;
       String HallPath="Halls.txt",DjFile="Dj.txt",DesertFile="desert.txt",maincourseFile="maincourse.txt",FlowerFile="flower.txt",StudioFile="studio.txt";

        int UserProfit=0;
        String PackgName ;
        String Pname ;
        boolean b =false;
        int s=0 ;String Enternumber;
        boolean flag=false;
        String HallnameP,HPriceP,CapacityP,HLocationP,DjnameP,DjPriceP,FlowernameP,FlowerPriceP,DessertnameP,studionameP,StudioPriceP,MainCnameP,MaincPriceP,DessertP;
        outerWhile1:
        while (true) {
            System.out.println("Choose: \n 1. Sign up \n 2. Login \n ");
            option1 = scanner.nextLine();

            if (option1.equals("1")) {
                while (true) {
                    System.out.print("Enter your username:\n");
                    username = scanner.nextLine();

                    if (myApp.iLeaveTheUsernameFieldEmpty(username)) {
                        System.out.print("UserName field is required    \n");
                        continue;
                    }

                    while (true) {
                        System.out.print("Enter your password:\n");
                        password = scanner.nextLine();

                        if (myApp.iLeaveThePasswordFieldEmpty(password)) {
                            System.out.print("Password field is required    \n");
                            continue;
                        }
                        else
                            break;
                    }

                    if (myApp.theSystemHasAnExistingUserWithUsername(username)) {
                        continue;
                    }

                    if (myApp.iLeaveTheUsernameFieldEmpty(username)) {
                        continue;
                    }

                    if (myApp.iiEnterValidUsernamePassword(username, password)) {
                        break;
                    }
                }
                System.out.println("Do you want to login? Enter 2 to login, or any other key to go back to the main menu");
                option1 = scanner.nextLine();
            }

            if (option1.equals("2")) {
                System.out.println("***************************************************************");
                System.out.println("Welcome to Fiesta App, please enter your username and password.");
                System.out.println("***************************************************************");
                while (true) {
                    System.out.println("Enter your username:");
                    username = scanner.nextLine();

                    if (myApp.iLeaveTheUsernameFieldEmpty(username)) {
                        System.out.print("UserName field is required \n");
                        continue;
                    }

                    while (true) {
                        System.out.print("Enter your password:\n ");
                        password = scanner.nextLine();

                        if (myApp.iLeaveThePasswordFieldEmpty(password)) {
                            System.out.print("Password field is required    \n");
                            continue;
                        } else break;
                    }

                    if (LoginMyApp.iEnterUsernameAndPassword(username, password)) {
                        System.out.println("Login successfully As Admin , Welcome Zaid :)");
                        while (true)
                        {
                        System.out.println("Choose: \n 1. View a provider count  \n 2. View a user count \n 3. Delete provider \n 4. Delete User \n 5. view a profit \n 6. Logout");
                        int choice = scanner.nextInt();
                            breakSwitchAdmin:
                        switch (choice) {
                            case 1:
                                System.out.println("The Provider Count =  " + adminMyApp.Counts(ProviderFile));
                                break;
                            case 2:
                                System.out.println("The User Count =  " + adminMyApp.Counts(UserFile));
                                break;
                            case 3:
                                Scanner Sc = new Scanner(System.in);

                         while (true)
                         {
                                System.out.println("Enter the name of the provider your want to delete : ");
                                ProvidernametoDeleteit = Sc.nextLine();
                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(ProvidernametoDeleteit)) {
                                    System.out.print("Provider name field is required ! \n");
                                    continue;
                                }
                                else {
                                    AdminMyApp.deleteLine(ProviderFile, ProvidernametoDeleteit) ;
                                    break  breakSwitchAdmin;
                                }
                        }



                            case 4:
                                Scanner Sc1 =new Scanner(System.in);
                                while (true)
                                {
                                    System.out.println("Enter the name of the User your want to delete :");
                                    UsernameToDeleteit= Sc1.nextLine();
                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(UsernameToDeleteit)) {
                                        System.out.print("User name field is required ! \n");
                                        continue;
                                    }
                                    else {
                                        adminMyApp.deleteLine(UserFile,  UsernameToDeleteit);
                                        break  breakSwitchAdmin;
                                    }
                                }


                            case 5:
                                System.out.println("The monthly subscription  is 30$" +"\n"+ "The Total of profits " +(adminMyApp.Counts(ProviderFile) )*30 + "$");

                                break;
                            case 6:

                                System.out.println("Logging out \n Thank you !");
                                // Add your logic for logging out
                                break outerWhile1;  // Exit the outer while loop
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                }
                    else if (loginMyApp.theSystemHasRegisteredUserWithUsernameAndPassword(username, password)) {
                        System.out.println("Login successfully , Welcome " +username +":)" );

                        while (true)
                        {
                            System.out.println("Choose: \n 1. Switch account to Provider account \n 2. Start Planning to wedding from zero \n 3. Select package \n 4. Logout");
                           Scanner scanner11 =new Scanner(System.in);

                            useroption = scanner11.nextLine();
                            outerWhile :
                            switch (useroption) {
                                case "1":
                                    System.out.println("Switching to Provider account");

                                    if (switchAccountToProviderMyApp.thisUsernamePasswordHaveAccessToBeProvider(username,password)) {
                                        System.out.println("Login successfully As Provider , welcome " + username +" To provider Page :) ");

                                        while (true)
                                        {

                                            System.out.println("Choose: \n 1. Switch account to User account \n 2. Add Halls Wedding \n 3. Delete Halls Wedding \n 4. Add package \n 5. Delete Package \n 6. Provider Profits   \n 7. Logout ");
                                            useroption = scanner.nextLine();
                                            secondWhile:
                                            switch (useroption) {
                                                case "1":System.out.println("Going back to the main menu");
                                                    break outerWhile;  // Exit to the first while loop

                                                case "2":
                                                    //////////////////////
                                                    while (true){
                                                        System.out.println("Enter Hall Name : ");
                                                        HallName = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HallName) ) {
                                                            System.out.print("Hall Name field is required ! \n");
                                                            continue ;
                                                        }
                                                        else if (!signup.thereIsNoDuplicatedUserOnTheFile(HallName,"Halls.txt")) {
                                                            System.out.print("This Hall already Exist ! \n");
                                                            continue;
                                                        }

                                                        else {
                                                            while (true) {
                                                                System.out.println("Enter Hall Capacity : ");
                                                                HallCapacity = scanner.nextLine();
                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HallCapacity)) {
                                                                    System.out.print("Hall capacity field is required ! \n");
                                                                    continue;
                                                                } else if (! payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(HallCapacity)) {
                                                                    System.out.print("Enter a Valid Capacity ! \n");
                                                                    continue;
                                                                }
                                                                else if (!payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(HallCapacity)) {
                                                                    System.out.print("Enter a Valid Capacity ! \n");
                                                                    continue;
                                                                }

                                                                else {
                                                                    while (true) {
                                                                        System.out.println("Enter Hall Price : ");
                                                                        HallPrice = scanner.nextLine();
                                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HallPrice)) {
                                                                            System.out.print("HallPrice field is required ! \n");
                                                                            continue;
                                                                        } else if ( !payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(HallPrice) ) {
                                                                            System.out.print("Enter a Valid Hall Price ! \n");
                                                                            continue;
                                                                        }
                                                                        else if ( !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(HallPrice) ) {
                                                                            System.out.print("Enter a Valid Hall Price ! \n");
                                                                            continue;
                                                                        }
                                                                        else{
                                                                            while (true) {
                                                                                System.out.println("Enter Hall Location : ");
                                                                                HallLocation = scanner.nextLine();
                                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HallLocation)) {
                                                                                    System.out.print("Hall Location field is required ! \n");
                                                                                    continue;
                                                                                }
                                                                                else {
                                                                                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Halls.txt", true))) {
                                                                                        // Append hall details to the file
                                                                                        writer.write(HallName + "," + HallCapacity + "," + HallPrice + "," + HallLocation + "," +username);
                                                                                        writer.newLine();

                                                                                    } catch (IOException e) {
                                                                                        System.err.println("Error writing to the file: " + e.getMessage());
                                                                                    }
                                                                                    System.out.print("Adding Hall successful ! \n" );//

                                                                                    break ; }
                                                                            }

                                                                            break ;   }
                                                                        
                                                                    }

                                                                    break ; }

                                                            }
                                                            break ; }

                                                    }
                                                    //////////////////
                                                    break ;
                                                case "3":
                                                    System.out.println("Enter The Name Of Hall To Delete It : ");
                                                    String fileName1 = "Halls.txt";
                                                    String wordToDelete1 = scanner.nextLine();
                                                    File inputFile1 = new File(fileName1);
                                                    File tempFile1 = new File("temp.txt");

                                                    BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
                                                    BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));

                                                    String currentLine1;
                                                    boolean deleted = false; // Flag to track if the file is deleted

                                                    while ((currentLine1 = reader1.readLine()) != null) {
                                                        // Split the current line by comma (assuming username and password are separated by comma)
                                                        String[] parts = currentLine1.split(",");
                                                        if (!parts[0].trim().equals(wordToDelete1)) {
                                                            writer1.write(currentLine1 + System.getProperty("line.separator"));
                                                        } else {
                                                            deleted = true; // Set flag to true if a line is deleted
                                                        }
                                                    }
                                                    writer1.close();
                                                    reader1.close();

                                                    // Delete the original file
                                                    if (!inputFile1.delete()) {
                                                        System.out.println("Could not delete original file");
                                                        return;
                                                    }

                                                    // Rename the temporary file to the original file name
                                                    if (!tempFile1.renameTo(inputFile1)) {
                                                        System.out.println("Could not rename temporary file");
                                                        return;
                                                    }

                                                    // Print "Delete successful" if a line was deleted
                                                    if (deleted) {
                                                        System.out.println("Delete successful");
                                                    } else {
                                                        System.out.println("No lines were deleted");
                                                    }
                                                    break secondWhile ;



                                                //////////////////////////
                                                case"4":
                                                    while (true){
                                                        System.out.println("Enter Package Name : ");
                                                        PackgName = scanner.nextLine();
                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(PackgName) ) {
                                                            System.out.print("Package Name field is required ! \n");
                                                            continue ;
                                                        }
                                                        else if (!signup.thereIsNoDuplicatedUserOnTheFile( PackgName,"Package.txt")) {
                                                            System.out.print("This Package already Exist ! \n");
                                                            continue;
                                                        }
/////////////////////
                                                        while (true) {


                                                            System.out.println("Enter Package Price : ");
                                                            FlowerPriceP  = scanner.nextLine();
                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(   FlowerPriceP)) {
                                                                System.out.print("PackagePrice field is required ! \n");
                                                                continue;
                                                            } else if ( !payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(   FlowerPriceP) ) {
                                                                System.out.print("Enter a Valid Package Price ! \n");
                                                                continue;
                                                            }
                                                            else if ( !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(   FlowerPriceP) ) {
                                                                System.out.print("Enter a Valid Package Price ! \n");
                                                                continue;
                                                            }
                                                            else {
                                                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                    // Append hall details to the file
                                                                    writer.write(   PackgName+ ","+ FlowerPriceP );
                                                                } catch (IOException e) {
                                                                    System.err.println("Error writing to the file: " + e.getMessage());
                                                                }


                                                                break ;

                                                            }



                                                        }

                                                        //////////////////////////

                                                        System.out.println("Enter Hall Name : ");
                                                        HallnameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName( HallnameP) ) {
                                                            System.out.print("Hall Name field is required ! \n");
                                                            continue ;
                                                        }
                                                        else if (!signup.thereIsNoDuplicatedUserOnTheFile( HallnameP,"Package.txt")) {
                                                            System.out.print("This Hall already Exist ! \n");
                                                            continue;
                                                        }

                                                        else {
                                                            while (true) {
                                                                System.out.println("Enter Hall Capacity : ");
                                                                CapacityP = scanner.nextLine();
                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(CapacityP)) {
                                                                    System.out.print("Hall capacity field is required ! \n");
                                                                    continue;
                                                                } else if (! payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(CapacityP)) {
                                                                    System.out.print("Enter a Valid Capacity ! \n");
                                                                    continue;
                                                                }
                                                                else if (!payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(CapacityP)) {
                                                                    System.out.print("Enter a Valid Capacity ! \n");
                                                                    continue;
                                                                }

                                                                else {//
                                                                    while (true) {

                                                                        if (false) {

                                                                            continue;
                                                                        }
                                                                        else{
                                                                            while (true) {
                                                                                System.out.println("Enter Hall Location : ");
                                                                                HLocationP = scanner.nextLine();
                                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName( HLocationP)) {
                                                                                    System.out.print("Hall Location field is required ! \n");
                                                                                    continue;
                                                                                }
                                                                                else {
                                                                                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                                        // Append hall details to the file
                                                                                        writer.write( ","+"Hall Name :" +HallnameP + "," +"Hall Capacity :" + CapacityP + ","+" Hall Location :" + HLocationP);


                                                                                    } catch (IOException e) {
                                                                                        System.err.println("Error writing to the file: " + e.getMessage());
                                                                                    }


                                                                                    break ; }
                                                                            }

                                                                            break ;   }
                                                                        // else {System.out.print("Payment was successful ! \n");
                                                                        //  b=switchAccountToProviderMyApp.storeProviderData(username,password);
                                                                        // break ; }
                                                                    }

                                                                    break ; }///********

                                                            }
                                                            break ; }

                                                    }/////end hall
                                                    Scanner scanner2 = new Scanner(System.in);
                                                    System.out.print("Do U Want to Add Dj \n");
                                                    System.out.print("Yes : 1 \n");
                                                    System.out.print("NO : 0 \n");
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;


                                                    while (flag){
                                                        System.out.println("Enter Dj Name : ");
                                                        DjnameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  DjnameP) ) {
                                                            System.out.print("Dj Name field is required ! \n");
                                                            continue ;
                                                        }
                                                        else if (!signup.thereIsNoDuplicatedUserOnTheFile(  DjnameP,"Package.txt")) {
                                                            System.out.print("This Dj already Exist ! \n");
                                                            continue;
                                                        }

                                                        else {

                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                // Append hall details to the file
                                                                writer.write(  "," +"Dj Name :"+ DjnameP );

                                                            } catch (IOException e) {
                                                                System.err.println("Error writing to the file: " + e.getMessage());
                                                            }


                                                            break ;




                                                        }
                                                    }/////////end DJ
                                                    System.out.print("Do U Want to Add Studio \n");
                                                    System.out.print("Yes : 1 \n");
                                                    System.out.print("NO : 0 \n");
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;
                                                    while (flag){
                                                        System.out.println("Enter Studio Name : ");
                                                        studionameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(   studionameP ) ) {
                                                            System.out.print("Studio field is required ! \n");
                                                            continue ;
                                                        }
                                                        else if (!signup.thereIsNoDuplicatedUserOnTheFile(  studionameP ,"Package.txt")) {
                                                            System.out.print("This Studio already Exist ! \n");
                                                            continue;
                                                        }

                                                        else {

                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                // Append hall details to the file
                                                                writer.write(  "," +"Studio Name :"+ studionameP  );

                                                            } catch (IOException e) {
                                                                System.err.println("Error writing to the file: " + e.getMessage());
                                                            }


                                                            break ;
                                                        }
                                                    }   //////////// endStudio

                                                    System.out.print("Do U Want to Add Dessert \n");
                                                    System.out.print("Yes : 1 \n");
                                                    System.out.print("NO : 0 \n");
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;

                                                    while (flag){
                                                        System.out.println("Enter dessert Name : ");
                                                        DessertnameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  DessertnameP ) ) {
                                                            System.out.print("dessert field is required ! \n");
                                                            continue ;
                                                        }
                                                        else if (!signup.thereIsNoDuplicatedUserOnTheFile(  DessertnameP ,"Package.txt")) {
                                                            System.out.print("This dessert already Exist ! \n");
                                                            continue;
                                                        }

                                                        else {
                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                // Append hall details to the file
                                                                writer.write(  "," + "Dessert Name :"+ DessertnameP  );

                                                            } catch (IOException e) {
                                                                System.err.println("Error writing to the file: " + e.getMessage());
                                                            }


                                                            break ;

                                                        }
                                                    }   //////////// end dessert

                                                    System.out.print("Do U Want to Add Main Course \n");
                                                    System.out.print("Yes : 1 \n");
                                                    System.out.print("NO : 0 \n");
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;

                                                    while (flag){
                                                        System.out.println("Enter Main Course Name : ");
                                                        MainCnameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  MainCnameP ) ) {
                                                            System.out.print("Main Course field is required ! \n");
                                                            continue ;
                                                        }
                                                        else if (!signup.thereIsNoDuplicatedUserOnTheFile(  MainCnameP ,"Package.txt")) {
                                                            System.out.print("This Main Course already Exist ! \n");
                                                            continue;
                                                        }

                                                        else {

                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                // Append hall details to the file
                                                                writer.write(  "," + "Main_Course Name :" +MainCnameP  );

                                                            } catch (IOException e) {
                                                                System.err.println("Error writing to the file: " + e.getMessage());
                                                            }



                                                            break ;
                                                        }
                                                    }
                                                    //////////// end Main Course

                                                    System.out.print("Do U Want to Add Flowers \n");
                                                    System.out.print("Yes : 1 \n");
                                                    System.out.print("NO : 0 \n");
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;

                                                    while (true){
                                                        if(flag) {
                                                            System.out.println("Enter Flower Name : ");
                                                            FlowernameP = scanner.nextLine();

                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(FlowernameP)) {
                                                                System.out.print("Flower field is required ! \n");
                                                                continue;
                                                            } else if (!signup.thereIsNoDuplicatedUserOnTheFile(FlowernameP, "Package.txt")) {
                                                                System.out.print("This Flower already Exist ! \n");
                                                                continue;
                                                            } else  {
                                                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                    // Append hall details to the file
                                                                    writer.write(","+"Flower Name :"+ FlowernameP);

                                                                } catch (IOException e) {
                                                                    System.err.println("Error writing to the file: " + e.getMessage());
                                                                }


                                                                break;

                                                            }
                                                        }
                                                        else  {
                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Package.txt", true))) {
                                                                // Append hall details to the file
                                                                writer.write(","+username);
                                                                writer.newLine();
                                                                System.out.print("Adding Package successful ! \n");//
                                                            } catch (IOException e) {
                                                                System.err.println("Error writing to the file: " + e.getMessage());
                                                            }
                                                            break secondWhile ;
                                                        }
                                                    }   //////////// end Flower



                                                    break ;

                                                /////////////////////
                                                case "5":
                                                    System.out.println("Enter The Name Of Package To Delete It : ");
                                                    String fileName = "Package.txt";
                                                    String wordToDelete = scanner.nextLine();
                                                    File inputFile = new File(fileName);
                                                    File tempFile = new File("temp.txt");

                                                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                                                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                                                    String currentLine;
                                                    boolean deleted1 = false; // Flag to track if the file is deleted

                                                    while ((currentLine = reader.readLine()) != null) {
                                                        // Split the current line by comma (assuming username and password are separated by comma)
                                                        String[] parts = currentLine.split(",");
                                                        if (!parts[0].trim().equals(wordToDelete)) {
                                                            writer.write(currentLine + System.getProperty("line.separator"));
                                                        } else {
                                                            deleted1 = true; // Set flag to true if a line is deleted
                                                        }
                                                    }
                                                    writer.close();
                                                    reader.close();

                                                    // Delete the original file
                                                    if (!inputFile.delete()) {
                                                        System.out.println("Could not delete original file");
                                                        return;
                                                    }

                                                    // Rename the temporary file to the original file name
                                                    if (!tempFile.renameTo(inputFile)) {
                                                        System.out.println("Could not rename temporary file");
                                                        return;
                                                    }

                                                    // Print "Delete successful" if a line was deleted
                                                    if (deleted1) {
                                                        System.out.println("Delete successful");
                                                    } else {
                                                        System.out.println("No lines were deleted");
                                                    }
                                          break secondWhile;
////////////////////////////////////////////////////////////
                                                case "6":
                                                    System.out.println("Provider's Profit ="+PriceCalculator.calculateTotalPrice("profitsPackage.txt","profits.txt",username));
                                                    break secondWhile;


                                                case "7" :
                                                    System.out.println("Logging out \n Thank you !");
                                                    // Add your logic for logging out
                                                    break outerWhile1;  // Exit the outer while loop
                                                default:
                                                    System.out.println("Invalid option. Please try again.");
                                            }

                                        }

                                    }


                                    else {
                                        while (true){
                                            System.out.println("The monthly subscription  is 30$");
                                            System.out.println("if you want to subscribe to Fiesta app enter 1 else enter 0 ");
                                            Enternumber=scanner.nextLine();
                                            if (Enternumber.equals("1")) {

                                             while (true){
                                            System.out.println("Enter Card Number : ");
                                            Paypage = scanner.nextLine();

                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(Paypage) ) {
                                                System.out.print("Card Number field is required ! \n");
                                                continue ;
                                            }
                                            else   if (payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberStartingWith(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberContainingLetters(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(Paypage)) {
                                                System.out.print("Enter a Valid Number ! \n");
                                                continue ;
                                            }

                                            else {
                                                while (true) {
                                                    System.out.println("Enter Card Owner Name : ");
                                                    Paypage = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(Paypage)) {
                                                        System.out.print("Card Owner Name field is required ! \n");
                                                        continue;
                                                    } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(Paypage)) {
                                                        System.out.print("Enter a Valid Name ! \n");
                                                        continue;
                                                    } else {
                                                        while (true) {
                                                            System.out.println("Enter  CVC : ");
                                                            Paypage = scanner.nextLine();
                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(Paypage)) {
                                                                System.out.print("Card Number field is required ! \n");
                                                                continue;
                                                            } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(Paypage) || payPageMyApp.theUserSubmitsThePaymentFormWithACVCStartingWith(Paypage)) {
                                                                System.out.print("Enter a Valid CVC Number ! \n");
                                                                continue;
                                                            } else {
                                                                System.out.print(" * Payment was successful * ! \n");
                                                                System.out.println("You have successfully subscribed :)");
                                                                b = switchAccountToProviderMyApp.storeProviderData(username, password);
                                                                break;
                                                            }
                                                            }

                                                        break;
                                                    }
                                                }
                                               break ; }
                                                  }
                                                }
                                            else {break ; }

                                      break ;  }
                                        break;  }

                                case "2":
                                    System.out.println("Let's Go to wedding planning !");
                                    innerWhile:
                                    while (true) {
                                        System.out.println("Choose: \n 1. Wedding Halls  \n 2. Hire a DJ  \n 3. Photography Studio \n " +
                                                "4. Flowers \n 5. Main course \n 6. Dessert \n  7.Save \n 8. Back to the previous page  ");
                                        option1 = scanner.nextLine();
                                        planningloop:
                                        switch (option1) {
                                            case "1":
                                                userMyApp.displayFileContents("Halls.txt");//print
                                                // Add your logic for Wedding Halls
                                                while (true) {

                                                    System.out.println("Enter Hall Name:");//enter hallname
                                                    hallName = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(hallName)) {
                                                        System.out.print("Hall Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(hallName, "Halls.txt")) {
                                                        System.out.println("----------------------------------------------------------");
                                                        System.out.print("This name is not in the list , please rewrite the name ! \n");
                                                        System.out.println("----------------------------------------------------------");
                                                        continue;
                                                    }

                                                else {
                                                        HallProfitUpdater.updateOrPrintProfits( hallName);
                                                    if (hallName != null && !hallName.trim().isEmpty()) {
                                                        String finalHallName = hallName;
                                                        SwingUtilities.invokeLater(() -> new YearlyBookingCalendar(finalHallName.trim()));
                                                    }
                                                    userMyApp.AddtoEvent("HallName: ", hallName);
                                                    UserProfit += userMyApp.getColumnValueForHall(HallPath, hallName, 2);//
                                                    // System.out.println(userMyApp.getColumnValueForHall(HallPath,hallName,2));
                                                }
                                                    break planningloop;
                                                }
                                            case "2":
                                                // Add your logic for Hiring a DJ
                                                userMyApp.displayFileContents("Dj.txt");
                                                while (true) {

                                                    System.out.println("Enter Dj Name:");
                                                    djName = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(djName)) {
                                                        System.out.print("Dj Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(djName, DjFile)) {
                                                        System.out.println("----------------------------------------------------------");
                                                        System.out.print("This name is not in the list , please rewrite the name ! \n");
                                                        System.out.println("----------------------------------------------------------");
                                                        continue;
                                                    }

                                                    else {
                                                        if (djName != null && !djName.trim().isEmpty()) {
                                                            String finalDjName = djName;
                                                            SwingUtilities.invokeLater(() -> new YearlyBookingCalendarDj(finalDjName.trim()));
                                                        }
                                                        userMyApp.AddtoEvent("Dj: ", djName);
                                                        UserProfit += userMyApp.getColumnValueForHall(DjFile, djName, 1);//

                                                    }
                                                    break planningloop;
                                                }
                                            case "3":
                                                userMyApp.displayFileContents("studio.txt");
                                                // Add your logic for Photography Studio
                                                while (true) {

                                                    System.out.println("Enter Studio Name:");
                                                    StudioName = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName( StudioName)) {
                                                        System.out.print(" Studio Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile( StudioName, StudioFile)) {
                                                        System.out.println("----------------------------------------------------------");
                                                        System.out.print("This name is not in the list , please rewrite the name ! \n");
                                                        System.out.println("----------------------------------------------------------");
                                                        continue;
                                                    }
                                                    else {
                                                        if (StudioName != null && !StudioName.trim().isEmpty()) {
                                                            String finalStudioName = StudioName;
                                                            SwingUtilities.invokeLater(() -> new YearlyBookingCalendarStudio(finalStudioName.trim()));
                                                        }
                                                        userMyApp.AddtoEvent("Studio: ", StudioName);
                                                        UserProfit += userMyApp.getColumnValueForHall(StudioFile, StudioName, 1);//
                                                    }
                                                        break planningloop;

                                                }
                                            case "4":
                                                userMyApp.displayFileContents("flower.txt");
                                                // Add your logic for Flowers
                                                while (true) {

                                                    System.out.println("Enter Flower Type:");
                                                    FlowerName = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName( FlowerName)) {
                                                        System.out.print(" Flower Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile( FlowerName, FlowerFile)) {
                                                        System.out.println("----------------------------------------------------------");
                                                        System.out.print("This name is not in the list , please rewrite the name ! \n");
                                                        System.out.println("----------------------------------------------------------");
                                                        continue;
                                                    }
                                                    else {

                                                        userMyApp.AddtoEvent("Flower: ", FlowerName);
                                                        UserProfit += userMyApp.getColumnValueForHall(FlowerFile, FlowerName, 1);//
                                                    }
                                                        break planningloop;
                                                }
                                            case "5":
                                                userMyApp.displayFileContents("maincourse.txt");
                                                // Add your logic for Main course
                                                while (true) {

                                                    System.out.println("Enter Maincourse Name:");
                                                    Maincourse = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  Maincourse)) {
                                                        System.out.print("  Main course Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(  Maincourse, maincourseFile)) {
                                                        System.out.println("----------------------------------------------------------");
                                                        System.out.print("This name is not in the list , please rewrite the name ! \n");
                                                        System.out.println("----------------------------------------------------------");
                                                        continue;
                                                    }
                                                    else {

                                                        userMyApp.AddtoEvent("Maincourse: ", Maincourse);
                                                        UserProfit += userMyApp.getColumnValueForHall(maincourseFile, Maincourse, 1);//
                                                    }
                                                    break planningloop;
                                                }
                                            case "6":
                                                userMyApp.displayFileContents("desert.txt");
                                                while (true) {
                                                    // Add your logic for Dessert

                                                    System.out.println("Enter Desert Name:");
                                                    Desert = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  Desert)) {
                                                        System.out.print("  Dessert Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(  Desert, DesertFile)) {
                                                        System.out.println("----------------------------------------------------------");
                                                        System.out.print("This name is not in the list , please rewrite the name ! \n");
                                                        System.out.println("----------------------------------------------------------");
                                                        continue;
                                                    }
                                                    else {
                                                        userMyApp.AddtoEvent("Desert: ", Desert);
                                                        UserProfit += userMyApp.getColumnValueForHall(DesertFile, Desert, 1);//
                                                    }
                                                        break planningloop;
                                                }
                                            case "7":

                                                System.out.println("Total profit="+UserProfit);
                                                System.out.println("To complete the order , please pay !");
                                                /////////////////////////////////
                                                while (true){
                                                    System.out.println("Enter Card Number : ");
                                                    Paypage = scanner.nextLine();

                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(Paypage) ) {
                                                        System.out.print("Card Number field is required ! \n");
                                                        continue ;
                                                    }
                                                    else   if (payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberStartingWith(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberContainingLetters(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(Paypage)) {
                                                        System.out.print("Enter a Valid Number ! \n");
                                                        continue ;
                                                    }

                                                    else {
                                                        while (true) {
                                                            System.out.println("Enter Card Owner Name : ");
                                                            Paypage = scanner.nextLine();
                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(Paypage)) {
                                                                System.out.print("Card Owner Name field is required ! \n");
                                                                continue;
                                                            } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(Paypage)) {
                                                                System.out.print("Enter a Valid Name ! \n");
                                                                continue;
                                                            } else {
                                                                while (true) {
                                                                    System.out.println("Enter  CVC : ");
                                                                    Paypage = scanner.nextLine();
                                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(Paypage)) {
                                                                        System.out.print("Card Number field is required ! \n");
                                                                        continue;
                                                                    } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(Paypage) || payPageMyApp.theUserSubmitsThePaymentFormWithACVCStartingWith(Paypage)) {
                                                                        System.out.print("Enter a Valid CVC Number ! \n");
                                                                        continue;
                                                                    } else {
                                                                        System.out.print(" * Payment was successful * ! \n");
                                                                        System.out.println("Saved correctly");
                                                                        b = switchAccountToProviderMyApp.storeProviderData(username, password);
                                                                        break;
                                                                    }
                                                                }

                                                                break;
                                                            }
                                                        }
                                                        break ; }
                                                }
                                                /////////////////////////////////////
                                                userMyApp.AddtoEvent("Total profit =",String.valueOf(UserProfit));
                                                userMyApp.AddtoEvent("-----------------","----------------");
                                                break innerWhile;

                                            case "8":
                                                System.out.println("Going back to the main menu");
                                                break innerWhile;

                                            default:
                                                System.out.println("Invalid option. Please try again.");
                                        }
                                    } // end inner whil loopop
                                    break;
                                case "3":
                                   System.out.println("choose : \n 1. select the package and choose according to the price that suits you !\n "
                                   + " 2. Enter the price you have so we can show you prices that are closet to  the packages !");

                                   int x =scanner.nextInt();
                                   if (x==1){
                                       userMyApp.displayFileContents("Package.txt");
                                       while (true) {
                                           // Add your logic for Dessert
                                           System.out.println("Enter Package name:");
                                         Scanner sc =new Scanner(System.in);
                                         Pname = sc.nextLine();

                                           if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(Pname)) {
                                               System.out.print("  Packge Name field is required ! \n");
                                               continue;
                                           } else if (!userMyApp.checkFile(  Pname, "Package.txt")) {
                                               System.out.println("----------------------------------------------------------");
                                               System.out.print("This name is not in the list , please rewrite the name ! \n");
                                               System.out.println("----------------------------------------------------------");
                                               continue;
                                           }
                                           else {
                                               HallProfitUpdaterPackage.updateOrPrintProfitsPackage(  Pname);
                                               if ( Pname != null && ! Pname.trim().isEmpty()) {
                                                   String finalPackgName =  Pname;
                                                   SwingUtilities.invokeLater(() -> new YearlyBookingCalendarPachage( finalPackgName.trim()));
                                               }
                                               userMyApp.AddtoEvent("Package: ",Pname);
                                               UserProfit += userMyApp.getColumnValueForHall("Package.txt", Pname, 1);//
                                               userMyApp.AddtoEvent("Total profit =",String.valueOf(UserProfit));
                                               userMyApp.AddtoEvent(":::::::::::::::::",":::::::::::::::::");
                                               System.out.println("Profir =" + UserProfit);
                                          System.out.println("Added successfully ! ");
                                               break ;
                                           }

                                       }

}


else {


}


                                    break;
                                case "4":
                                    System.out.println("Logging out \n Thank you !");
                                    // Add your logic for logging out
                                    break outerWhile1;  // Exit the outer while loop
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        } // end outer while loop
                    } else {
                        System.out.println("Wrong username or password !");
                        break;  // Break from the second while loop and go back to the main menu
                    }
                }
     }
}
}
}