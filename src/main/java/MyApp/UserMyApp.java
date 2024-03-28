package MyApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserMyApp {
    private static final Logger logger = LogManager.getLogger(UserMyApp.class);
    private static final String ERROR_READING_FILE = "Error reading the file: {}";
    private static final String ERROR_CLOSING_READER = "Error closing the reader: {}";

    public static void displayFileContents(String filePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE, e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
    }

    public static boolean checkFile(String filename, String typeEvent, String eventName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
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
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE, e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
        return false;
    }

    public static boolean checkHallandDate(String fileName, String date, String eventName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
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
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE, e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
        return false;
    }

    public static void AddtoEvent(String name, String item) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Event.txt", true));
            writer.write(name + item);
            writer.newLine();
        } catch (IOException e) {
            logger.error("Error writing to the file: {}", e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
    }

    public static boolean checkFile(String word, String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE, e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
        return false;
    }

    public static void addPackageToFile(String packageName, String filename) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(packageName);
            writer.newLine();
            logger.info("Package '{}' added to file '{}'", packageName, filename);
        } catch (IOException e) {
            logger.error("Error occurred while writing to file: {}", e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
    }

    public static int getColumnValueForHall(String filePath, String hallName, int columnIndex) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                for (String column : columns) {
                    if (column.trim().equals(hallName)) {
                        if (columnIndex < columns.length) {
                            return Integer.parseInt(columns[columnIndex].trim());
                        } else {
                            throw new IllegalArgumentException("Column index is out of bounds");
                        }
                    }
                }
            }
            throw new IllegalArgumentException("Hall " + hallName + " not found in file");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
    }

    public static int checkPrise(String filename, int value, int columnIndex) throws IOException {
        BufferedReader reader = null;
        int counter = 0;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > columnIndex) {
                    int columnValue = Integer.parseInt(parts[columnIndex].trim());
                    if (columnValue <= value) {
                        logger.info(line);
                        counter++;
                    }
                }
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
        return counter;
    }

    public static boolean deleteLineFromFile(String name, String filename) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        File inputFile = new File(filename);
        File tempFile = new File("temp.txt");
        boolean deleted = false;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(name)) {
                    deleted = true;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            logger.error("Error occurred while deleting line from file: {}", e.getMessage());
            return false;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.error(ERROR_CLOSING_READER, e.getMessage());
            }
        }
        if (deleted) {
            if (!inputFile.delete()) {
                logger.error("Could not delete the original file.");
                return false;
            }
            if (!tempFile.renameTo(inputFile)) {
                logger.error("Could not rename the temp file.");
                return false;
            }
            logger.info("Line containing '{}' deleted from file '{}'", name, filename);
        }
        return deleted;
    }

    public static void searchValueInFile(String filePath, String searchValue) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String valueToSearch = parts[parts.length - 1];
                if (valueToSearch.equals(searchValue)) {
                    logger.info(line);
                }
            }
        } catch (IOException e) {
            logger.error(ERROR_READING_FILE, e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.error(ERROR_CLOSING_READER, e.getMessage());
                }
            }
        }
    }
}
