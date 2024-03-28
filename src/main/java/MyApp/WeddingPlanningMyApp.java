import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class WeddingPlanningMyApp {

    private static final Logger logger = Logger.getLogger(WeddingPlanningMyApp.class.getName());

    public static boolean isChickIfExist(String maincourse, String file) {
        Path filePath = Paths.get(file);

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                String[] hallAttributes = line.split(",");

                if (hallAttributes.length > 0 && hallAttributes[0].trim().equals(maincourse.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            logger.severe("Error reading file: " + e.getMessage());
        }

        return false;
    }

    public static boolean reserveOnFile(String maincourse, String file) {
        Path inputFile = Paths.get(file);
        Path outputFile = Paths.get("Reservations.txt");

        try {
            List<String> lines = Files.readAllLines(inputFile);
            for (String line : lines) {
                String[] hallAttributes = line.split(",");

                if (hallAttributes.length > 0 && hallAttributes[0].trim().equals(maincourse.trim())) {
                    Files.write(outputFile, (line + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    logger.info("Reservation for " + maincourse + " recorded in Reservations.txt");
                    return true;
                }
            }

            logger.warning("Wedding hall named " + maincourse + " not found in Halls.txt");

        } catch (IOException e) {
            logger.severe("Error writing reservation: " + e.getMessage());
        }

        return false;
    }

    public static boolean reserveAndPrint(String hall, String file, String date, int numberOfAttributesToPrint) {
        Path inputFile = Paths.get(file);
        Path outputFile = Paths.get("Reservations.txt");

        try {
            List<String> lines = Files.readAllLines(inputFile);
            for (String line : lines) {
                String[] hallAttributes = line.split(",");

                if (hallAttributes.length > 0 && hallAttributes[0].trim().equals(hall.trim())) {
                    StringBuilder outputLine = new StringBuilder();
                    for (int i = 0; i < Math.min(numberOfAttributesToPrint, hallAttributes.length); i++) {
                        outputLine.append(hallAttributes[i].trim()).append(",");
                    }

                    outputLine.append(date.trim()).append(",");

                    Files.write(outputFile, (outputLine.toString() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                    logger.info("Reservation for " + hall + " on " + date + " recorded in Reservations.txt");
                    return true;
                }
            }

            logger.warning("Wedding hall named " + hall + " not found in Halls.txt");

        } catch (IOException e) {
            logger.severe("Error writing reservation and printing: " + e.getMessage());
        }

        return false;
    }

    public boolean checkHallAndDate(String hallname, String date, String file) {
        String filePath = "ReservationHalls.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedHallName = parts[0].trim();
                String storedReservationDate = parts[1].trim();

                if (hallname.equals(storedHallName) && date.equals(storedReservationDate)) {
                    return true;
                }
            }
        } catch (IOException e) {
            logger.severe("Error reading reservation: " + e.getMessage());
        }

        return false;
    }
}
