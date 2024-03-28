package org.example;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class HallProfitUpdaterPackage {
    private static final Logger logger = Logger.getLogger(HallProfitUpdaterPackage.class.getName());

    public static void updateOrPrintProfitsPackage(String hallName) {
        String hallsFilePath = "Package.txt";
        String profitsFilePath = "profitsPackage.txt";
        Map<String, Integer> profitMap = new HashMap<>();

        try (BufferedReader profitReader = new BufferedReader(new FileReader(profitsFilePath))) {
            String line;
            while ((line = profitReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    profitMap.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            logger.info("Profits file not found. A new one will be created.");
        } catch (IOException e) {
            logger.severe("An error occurred while reading the profits file.");
        }

        try (BufferedReader hallReader = new BufferedReader(new FileReader(hallsFilePath))) {
            String line;
            while ((line = hallReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equalsIgnoreCase(hallName)) {
                    String name = parts[parts.length - 1].trim();
                    int price = Integer.parseInt(parts[1].trim());
                    profitMap.merge(name, price, Integer::sum);
                }
            }
        } catch (IOException e) {
            logger.severe("An error occurred while reading the Halls file.");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(profitsFilePath))) {
            profitMap.forEach((key, value) -> writer.println(key + "," + value));
        } catch (IOException e) {
            logger.severe("An error occurred while writing to the profits file.");
        }
    }
}
