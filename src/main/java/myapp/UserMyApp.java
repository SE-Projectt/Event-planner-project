package myapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class UserMyApp {
    private static final String FILE_NOT_FOUND_ERROR_MESSAGE = "File not found: {}";
    private static final String ERROR_READING_FILE_MESSAGE = "Error reading file: {}";

    private static final Logger logger = LogManager.getLogger(UserMyApp.class);

    public static boolean checkFile(String filename, String typeEvent, String eventName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String currentTypeEvent = parts[0].trim();
                    String currentEventName = parts[1].trim();
                    if (currentTypeEvent.equals(typeEvent) && currentEventName.equals(eventName)) {
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(FILE_NOT_FOUND_ERROR_MESSAGE, filename);
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE_MESSAGE, filename);
        }
        return false;
    }

    public static boolean checkHallAndDate(String fileName, String date, String eventName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].trim().equals(eventName)) {
                    String fileDate = parts[1].trim();
                    if (fileDate.equals(date)) {
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(FILE_NOT_FOUND_ERROR_MESSAGE, fileName);
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE_MESSAGE, fileName);
        }
        return false;
    }

    public static boolean checkFile(String word, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(word)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(FILE_NOT_FOUND_ERROR_MESSAGE, filename);
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE_MESSAGE, filename);
        }
        return false;
    }

    public static void addPackageToFile(String packageName, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(packageName);
            writer.newLine();
            logger.info("Package '{}' added to file '{}'", packageName, filename);
        } catch (IOException e) {
            logger.error("Error writing to file: {}", filename);
        }
    }

    public static boolean deleteLineFromFile(String name, String filename) {
        File inputFile = new File(filename);
        File tempFile = new File("temp.txt");
        boolean deleted = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(name)) {
                    deleted = true;
                    continue;
                }
                writer.write(currentLine);
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            logger.error(FILE_NOT_FOUND_ERROR_MESSAGE, filename);
        } catch (IOException e) {
            logger.error("Error reading/writing file: {}", filename);
        }
        if (deleted) {
            if (!inputFile.delete()) {
                logger.error("Could not delete the original file: {}", filename);
                return false;
            }
            if (!tempFile.renameTo(inputFile)) {
                logger.error("Could not rename the temp file: {}", filename);
                return false;
            }
            logger.info("Line containing '{}' deleted from file '{}'", name, filename);
        }
        return deleted;
    }
}
