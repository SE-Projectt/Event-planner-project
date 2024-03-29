package org.example;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
public class HallProfitUpdater {
    private static final Logger logger = Logger.getLogger(HallProfitUpdater.class.getName());
    public static void updateOrPrintProfits(String hallName) {
        String hallsFilePath = "Halls.txt";
        String profitsFilePath = "profits.txt";
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
            logger.warning("Profits file not found. A new one will be created.");
        } catch (IOException e) {
            logger.severe("An error occurred while reading the profits file."); 
        }
        try (BufferedReader hallReader = new BufferedReader(new FileReader(hallsFilePath))) {
            String line;
            while ((line = hallReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equalsIgnoreCase(hallName) && parts.length >= 5) {
                    String name = parts[4].trim();
                    int price = Integer.parseInt(parts[2].trim());
                    profitMap.merge(name, price, Integer::sum);
                    break;
                }
            }
        } catch (IOException e) {
            logger.severe("An error occurred while reading the Halls file.");
           
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(profitsFilePath))) {
            profitMap.forEach((key, value) -> writer.println(key + "," + value));
            
        } catch (IOException e) {
            logger.severe("An error occurred while writing to the profits file.");
            /
        }
    }
}
