package org.example;
import Entity.PayInformation;
import MyApp.LoginMyApp;
import MyApp.PayPageMyApp;
import MyApp.SignUpMyApp;
import MyApp.SwitchAccountToProviderMyApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SignUpMyApp myApp = new SignUpMyApp();
        SwitchAccountToProviderMyApp switchAccountToProviderMyApp=new SwitchAccountToProviderMyApp() ;
        PayPageMyApp payPageMyApp=new PayPageMyApp();
        PayInformation payInformation =new PayInformation();
        LoginMyApp loginMyApp = new LoginMyApp();
        Scanner scanner = new Scanner(System.in);
        String username, password, option1, useroption,Paypage, HallName,HallCapacity,HallPrice,HallLocation;
        boolean b =false;

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
                System.out.println("Welcome to Fiesta App, please enter your username and password.");
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
                        System.out.println("Login successfully As Admin");
                        break;
                    } else if (loginMyApp.theSystemHasRegisteredUserWithUsernameAndPassword(username, password)) {
                        System.out.println("Login successfully");

                        while (true) {
                            System.out.println("Choose: \n 1. Switch account to Provider account \n 2. Start Planning to wedding from zero \n 3. Select package \n 4. Logout");
                            useroption = scanner.nextLine();
                            outerWhile :
                            switch (useroption) {
                                case "1":
                                    System.out.println("Switching to Provider account");
                                    if (switchAccountToProviderMyApp.thisUsernamePasswordHaveAccessToBeProvider(username,password)) {
                                        System.out.println("Welcome To Provider Page");

                                        while (true) {
                                            System.out.println("Choose: \n 1. Switch account to User account \n 2. Add Halls Wedding \n 3. Delete Halls Wedding \n 4. Select package  ");
                                            useroption = scanner.nextLine();
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

                                                        else {
                                                            while (true) {
                                                                System.out.println("Enter Hall Capacity : ");
                                                                HallCapacity = scanner.nextLine();
                                                                if (payPageMyApp.theUserSubmitsThePaymentFormWithoutEnteringTheCardOwnerSName(HallCapacity)) {
                                                                    System.out.print("Hall capacity field is required ! \n");
                                                                    continue;
                                                                } else if (! payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(HallCapacity)) {
                                                                    System.out.print("Enter a Valid Capacity ! \n");
                                                                    continue;
                                                                }
                                                                else if (!payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(HallCapacity)) {
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
                                                                        } else if ( !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCardNumberField(HallPrice) ) {
                                                                            System.out.print("Enter a Valid Hall Price ! \n");
                                                                            continue;
                                                                        }
                                                                        else if ( !payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(HallPrice) ) {
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
                                                                                else {System.out.print("Adding Hall successful ! \n");

                                                                                     break ; }
                                                                            }

                                                                            break ;   }
                                                                       // else {System.out.print("Payment was successful ! \n");
                                                                          //  b=switchAccountToProviderMyApp.storeProviderData(username,password);
                                                                           // break ; }
                                                                    }

                                                                    break ; }

                                                            }
                                                            break ; }

                                                    }
                                                    //////////////////
                                                    break ;
                                                case "3":
                                                    break ;
                                                case"4":
                                                    break ;

                                            }

                                        }

                                    }


                                    else {
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
                                                            } else if ( !payPageMyApp.theUserSubmitsThePaymentFormWithANonPositiveNumberInTheCVCField(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCContainingLetters(Paypage) || !payPageMyApp.theUserSubmitsThePaymentFormWithACVCThatIsNotDigitsLong(Paypage) || payPageMyApp.theUserSubmitsThePaymentFormWithACVCStartingWith(Paypage)) {
                                                                System.out.print("Enter a Valid CVC Number ! \n");
                                                                continue;
                                                            }
                                                            else {System.out.print("Payment was successful ! \n");
                                                                b=switchAccountToProviderMyApp.storeProviderData(username,password);
                                                                break ; }
                                                        }

                                                        break ; }

                                                }
                                                break ; }

                                        }
                                        break;  }

                                case "2":
                                    System.out.println("Let's Go to wedding planning !");
                                    innerWhile:
                                    while (true) {
                                        System.out.println("Choose: \n 1. Wedding Halls  \n 2. Hire a DJ  \n 3. Photography Studio \n " +
                                                "4. Flowers \n 5. Main course \n 6. Dessert \n 7. Back to the previous page   ");
                                        option1 = scanner.nextLine();
                                        switch (option1) {
                                            case "1":
                                                // Add your logic for Wedding Halls
                                                break;
                                            case "2":
                                                // Add your logic for Hiring a DJ
                                                break;
                                            case "3":
                                                // Add your logic for Photography Studio
                                                break;
                                            case "4":
                                                // Add your logic for Flowers
                                                break;
                                            case "5":
                                                // Add your logic for Main course
                                                break;
                                            case "6":
                                                // Add your logic for Dessert
                                                break;
                                            case "7":
                                                System.out.println("Going back to the main menu");
                                                break innerWhile;
                                            default:
                                                System.out.println("Invalid option. Please try again.");
                                        }
                                    } // end inner while loop
                                    break;
                                case "3":
                                    System.out.println("Selecting package");
                                    // Add your logic for selecting a package
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