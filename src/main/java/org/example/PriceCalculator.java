package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PriceCalculator {
    public static double calculateTotalPrice(String file1, String file2, String username) {
        double totalPrice = 0.0;

        try {
            totalPrice += getPriceFromFile(file1, username);
            totalPrice += getPriceFromFile(file2, username);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalPrice;
    }

    private static double getPriceFromFile(String filename, String username) throws IOException {
        double price = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String currentUsername = parts[0].trim();
                    if (currentUsername.equals(username)) {
                        try {
                            price += Double.parseDouble(parts[1].trim());
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid price format for username: " + username);
                        }
                    }
                }
            }
        }
        return price;
    }
}
