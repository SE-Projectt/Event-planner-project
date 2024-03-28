package MyApp;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class UserMyApp {
    public static void displayFileContents(String filePath) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
            System.err.println("Error writing to the file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error closing the writer: " + e.getMessage());
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
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
            System.out.println("Package '" + packageName + "' added to file '" + filename + "'");
        } catch (IOException e) {
            System.err.println("Error occurred while writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error closing the writer: " + e.getMessage());
                }
            }
        }
    }



    public static int getColumnValueForHall(String filePath, String hallName, int columnIndex) throws IOException {
        Path path = Paths.get(filePath);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path.toFile()));
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
                br.close();
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
                        System.out.println(line);
                        counter++;
                    }
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
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
            System.err.println("Error occurred while deleting line from file: " + e.getMessage());
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
                System.err.println("Error closing file streams: " + e.getMessage());
            }
        }


        if (deleted) {
            if (!inputFile.delete()) {
                System.out.println("Could not delete the original file.");
                return false;
            }

            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename the temp file.");
                return false;
            }
            System.out.println("Line containing '" + name + "' deleted from file '" + filename + "'");
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
                    System.out.println(line);

                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file: " + e.getMessage());
                }
            }
        }
    }

}
