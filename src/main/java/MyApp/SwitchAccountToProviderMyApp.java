package MyApp;
import java.io.*;

public class SwitchAccountToProviderMyApp {

    public static boolean thisUsernamePasswordHaveAccessToBeProvider(String username, String password) {
        boolean found = false;
        String filename = "provider_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        found = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found;
    }

    public static boolean storeProviderData(String username, String password) {

        try (FileWriter fileWriter = new FileWriter("provider_data.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Append the username and password to the file
            printWriter.println(username + "," + password);

            System.out.println("Provider data stored successfully!");
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
        return false;
    }


}
