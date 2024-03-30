package MyApp;

import java.util.logging.Logger;


public class LoginMyApp {
    private static final String MY_A = "Zaid";
    private static final String MY_P = "123456";
    private static final Logger logger = Logger.getLogger(LoginMyApp.class.getName());



    public static boolean iEnterUsernameAndPassword(String adminname, String pata) {
        return adminname.equals(MY_A) && pata.equals(MY_P);
    }
}
