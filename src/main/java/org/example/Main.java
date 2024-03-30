package org.example;
import myapp.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;


public class Main {

    private static final Logger utilityLogger = LoggerUtility.getLogger();

    private static final String LOGOUT_MSG = "Logging out \n Thank you !";
    private static final String UN_VALID_OPTION_MSG = "Invalid option. Please try again.";
    private static final String HN_FAIL_MSG = "Hall Name field is required ! \n";
    private static final String CARD_OWNER_NAME_REQUIRED_MSG = "Card Owner Name field is required ! \n";
    private static final String CARD_NUMBER_REQUIRED_MSG = "Card Number field is required ! \n";
    private static final String ENTER_V_CAPACITY_MSG = "Enter a Valid Capacity ! \n";
    private static final String VALID_NUMBER_MSG = "Enter a Valid Number ! \n";
    private static final String VALID_CVC_MSG = "Enter a Valid CVC Number ! \n";
    private static final String HALL_PATH = "Halls.txt";
    private static final String PACKAGE_FILE ="Package.txt";
    private static final String ERROR_WRITE_FILE_MSG = "Error writing to the file: ";
    private static final String PACKAGE_NAME_REQ = "Package Name field is required ! \n";
    private static final String SPACE_SEPARATOR = "----------------------------------------------------------";
    private static final String SEPARATOR_LINE = ":::::::::::::::::";
    private static final String NAME_NOT_IN_LIST_MSG = "This name is not in the list, please rewrite the name ! \n";
    private static final String EXCEPTION_MESSAGE ="we have Exception";
    private static final String USER_FILE = "user_data.txt";
    private static final String PROVIDER_FILE  = "provider_data.txt";
    private static final String DJ_FILE ="Dj.txt";
    private static final String DESERT_FILE="desert.txt";
    private static final String MAIN_COURSE_FILE="maincourse.txt";
    private static final String FLOWER_FILE ="flower.txt";
    private static final String STUDIO_FILE ="studio.txt";
    private static final String ENTER_VALID_NAME_MSG = "Enter a Valid Name ! \n";
    private static final String YES_OPTION ="Yes : 1 \n";
    private static final String NO_OPTION = "NO : 0 \n";
    private static final String ENTER_CARD_NUMBER_MSG = "Enter Card Number : ";
    private static final String ENTER_CARD_OWNER_NAME_MSG = "Enter Card Owner Name : ";
    private static final String ENTER_CVC_MSG = "Enter CVC : ";
    private static final String PAYMENT_SUCCESSFUL_MSG = " * Payment was successful * ! \n";

    public static void main(String[] args) throws IOException {
        SignUpMyApp myApp = new SignUpMyApp();
        SwitchAccountToProviderMyApp switchAccountToProviderMyApp=new SwitchAccountToProviderMyApp() ;
        PayPageMyApp payPageMyApp=new PayPageMyApp();
        LoginMyApp loginMyApp = new LoginMyApp();
        SignUpMyApp signup=new SignUpMyApp();
        AdminMyApp adminMyApp=new AdminMyApp();
        Scanner scanner = new Scanner(System.in);
        UserMyApp  userMyApp=new UserMyApp() ;
        String username;
        String password;
        String option1;
        String useroption;
        String paypage;
        String HallName;
        String hallCapacity;
        String hallPrice;
        String hallLocation;
        String providerNameToDeleteIt;
        String usernameToDeleteIt ;

        String hallName = null;
        String djName= null;
        String studioName = null;
        String flowerName =null;
        String mainCourse =null;
        String desert =null;


        int UserProfit=0, packgCount=0;
        String PackgName ;
        String Pname ;
        boolean b =false;
        int s=0 ;String Enternumber;
        boolean flag=false;
        String HallnameP,HPriceP,CapacityP,HLocationP,DjnameP,DjPriceP,FlowernameP,FlowerPriceP,DessertnameP,studionameP,StudioPriceP,MainCnameP,MaincPriceP,DessertP;
        outerWhile1:
        while (true) {
            utilityLogger.info("Choose: \n 1. Sign up \n 2. Login \n ");
            option1 = scanner.nextLine();

            if (option1.equals("1")) {
                while (true) {
                    utilityLogger.info("Enter your username:\n");
                    username = scanner.nextLine();

                    if (myApp.iLeaveTheUsernameFieldEmpty(username)) {
                        utilityLogger.info("UserName field is required    \n");
                        continue;
                    }

                    while (true) {
                        utilityLogger.info("Enter your password:\n");
                        password = scanner.nextLine();

                        if (myApp.iLeaveThePasswordFieldEmpty(password)) {
                            utilityLogger.info("Password field is required    \n");
                            continue;
                        } else break;
                    }

                    if (myApp.theSystemHasAnExistingUserWithUsername(username)) {
                        continue;
                    }

                    if (myApp.iiEnterValidUsernamePassword(username, password)) {
                        break;
                    }
                }
                utilityLogger.info("Do you want to login? Enter 2 to login, or any other key to go back to the main menu \n");
                option1 = scanner.nextLine();
            }

            if (option1.equals("2")) {
                utilityLogger.info("*************************************************************** \n");
                utilityLogger.info("Welcome to Fiesta App, please enter your username and password. \n");
                utilityLogger.info("*************************************************************** \n");
                while (true) {
                    utilityLogger.info("Enter your username:");
                    username = scanner.nextLine();

                    if (myApp.iLeaveTheUsernameFieldEmpty(username)) {
                        utilityLogger.info("UserName field is required \n");
                        continue;
                    }

                    while (true) {
                        utilityLogger.info("Enter your password:\n ");
                        password = scanner.nextLine();

                        if (myApp.iLeaveThePasswordFieldEmpty(password)) {
                            utilityLogger.info("Password field is required    \n");
                            continue;
                        } else break;
                    }

                    if (LoginMyApp.iEnterUsernameAndPassword(username, password)) {
                        utilityLogger.info("Login successfully As Admin , Welcome Zaid :) \n");
                        while (true) {
                            utilityLogger.info("Choose: \n 1. View a provider count  \n 2. View a user count \n 3. Delete provider \n 4. Delete User \n 5. view a profit \n 6. Logout");
                            int choice = scanner.nextInt();
                            breakSwitchAdmin:
                            switch (choice) {
                                case 1:
                                    utilityLogger.info("The Provider Count =  " +  Counts(PROVIDER_FILE ));
                                    break;
                                case 2:
                                    utilityLogger.info("The User Count =  " +  Counts(USER_FILE));
                                    break;
                                case 3:
                                    Scanner Sc = new Scanner(System.in);
                                    while (true) {
                                        utilityLogger.info("Enter the name of the provider you want to delete : ");
                                        providerNameToDeleteIt = Sc.nextLine();
                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(providerNameToDeleteIt)) {
                                            utilityLogger.info("Provider name field is required ! \n");
                                            continue;
                                        } else {
                                            AdminMyApp.deleteLine(PROVIDER_FILE , providerNameToDeleteIt);
                                            break;
                                        }
                                    }
                                    break;
                                case 4:
                                    Scanner Sc1 = new Scanner(System.in);
                                    while (true) {
                                        utilityLogger.info("Enter the name of the User you want to delete : \n");
                                        usernameToDeleteIt = Sc1.nextLine();
                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(usernameToDeleteIt)) {
                                            utilityLogger.info("User name field is required ! \n");
                                            continue;
                                        } else {
                                            adminMyApp.deleteLine(USER_FILE, usernameToDeleteIt);
                                            break;
                                        }
                                    }
                                    break;
                                case 5:
                                    utilityLogger.info("The monthly subscription is 30$ \n");
                                    utilityLogger.info("The Total of profits " + ( Counts(PROVIDER_FILE )) * 30 + "$");
                                    break;
                                case 6:
                                    utilityLogger.info(LOGOUT_MSG);
                                    return;
                                default:
                                    utilityLogger.info(UN_VALID_OPTION_MSG);
                            }
                        }
                    } else if (loginMyApp.theSystemHasRegisteredUserWithUsernameAndPassword(username, password)) {
                        utilityLogger.info("Login successfully , Welcome " + username + ":)" +"\n");

                        while (true) {
                            utilityLogger.info("Choose: \n 1. Switch account to Provider account \n 2. Start Planning to wedding from zero \n 3. Select package \n 4. Logout");
                            Scanner scanner11 = new Scanner(System.in);
                            useroption = scanner11.nextLine();
                            outerWhile :
                            switch (useroption) {
                                case "1":
                                    utilityLogger.info("Switching to Provider account \n");
                                    if (switchAccountToProviderMyApp.thisUsernamePasswordHaveAccessToBeProvider(username, password)) {
                                        utilityLogger.info("Login successfully As Provider , welcome " + username + " To provider Page :) \n ");
                                        while (true) {
                                            utilityLogger.info("Choose: \n 1. Switch account to User account \n 2. Add Halls Wedding \n 3. Delete Halls Wedding \n 4. Add package \n 5. Delete Package \n 6. Provider Profits   \n 7. Logout ");
                                            useroption = scanner.nextLine();
                                            secondWhile :
                                            switch (useroption) {
                                                case "1":
                                                    utilityLogger.info("Going back to the main menu \n");
                                                    break;
                                                case "2":
                                                    while (true) {
                                                        utilityLogger.info("Enter Hall Name : ");
                                                        HallName = scanner.nextLine();
                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HallName)) {
                                                            utilityLogger.info(HN_FAIL_MSG);
                                                            continue;
                                                        } else if (!signup.thereIsNoDuplicatedUserOnTheFile(HallName, HALL_PATH)) {
                                                            utilityLogger.info("This Hall already Exist ! \n");
                                                            continue;
                                                        } else {
                                                            while (true) {
                                                                utilityLogger.info("Enter Hall Capacity : ");
                                                                hallCapacity = scanner.nextLine();
                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(hallCapacity)) {
                                                                    utilityLogger.info("Hall capacity field is required ! \n");
                                                                    continue;
                                                                } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(hallCapacity)) {
                                                                    utilityLogger.info(ENTER_V_CAPACITY_MSG);
                                                                    continue;
                                                                } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(hallCapacity)) {
                                                                    utilityLogger.info(ENTER_V_CAPACITY_MSG);
                                                                    continue;
                                                                } else {
                                                                    while (true) {
                                                                        utilityLogger.info("Enter Hall Price : ");
                                                                        hallPrice = scanner.nextLine();
                                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(hallPrice)) {
                                                                            utilityLogger.info("HallPrice field is required ! \n");
                                                                            continue;
                                                                        } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(hallPrice)) {
                                                                            utilityLogger.info("Enter a Valid Hall Price ! \n");
                                                                            continue;
                                                                        } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(hallPrice)) {
                                                                            utilityLogger.info("Enter a Valid Hall Price ! \n");
                                                                            continue;
                                                                        } else {
                                                                            while (true) {
                                                                                utilityLogger.info("Enter Hall Location : ");
                                                                                hallLocation = scanner.nextLine();
                                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(hallLocation)) {
                                                                                    utilityLogger.info("Hall Location field is required ! \n");
                                                                                    continue;
                                                                                } else {
                                                                                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(HALL_PATH, true))) {
                                                                                        writer.write(HallName + "," + hallCapacity + "," + hallPrice + "," + hallLocation + "," + username);
                                                                                        writer.newLine();
                                                                                        utilityLogger.info("Adding Hall successful ! \n");
                                                                                    } catch (IOException e) {
                                                                                        utilityLogger.severe(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case "3":
                                                    utilityLogger.info("Enter The Name Of Hall To Delete It : ");
                                                    searchValueInFile(HALL_PATH, username);
                                                    String fileName1 = "Halls.txt";
                                                    String wordToDelete1 = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(wordToDelete1)) {
                                                        utilityLogger.info(PACKAGE_NAME_REQ);
                                                        continue;
                                                    } else if (!userMyApp.checkFile(wordToDelete1, fileName1)) {
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        continue;
                                                    }

                                                    File inputFile1 = new File(fileName1);
                                                    File tempFile1 = new File("temp.txt");
                                                    boolean deleted = false;

                                                    try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
                                                         BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1))) {
                                                        String currentLine1;
                                                        while ((currentLine1 = reader1.readLine()) != null) {
                                                            String[] parts = currentLine1.split(",");
                                                            if (!parts[0].trim().equals(wordToDelete1)) {
                                                                writer1.write(currentLine1 + System.getProperty("line.separator"));
                                                            } else {
                                                                deleted = true;
                                                            }
                                                        }
                                                    } catch (IOException e) {
                                                        utilityLogger.warning(EXCEPTION_MESSAGE );
                                                    }

                                                    if (deleted) {
                                                        if (!inputFile1.delete()) {
                                                            utilityLogger.warning("Could not delete original file");
                                                            return;
                                                        }

                                                        if (!tempFile1.renameTo(inputFile1)) {
                                                            utilityLogger.warning("Could not rename temporary file");
                                                            return;
                                                        }

                                                        utilityLogger.info("Delete successful");
                                                    } else {
                                                        utilityLogger.info("No lines were deleted");
                                                    }

                                                    break secondWhile;



                                                case "4":
                                                    while (true) {
                                                        utilityLogger.info("Enter Package Name:");
                                                        PackgName = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(PackgName)) {
                                                            utilityLogger.info(PACKAGE_NAME_REQ);
                                                            continue;
                                                        } else if (!signup.thereIsNoDuplicatedUserOnTheFile(PackgName, PACKAGE_FILE )) {
                                                            utilityLogger.info("This Package already Exist ! \n");
                                                            continue;
                                                        } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(PackgName)) {
                                                            utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                            continue;
                                                        }

                                                        while (true) {
                                                            utilityLogger.info("Enter Package Price:");
                                                            FlowerPriceP = scanner.nextLine();

                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(FlowerPriceP)) {
                                                                utilityLogger.info("PackagePrice field is required ! \n");
                                                                continue;
                                                            } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(FlowerPriceP)) {
                                                                utilityLogger.info("Enter a Valid Package Price ! \n");
                                                                continue;
                                                            } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(FlowerPriceP)) {
                                                                utilityLogger.info("Enter a Valid Package Price ! \n");
                                                                continue;
                                                            } else {
                                                                try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {
                                                                    writer.write(PackgName + "," + FlowerPriceP);
                                                                } catch (IOException e) {
                                                                    utilityLogger.severe(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                                }
                                                                break;
                                                            }
                                                        }



                                                        while (true){
                                                            utilityLogger.info("Enter Hall Name : ");
                                                            HallnameP = scanner.nextLine();

                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HallnameP)) {
                                                                System.out.print(HN_FAIL_MSG);
                                                                continue;
                                                            } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(HallnameP)) {
                                                                utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                                continue;
                                                            } else {
                                                                while (true) {
                                                                    utilityLogger.info("Enter Hall Capacity : ");
                                                                    CapacityP = scanner.nextLine();
                                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(CapacityP)) {
                                                                        utilityLogger.info("Hall capacity field is required ! \n");
                                                                        continue;
                                                                    } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(CapacityP)) {
                                                                        System.out.print(ENTER_V_CAPACITY_MSG );
                                                                        continue;
                                                                    } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(CapacityP)) {
                                                                        System.out.print(ENTER_V_CAPACITY_MSG );
                                                                        continue;
                                                                    } else {//
                                                                        while (true) {

                                                                            if (false) {

                                                                                continue;
                                                                            } else {
                                                                                while (true) {
                                                                                    utilityLogger.info("Enter Hall Location : ");
                                                                                    HLocationP = scanner.nextLine();
                                                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HLocationP)) {
                                                                                        utilityLogger.info("Hall Location field is required ! \n");
                                                                                        continue;
                                                                                    } else {
                                                                                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {
                                                                                            // Append hall details to the file
                                                                                            writer.write("," + "Hall Name :" + HallnameP + "," + "Hall Capacity :" + CapacityP + "," + " Hall Location :" + HLocationP);


                                                                                        } catch (IOException e) {
                                                                                            System.err.println(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                                                        }


                                                                                        break;
                                                                                    }
                                                                                }

                                                                                break;
                                                                            }

                                                                        }

                                                                        break;
                                                                    }

                                                                }
                                                                break;
                                                            }


                                                        }
                                                        break ;
                                                    }
                                                    Scanner scanner2 = new Scanner(System.in);
                                                    utilityLogger.info("Do U Want to Add Dj \n");
                                                    utilityLogger.info(YES_OPTION);
                                                    utilityLogger.info(NO_OPTION);
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;


                                                    while (flag){
                                                        utilityLogger.info("Enter Dj Name : ");
                                                        DjnameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  DjnameP) ) {
                                                            utilityLogger.info("Dj Name field is required ! \n");
                                                            continue ;
                                                        }

                                                        else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField( DjnameP)) {
                                                            utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                            continue;
                                                        }

                                                        else {

                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {
                                                                // Append hall details to the file
                                                                writer.write(  "," +"Dj Name :"+ DjnameP );

                                                            } catch (IOException e) {
                                                                System.err.println(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                            }


                                                            break ;




                                                        }
                                                    }
                                                    utilityLogger.info("Do U Want to Add Studio \n");
                                                    utilityLogger.info(YES_OPTION);
                                                    utilityLogger.info(NO_OPTION);
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;
                                                    while (flag){
                                                        utilityLogger.info("Enter Studio Name : ");
                                                        studionameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(   studionameP ) ) {
                                                            utilityLogger.info("Studio field is required ! \n");
                                                            continue ;
                                                        }

                                                        else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(  studionameP)) {
                                                            utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                            continue;
                                                        }

                                                        else {

                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {
                                                                // Append hall details to the file
                                                                writer.write(  "," +"Studio Name :"+ studionameP  );

                                                            } catch (IOException e) {
                                                                System.err.println(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                            }


                                                            break ;
                                                        }
                                                    }

                                                    utilityLogger.info("Do U Want to Add Dessert \n");
                                                    utilityLogger.info(YES_OPTION);
                                                    utilityLogger.info(NO_OPTION);
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;

                                                    while (flag){
                                                        utilityLogger.info("Enter dessert Name : ");
                                                        DessertnameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  DessertnameP ) ) {
                                                            utilityLogger.info("dessert field is required ! \n");
                                                            continue ;
                                                        }

                                                        else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(  DessertnameP)) {
                                                            utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                            continue;
                                                        }


                                                        else {
                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {
                                                                // Append hall details to the file
                                                                writer.write(  "," + "Dessert Name :"+ DessertnameP  );

                                                            } catch (IOException e) {
                                                                System.err.println(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                            }


                                                            break ;

                                                        }
                                                    }

                                                    utilityLogger.info("Do U Want to Add Main Course \n");
                                                    utilityLogger.info(YES_OPTION);
                                                    utilityLogger.info(NO_OPTION);
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;

                                                    while (flag){
                                                        utilityLogger.info("Enter Main Course Name : ");
                                                        MainCnameP = scanner.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(  MainCnameP ) ) {
                                                            utilityLogger.info("Main Course field is required ! \n");
                                                            continue ;
                                                        }

                                                        else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(  MainCnameP)) {
                                                            utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                            continue;
                                                        }

                                                        else {

                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {

                                                                writer.write(  "," + "Main_Course Name :" +MainCnameP  );

                                                            } catch (IOException e) {
                                                                System.err.println(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                            }



                                                            break ;
                                                        }
                                                    }


                                                    utilityLogger.info("Do U Want to Add Flowers \n");
                                                    utilityLogger.info(YES_OPTION);
                                                    utilityLogger.info(NO_OPTION);
                                                    s= scanner2.nextInt();
                                                    if(s==0)flag=false;else flag=true;

                                                    while (true){
                                                        if(flag) {
                                                            utilityLogger.info("Enter Flower Name : ");
                                                            FlowernameP = scanner.nextLine();

                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(FlowernameP)) {
                                                                utilityLogger.info("Flower field is required ! \n");
                                                                continue;
                                                            } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(FlowernameP)) {
                                                                utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                                continue;
                                                            }
                                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {

                                                                writer.write("," + "Flower Name :" + FlowernameP);

                                                            } catch (IOException e) {
                                                                System.err.println(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                            }





                                                        }

                                                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PACKAGE_FILE , true))) {

                                                            writer.write(","+username);
                                                            writer.newLine();
                                                            utilityLogger.info("Adding Package successful ! \n");
                                                        } catch (IOException e) {
                                                            System.err.println(ERROR_WRITE_FILE_MSG + e.getMessage());
                                                        }
                                                        break secondWhile ;

                                                    }



                                                case "5":

                                                    searchValueInFile(PACKAGE_FILE ,username);
                                                    utilityLogger.info("Enter The Name Of Package To Delete It : ");
                                                    String fileName = PACKAGE_FILE ;
                                                    String wordToDelete = scanner.nextLine();
                                                    File inputFile = new File(fileName);
                                                    File tempFile = new File("temp.txt");

                                                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                                                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                                                    String currentLine;
                                                    boolean deleted1 = false;

                                                    while ((currentLine = reader.readLine()) != null) {

                                                        String[] parts = currentLine.split(",");
                                                        if (!parts[0].trim().equals(wordToDelete)) {
                                                            writer.write(currentLine + System.getProperty("line.separator"));
                                                        } else {
                                                            deleted1 = true;
                                                        }
                                                    }
                                                    writer.close();
                                                    reader.close();

                                                    if (!inputFile.delete()) {
                                                        utilityLogger.info("Could not delete original file");
                                                        return;
                                                    }


                                                    if (!tempFile.renameTo(inputFile)) {
                                                        utilityLogger.info("Could not rename temporary file");
                                                        return;
                                                    }


                                                    if (deleted1) {
                                                        utilityLogger.info("Delete successful");
                                                    } else {
                                                        utilityLogger.info("No lines were deleted");
                                                    }
                                                    break secondWhile;

                                                case "6":
                                                    utilityLogger.info("Provider's Profit ="+PriceCalculator.calculateTotalPrice("profitsPackage.txt","profits.txt",username));
                                                    break secondWhile;


                                                case "7" :
                                                    utilityLogger.info(LOGOUT_MSG );

                                                    break outerWhile1;
                                                default:
                                                    utilityLogger.info(UN_VALID_OPTION_MSG);
                                            }

                                        }

                                    }


                                    else {
                                        while (true){
                                            utilityLogger.info("The monthly subscription  is 30$ \n ");
                                            utilityLogger.info("if you want to subscribe to Fiesta app enter 1 else enter 0 \n ");
                                            Enternumber=scanner.nextLine();
                                            if (Enternumber.equals("1")) {

                                                while (true){
                                                    utilityLogger.info(ENTER_CARD_NUMBER_MSG);
                                                    paypage = scanner.nextLine();

                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage) ) {
                                                        utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                        continue ;
                                                    }
                                                    else   if (payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberStartingWith(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(paypage)) {
                                                        utilityLogger.info(VALID_NUMBER_MSG);
                                                        continue ;
                                                    }

                                                    else {
                                                        while (true) {
                                                            utilityLogger.info(ENTER_CARD_OWNER_NAME_MSG);
                                                            paypage = scanner.nextLine();
                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(paypage)) {
                                                                utilityLogger.info(CARD_OWNER_NAME_REQUIRED_MSG);
                                                                continue;
                                                            } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(paypage)) {
                                                                utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                                continue;
                                                            } else {
                                                                while (true) {
                                                                    utilityLogger.info(ENTER_CVC_MSG);
                                                                    paypage = scanner.nextLine();
                                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage)) {
                                                                        utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                                        continue;
                                                                    } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(paypage) || payPageMyApp.theUserSubmitsThePaymentFormWithACVCStartingWith(paypage)) {
                                                                        utilityLogger.info(VALID_CVC_MSG);
                                                                        continue;
                                                                    } else {
                                                                        utilityLogger.info(PAYMENT_SUCCESSFUL_MSG);
                                                                        utilityLogger.info("You have successfully subscribed :) \n ");
                                                                        b =  storeProviderData(username, password);
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
                                    utilityLogger.info("Let's Go to wedding planning !");
                                    innerWhile:
                                    while (true) {
                                        utilityLogger.info("Choose: \n 1. Wedding Halls  \n 2. Hire a DJ  \n 3. Photography Studio \n " +
                                                "4. Flowers \n 5. Main course \n 6. Dessert \n  7.Save \n 8. Back to the previous page \n ");
                                        option1 = scanner.nextLine();
                                        planningloop:
                                        switch (option1) {
                                            case "1":
                                                displayFileContents("Halls.txt");
                                                while (true) {

                                                    utilityLogger.info("Enter Hall Name:");
                                                    hallName = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(hallName)) {
                                                        System.out.print(HN_FAIL_MSG);
                                                        continue;
                                                    } else if (!userMyApp.checkFile(hallName, "Halls.txt")) {
                                                        System.out.println(SPACE_SEPARATOR);
                                                        System.out.print(NAME_NOT_IN_LIST_MSG);
                                                        System.out.println(SPACE_SEPARATOR);
                                                        continue;
                                                    } else {
                                                        HallProfitUpdater.updateOrPrintProfits(hallName);
                                                        if (hallName != null && !hallName.trim().isEmpty()) {
                                                            String finalHallName = hallName;
                                                            SwingUtilities.invokeLater(() -> new YearlyBookingCalendar(finalHallName.trim()));
                                                        }

                                                    }
                                                    break planningloop;
                                                }
                                            case "2":
                                                displayFileContents(  DJ_FILE);
                                                while (true) {

                                                    utilityLogger.info("Enter Dj Name:");
                                                    djName = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(djName)) {
                                                        utilityLogger.info("Dj Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(djName,  DJ_FILE)) {
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        continue;
                                                    } else {
                                                        if (djName != null && !djName.trim().isEmpty()) {
                                                            String finalDjName = djName;
                                                            SwingUtilities.invokeLater(() -> new YearlyBookingCalendarDj(finalDjName.trim()));
                                                        }

                                                    }
                                                    break planningloop;
                                                }
                                            case "3":
                                                displayFileContents(STUDIO_FILE);
                                                while (true) {

                                                    utilityLogger.info("Enter Studio Name:");
                                                    studioName  = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(studioName )) {
                                                        utilityLogger.info(" Studio Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(studioName , STUDIO_FILE)) {
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        continue;
                                                    } else {
                                                        if (studioName  != null && !studioName .trim().isEmpty()) {
                                                            String finalStudioName = studioName ;
                                                            SwingUtilities.invokeLater(() -> new YearlyBookingCalendarStudio(finalStudioName.trim()));
                                                        }

                                                    }
                                                    break planningloop;

                                                }
                                            case "4":
                                                displayFileContents(FLOWER_FILE);
                                                while (true) {

                                                    utilityLogger.info("Enter Flower Type:");
                                                    flowerName  = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(flowerName )) {
                                                        System.out.print(" Flower Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(flowerName ,FLOWER_FILE)) {
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        continue;
                                                    }

                                                    break planningloop;
                                                }
                                            case "5":
                                                displayFileContents(MAIN_COURSE_FILE);
                                                while (true) {

                                                    utilityLogger.info("Enter Maincourse Name:");
                                                    mainCourse  = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(mainCourse )) {
                                                        utilityLogger.info("  Main course Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(mainCourse , MAIN_COURSE_FILE)) {
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        continue;
                                                    }

                                                    break planningloop;
                                                }
                                            case "6":
                                                displayFileContents(DESERT_FILE);
                                                while (true) {
                                                    utilityLogger.info("Enter Desert Name:");
                                                    desert  = scanner.nextLine();
                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(desert )) {
                                                        utilityLogger.info("  Dessert Name field is required ! \n");
                                                        continue;
                                                    } else if (!userMyApp.checkFile(desert , DESERT_FILE)) {
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                        utilityLogger.info(SPACE_SEPARATOR);
                                                        continue;
                                                    }

                                                    break planningloop;
                                                }
                                            case "7":
                                                int UserProfitDj = 0;
                                                int UserProfitstudio = 0;
                                                if (!Objects.equals(hallName, null)) {
                                                    AddtoEvent("HallName: ", hallName);
                                                    UserProfit +=  getColumnValueForHall(HALL_PATH , hallName, 2);
                                                }

                                                if (!Objects.equals(djName, null)) {
                                                    AddtoEvent("Dj: ", djName);
                                                    UserProfitDj =  getColumnValueForHall( DJ_FILE, djName, 1);
                                                }


                                                if (!Objects.equals(studioName , null)) {
                                                    AddtoEvent("Studio: ", studioName );
                                                    UserProfitstudio =  getColumnValueForHall(STUDIO_FILE, studioName , 1);
                                                }

                                                if (!Objects.equals(flowerName , null)) {
                                                    AddtoEvent("Flower: ", flowerName );
                                                    UserProfit +=  getColumnValueForHall(FLOWER_FILE, flowerName , 1);//
                                                }

                                                if (!Objects.equals(mainCourse , null)) {
                                                    AddtoEvent("Maincourse: ", mainCourse );
                                                    UserProfit +=  getColumnValueForHall(MAIN_COURSE_FILE, mainCourse , 1);//
                                                }
                                                if (!Objects.equals(desert , null)) {
                                                    AddtoEvent("Desert: ", desert );
                                                    UserProfit +=  getColumnValueForHall(DESERT_FILE, desert , 1);//
                                                }

                                                if (!Objects.equals(djName, null)) {
                                                    utilityLogger.info("\nThe amount you should pay for Dj : " + UserProfitDj);
                                                }

                                                if (!Objects.equals(studioName , null)) {
                                                    utilityLogger.info("\nThe amount you should pay for studio : " + UserProfitstudio);
                                                }

                                                utilityLogger.info("\nTotal amount you should pay for Provider="+UserProfit);
                                                utilityLogger.info("\nTo complete the order , please pay ! \n");

                                                while (true){
                                                    utilityLogger.info(ENTER_CARD_NUMBER_MSG);
                                                    paypage = scanner.nextLine();

                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage) ) {
                                                        utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                        continue ;
                                                    }
                                                    else   if (payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberStartingWith(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(paypage)) {
                                                        utilityLogger.info(VALID_NUMBER_MSG);
                                                        continue ;
                                                    }

                                                    else {
                                                        while (true) {
                                                            utilityLogger.info(ENTER_CARD_OWNER_NAME_MSG);
                                                            paypage = scanner.nextLine();
                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(paypage)) {
                                                                utilityLogger.info(CARD_OWNER_NAME_REQUIRED_MSG);
                                                                continue;
                                                            } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(paypage)) {
                                                                utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                                continue;
                                                            } else {
                                                                while (true) {
                                                                    utilityLogger.info(ENTER_CVC_MSG);
                                                                    paypage = scanner.nextLine();
                                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage)) {
                                                                        utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                                        continue;
                                                                    } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(paypage) || payPageMyApp.theUserSubmitsThePaymentFormWithACVCStartingWith(paypage)) {
                                                                        utilityLogger.info(VALID_CVC_MSG);
                                                                        continue;
                                                                    } else {
                                                                        utilityLogger.info(PAYMENT_SUCCESSFUL_MSG);
                                                                        utilityLogger.info("Saved correctly \n");
                                                                        b =  storeProviderData(username, password);
                                                                        break;
                                                                    }
                                                                }

                                                                break;
                                                            }
                                                        }
                                                        break ; }
                                                }

                                                AddtoEvent(SEPARATOR_LINE,SEPARATOR_LINE);
                                                break innerWhile;

                                            case "8":
                                                utilityLogger.info("Going back to the main menu \n");
                                                break innerWhile;

                                            default:
                                                utilityLogger.info(UN_VALID_OPTION_MSG);
                                        }
                                    }
                                    break;

                                case "3":
                                    caseLabel:
                                    utilityLogger.info("choose : \n 1. select the package and choose according to the price that suits you !\n "
                                            + " 2. Enter the price you have so we can show you prices that are closet to  the packages !");

                                    int x =scanner.nextInt();
                                    if (x==1){
                                        displayFileContents(PACKAGE_FILE );
                                        while (true) {
                                            utilityLogger.info("Enter Package name:");
                                            Scanner sc =new Scanner(System.in);
                                            Pname = sc.nextLine();

                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(Pname)) {
                                                utilityLogger.info("  Packge Name field is required ! \n");
                                                continue;
                                            } else if (!userMyApp.checkFile(  Pname, PACKAGE_FILE )) {
                                                utilityLogger.info(SPACE_SEPARATOR);
                                                utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                utilityLogger.info(SPACE_SEPARATOR);
                                                continue;
                                            }
                                            else {
                                                HallProfitUpdaterPackage.updateOrPrintProfitsPackage(  Pname);
                                                if ( Pname != null && ! Pname.trim().isEmpty()) {
                                                    String finalPackgName =  Pname;
                                                    SwingUtilities.invokeLater(() -> new YearlyBookingCalendarPachage( finalPackgName.trim()));
                                                }
                                                utilityLogger.info("Total amount u should pay to provider =" + UserProfit);
                                                utilityLogger.info("To complete the order , please pay !");
                                                while (true){
                                                    utilityLogger.info(ENTER_CARD_NUMBER_MSG);
                                                    paypage = scanner11.nextLine();

                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage) ) {
                                                        utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                        continue ;
                                                    }
                                                    else   if (payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberStartingWith(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(paypage)) {
                                                        utilityLogger.info(VALID_NUMBER_MSG);
                                                        continue ;
                                                    }

                                                    else {
                                                        while (true) {
                                                            utilityLogger.info(ENTER_CARD_OWNER_NAME_MSG);
                                                            paypage = scanner11.nextLine();
                                                            if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(paypage)) {
                                                                utilityLogger.info(CARD_OWNER_NAME_REQUIRED_MSG);
                                                                continue;
                                                            } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(paypage)) {
                                                                utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                                continue;
                                                            } else {
                                                                while (true) {
                                                                    utilityLogger.info(ENTER_CVC_MSG);
                                                                    paypage = scanner11.nextLine();
                                                                    if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage)) {
                                                                        utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                                        continue;
                                                                    } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(paypage) || payPageMyApp.theUserSubmitsThePaymentFormWithACVCStartingWith(paypage)) {
                                                                        utilityLogger.info(VALID_CVC_MSG);
                                                                        continue;
                                                                    } else {
                                                                        utilityLogger.info(PAYMENT_SUCCESSFUL_MSG);
                                                                        utilityLogger.info("Saved correctly");
                                                                        b =  storeProviderData(username, password);
                                                                        break;
                                                                    }
                                                                }

                                                                break;
                                                            }
                                                        }
                                                        break ; }
                                                }

                                                AddtoEvent("Package: ",Pname);
                                                UserProfit = getColumnValueForHall(PACKAGE_FILE , Pname, 1);//
                                                AddtoEvent(SEPARATOR_LINE,SEPARATOR_LINE);


                                                break outerWhile;
                                            }

                                        }

                                    }


                                    else {

                                        utilityLogger.info("Enter the budget that suits you : ");
                                        Scanner scanner111 = new Scanner(System.in) ;
                                        int budget =scanner111.nextInt() ;


                                        while (true) {
                                            packgCount=checkPrise(PACKAGE_FILE ,budget,1);
                                            if(packgCount==0){
                                                utilityLogger.info("Sorry, There is no suitable package.");
                                                break outerWhile;
                                            }
                                            else {
                                                utilityLogger.info("Choose the Package name :");
                                                Scanner scanner4 = new Scanner(System.in);
                                                String name = scanner4.nextLine();
                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(name)) {
                                                    utilityLogger.info(PACKAGE_NAME_REQ );
                                                    continue;
                                                } else if (!userMyApp.checkFile(name, "Package.txt ")) {
                                                    utilityLogger.info(SPACE_SEPARATOR);
                                                    utilityLogger.info(NAME_NOT_IN_LIST_MSG);
                                                    utilityLogger.info(SPACE_SEPARATOR);
                                                    continue;
                                                } else {

                                                    HallProfitUpdaterPackage.updateOrPrintProfitsPackage(  name);
                                                    if (name != null && !name.trim().isEmpty()) {
                                                        String finalPackgName =  name;
                                                        SwingUtilities.invokeLater(() -> new YearlyBookingCalendarPachage( finalPackgName.trim()));
                                                    }

                                                    UserProfit = getColumnValueForHall(PACKAGE_FILE ,name,1);
                                                    utilityLogger.info("Total amount u should pay to provider =" + UserProfit);
                                                    utilityLogger.info("To complete the order , please pay !");

                                                    while (true){
                                                        utilityLogger.info(ENTER_CARD_NUMBER_MSG);
                                                        paypage = scanner11.nextLine();

                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage) ) {
                                                            utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                            continue ;
                                                        }
                                                        else   if (payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberStartingWith(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberThatIsNotOrDigitsLong(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACardNumberContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(paypage)) {
                                                            utilityLogger.info(VALID_NUMBER_MSG);
                                                            continue ;
                                                        }

                                                        else {
                                                            while (true) {
                                                                utilityLogger.info(ENTER_CARD_OWNER_NAME_MSG);
                                                                paypage = scanner11.nextLine();
                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(paypage)) {
                                                                    utilityLogger.info(CARD_OWNER_NAME_REQUIRED_MSG);
                                                                    continue;
                                                                } else if (payPageMyApp.theUserSubmitsThePaymentFormWithNonLetterCharactersInTheCardOwnerSNameField(paypage)) {
                                                                    utilityLogger.info(ENTER_VALID_NAME_MSG);
                                                                    continue;
                                                                } else {
                                                                    while (true) {
                                                                        utilityLogger.info(ENTER_CVC_MSG);
                                                                        paypage = scanner11.nextLine();
                                                                        if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringACardNumber(paypage)) {
                                                                            utilityLogger.info(CARD_NUMBER_REQUIRED_MSG);
                                                                            continue;
                                                                        } else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(paypage) || payPageMyApp.theUserSubmitsThePaymentFormWithACVCStartingWith(paypage)) {
                                                                            utilityLogger.info(VALID_CVC_MSG);
                                                                            continue;
                                                                        } else {
                                                                            utilityLogger.info(PAYMENT_SUCCESSFUL_MSG);
                                                                            utilityLogger.info("Saved correctly");
                                                                            b =  storeProviderData(username, password);
                                                                            break;
                                                                        }
                                                                    }

                                                                    break;
                                                                }
                                                            }
                                                            break ; }
                                                    }
                                                    AddtoEvent("Package Name ", name);
                                                    AddtoEvent("Price =", String.valueOf( getColumnValueForHall(PACKAGE_FILE , name, 1)));
                                                    AddtoEvent(SEPARATOR_LINE, SEPARATOR_LINE);

                                                }
                                                break outerWhile;
                                            }
                                        }

                                    }



                                case "4":
                                    utilityLogger.info(LOGOUT_MSG );

                                    break outerWhile1;
                                default:
                                    utilityLogger.info(UN_VALID_OPTION_MSG);
                            }
                        }
                    } else {
                        utilityLogger.info("Wrong username or password !");
                        continue ;
                    }
                }
            }
        }
    }

    public static void displayFileContents(String filePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;


            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {

            utilityLogger.warning(EXCEPTION_MESSAGE );
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    utilityLogger.warning(EXCEPTION_MESSAGE );
                }
            }
        }
    }
    public static void AddtoEvent(String name, String item) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Event.txt", true));
            writer.write(name + item);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error closing the writer: " + e.getMessage());
                }
            }
        }
    }
    public static int getColumnValueForHall(String filePath, String hallName, int columnIndex) throws IOException {
        Path path = Paths.get(filePath);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path.toFile()));
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                for (String column : columns) {
                    if (column.trim().equals(hallName)) {
                        if (columnIndex < columns.length) {
                            return Integer.parseInt(columns[columnIndex].trim());
                        } else {
                            throw new IllegalArgumentException("Column index is out of bounds");
                        }
                    }
                }
            }

            throw new IllegalArgumentException("Hall " + hallName + " not found in file");
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
    public static int checkPrise(String filename, int value, int columnIndex) throws IOException {
        BufferedReader reader = null;
        int counter = 0;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > columnIndex) {
                    int columnValue = Integer.parseInt(parts[columnIndex].trim());
                    if (columnValue <= value) {
                        System.out.println(line);
                        counter++;
                    }
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return counter;
    }
    public static void searchValueInFile(String filePath, String searchValue) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String valueToSearch = parts[parts.length - 1];
                if (valueToSearch.equals(searchValue)) {
                    System.out.println(line);

                }
            }
        } catch (IOException e) {
            System.err.println("حدث خطأ أثناء قراءة الملف: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("حدث خطأ أثناء إغلاق الملف: " + e.getMessage());
                }
            }
        }
    }
    public static int Counts(String fileName) throws IOException {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lineCount++;
                }
            }
        } catch (IOException e) {
            utilityLogger.warning(EXCEPTION_MESSAGE );
        }
        return lineCount;
    }
    public static boolean storeProviderData(String username, String password ) {

        try (FileWriter fileWriter = new FileWriter("provider_data.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(  username + "," + password );
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
        return false;
    }

    public static void handleIOException(String message, IOException e) throws IOException {
        utilityLogger.severe(message + e.getMessage());
        throw new IOException(message + e.getMessage());
    }
}
