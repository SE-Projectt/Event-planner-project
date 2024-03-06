package MyApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WeddingPlanningMyApp {

    public static boolean isChickIfExist(String maincourse,String file) {
        // Specify the path to the Halls.txt file
        Path filePath = Paths.get(file);

        try {
            // Read all lines from the file into a List
            List<String> lines = Files.readAllLines(filePath);

            // Iterate through the lines to find the wedding hall
            for (String line : lines) {
                // Split the line by comma to get individual attributes
                String[] hallAttributes = line.split(",");

                // Check if the first attribute (hall name) matches the provided name
                if (hallAttributes.length > 0 && hallAttributes[0].trim().equals(maincourse.trim())) {
                    return true; // Hall name found, return true
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Hall name not found, return false
    }
    public static boolean reserveOnFile(String maincourse,String file) {
        Path inputFile = Paths.get(file);
        Path outputFile = Paths.get("Reservations.txt");

        try {
            List<String> lines = Files.readAllLines(inputFile);
            for (String line : lines) {
                String[] hallAttributes = line.split(",");

                // Check if the first attribute (hall name) matches the provided name
                if (hallAttributes.length > 0 && hallAttributes[0].trim().equals(maincourse.trim())) {
                    // Append the matching line to the output file
                    Files.write(outputFile, (line + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Reservation for " + maincourse + " recorded in Reservations.txt");
                    return true; // Return true if the reservation is successful
                }
            }

            // If the hall name is not found, display a message
            System.out.println("Wedding hall named " + maincourse + " not found in Halls.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Return false if the reservation is not successful
    }
    /////////////////////////////////////////////////////////

    ////////////// انا ضفته عشان اقدر اطبع معلومات اي اشي حسب العدد الي بعطيه اياه للمعلومات + بطبع التاريخ المطلوب فقط
    public static boolean reserveAndPrint(String hall, String file, String date, int numberOfAttributesToPrint) {
        Path inputFile = Paths.get(file);
        Path outputFile = Paths.get("Reservations.txt");

        try {
            List<String> lines = Files.readAllLines(inputFile);
            for (String line : lines) {
                String[] hallAttributes = line.split(",");

                // Check if the first attribute (hall name) matches the provided name
                if (hallAttributes.length > 0 && hallAttributes[0].trim().equals(hall.trim())) {
                    // Append the specified number of attributes to the output file
                    StringBuilder outputLine = new StringBuilder();
                    for (int i = 0; i < Math.min(numberOfAttributesToPrint, hallAttributes.length); i++) {
                        outputLine.append(hallAttributes[i].trim()).append(",");
                    }

                    // Append the provided date to the output file
                    outputLine.append(date.trim()).append(",");

                    Files.write(outputFile, (outputLine.toString() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Reservation for " + hall + " on " + date + " recorded in Reservations.txt");
                    return true; // Return true if the reservation is successful
                }
            }

            // If the hall name is not found, display a message
            System.out.println("Wedding hall named " + hall + " not found in Halls.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Return false if the reservation is not successful
    }

///////////////////////////عشان افحص اذا القاعة محجوزة او لا +أستأجرها
////////////////////////////////

    public boolean checkHallAndDate(String hallname, String date, String file) {
        String filePath = "ReservationHalls.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedHallName = parts[0].trim();
                String storedReservationDate = parts[1].trim();

                if (hallname.equals(storedHallName) && date.equals(storedReservationDate)) {
                    return true; // Reservation found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


}
