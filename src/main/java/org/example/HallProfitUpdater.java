package org.example;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HallProfitUpdater {

    public static void updateOrPrintProfits(String hallName) {
        String hallsFilePath = "Halls.txt";
        String profitsFilePath = "profits.txt";
        Map<String, Integer> profitMap = new HashMap<>();

        // Attempt to load existing profits from the file
        try (BufferedReader profitReader = new BufferedReader(new FileReader(profitsFilePath))) {
            String line;
            while ((line = profitReader.readLine()) != null) {
                String[] parts = line.split(",");
                // Ensure we have at least two parts: a key (name) and a value (price)
                if (parts.length >= 2) {
                    profitMap.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Profits file not found. A new one will be created.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the profits file.");
            e.printStackTrace();
        }

        // Process the Halls.txt file
        try (BufferedReader hallReader = new BufferedReader(new FileReader(hallsFilePath))) {
            String line;
            while ((line = hallReader.readLine()) != null) {
                String[] parts = line.split(",");
                // Ensure the row has enough parts to avoid ArrayIndexOutOfBoundsException
                if (parts[0].equalsIgnoreCase(hallName) && parts.length >= 5) {
                    String name = parts[4].trim(); // Name is in the 5th position
                    int price = Integer.parseInt(parts[2].trim()); // Price is in the 3rd position
                    profitMap.merge(name, price, Integer::sum); // Sum the price if name exists
                    break; // Assuming you only need the first match
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the Halls file.");
            e.printStackTrace();
        }

        // Write the updates or new entries back to the profits.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter(profitsFilePath))) {
            profitMap.forEach((key, value) -> writer.println(key + "," + value));
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the profits file.");
            e.printStackTrace();
        }
    }
}