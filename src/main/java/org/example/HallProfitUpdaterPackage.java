package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class HallProfitUpdaterPackage {

    private static final Logger logger = Logger.getLogger(HallProfitUpdaterPackage.class.getName());

    public static void updateOrPrintProfitsPackage(String hallName) {
        String hallsFilePath = "Package.txt";
        String profitsFilePath = "profitsPackage.txt";
        Map<String, Integer> profitMap = readProfitMapFromFile(profitsFilePath);

        try (BufferedReader hallReader = new BufferedReader(new FileReader(hallsFilePath))) {
            String line;
            while ((line = hallReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) { // Ensure the line has enough parts to avoid ArrayIndexOutOfBoundsException
                    String name = parts[0].trim(); // Corrected index
                    int price = Integer.parseInt(parts[1].trim());
                    String hall = parts[2].trim(); // Corrected index
                    if (hall.equalsIgnoreCase(hallName)) { profitMap.merge(name, price, Integer::sum);
                      
                    }
                }
            }
        } catch (IOException e) { logger.severe("An error occurred while reading the Halls file: " + e.getMessage());
       
        }

        writeProfitMapToFile(profitsFilePath, profitMap);
    }

    private static Map<String, Integer> readProfitMapFromFile(String filePath) {
        Map<String, Integer> profitMap = new HashMap<>();
        try (BufferedReader profitReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = profitReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    profitMap.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                }
            }
        } catch (FileNotFoundException e) { logger.warning("Profits file not found. A new one will be created."); } catch (IOException e) {
           
     
         
        }
        return profitMap;
    }

    private static void writeProfitMapToFile(String filePath, Map<String, Integer> profitMap) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            profitMap.forEach((key, value) -> writer.println(key + "," + value));
        } catch (IOException e) {  logger.severe("An error occurred while writing to the profits file: " + e.getMessage());
       
        }
    }
}
