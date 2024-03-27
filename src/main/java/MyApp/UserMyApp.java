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
        try {
            // Open the file
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            // Read each line and display it
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

         
            bufferedReader.close();
        } catch (IOException e) {
            
        
        }
    }

    public static boolean checkFile(String filename, String typeEvent, String eventName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
               
                String[] parts = line.split(":");
                if (parts.length == 2) {
                 
                    String currentTypeEvent = parts[0].trim();
                    String currentEventName = parts[1].trim();
                  
                    if (currentTypeEvent.equals(typeEvent)) {
                      
                        if (currentEventName.equals(eventName)) {
                            return true; 
                        }
                    }
                }
            }
        } catch (IOException e) {
          
        }
        return false; 
    }

    public static boolean checkHallandDate(String fileName, String date, String eventName) {
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
        } catch (IOException e) {
         
        }
        return false;
    }

    /////////////اضافة العناصر
    public static void AddtoEvent(String name, String item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Event.txt", true))) {
            // Append hall details to the file
            writer.write(name + item);
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

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
        } catch (IOException e) {
        
        }
        return false;
    }

    public static void addPackageToFile(String packageName, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
          
            writer.write(packageName);
            writer.newLine();
            System.out.println("Package '" + packageName + "' added to file '" + filename + "'");
        } catch (IOException e) {
            System.err.println("Error occurred while writing to file: " + e.getMessage());
        }
    }


    public static int getColumnValueForHall(String filePath, String hallName, int columnIndex) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line; 

           
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

               
                for (String column : columns) {
                    if (column.trim().equals(hallName)) {
                      
                        if (columnIndex < columns.length) {
                            return Integer.parseInt(columns[columnIndex].trim()); // استرجاع قيمة العمود المطلوبة ك integer
                        } else {
                            throw new IllegalArgumentException("Column index is out of bounds");
                        }
                    }
                }
            }

            throw new IllegalArgumentException("Hall " + hallName + " not found in file");
        }
    }

    ///////////////////////////////////////////////// Package
    public static int checkPrise(String filename, int value, int columnIndex) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int counter = 0;

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

        reader.close();
        return counter;
    }

    public static boolean deleteLineFromFile(String name, String filename) {
        try {
            File inputFile = new File(filename);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean deleted = false;

            while ((currentLine = reader.readLine()) != null) {
              
                if (currentLine.contains(name)) {
                    deleted = true;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            // Delete the original file
            if (!inputFile.delete()) {
                System.out.println("Could not delete the original file.");
                return false;
            }

            // Rename the temp file to the original file name
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename the temp file.");
                return false;
            }

            System.out.println("Line containing '" + name + "' deleted from file '" + filename + "'");
            return deleted;
        } catch (IOException e) {
            System.err.println("Error occurred while deleting line from file: " + e.getMessage());
            return false;
        }
    }


    public static void searchValueInFile(String filePath, String searchValue) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); 
                String valueToSearch = parts[parts.length - 1];
                if (valueToSearch.equals(searchValue)) {
                    System.out.println(line);
                   
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("حدث خطأ أثناء قراءة الملف: " + e.getMessage());
        }
    }



}

