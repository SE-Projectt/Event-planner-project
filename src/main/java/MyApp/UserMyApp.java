package MyApp;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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

            // Close the file
            bufferedReader.close();
        } catch (IOException e) {
            // Handle any IO exception
            e.printStackTrace();
        }
    }

    /////////////اضافة العناصر
    public static void AddtoEvent(String name,String item){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Event.txt", true))) {
            // Append hall details to the file
            writer.write(name + item );
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

    }
    public static boolean checkFile(String word, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to get the first word
                String[] parts = line.split(",");
                // Trim to remove leading/trailing spaces and compare with the given word
                if (parts.length > 0 && parts[0].trim().equals(word)) {
                    return true; // Word exists at the beginning of a line in the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Word not found at the beginning of any line in the file
    }

    public static int getColumnValueForHall(String filePath, String hallName, int columnIndex) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line; // سطر الملف

            // قراءة الصفوف في الملف
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // تقسيم الصف إلى أعمدة

                // التحقق مما إذا كان اسم القاعة يطابق في أي من الأعمدة
                for (String column : columns) {
                    if (column.trim().equals(hallName)) {
                        // التحقق مما إذا كان هناك مؤشر صحيح لعمود الذي تم تحديده
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

}
