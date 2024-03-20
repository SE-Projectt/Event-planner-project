package org.example;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HallProfitUpdaterPackage {
    public static void updateOrPrintProfitsPackage(String hallName) {
        String hallsFilePath = "Package.txt";
        String profitsFilePath = "profitsPackage.txt";
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
                if (parts[0].equalsIgnoreCase(hallName)) {
                    // The name is always the last element in the parts array
                    String name = parts[parts.length - 1].trim();
                    // The price is always the second element
                    int price = Integer.parseInt(parts[1].trim());
                    profitMap.merge(name, price, Integer::sum); // Sum the price if the name exists
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
