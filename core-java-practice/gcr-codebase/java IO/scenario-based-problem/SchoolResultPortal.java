import java.io.*;

public class SchoolResultPortal {
    public static void generateReportCard(String inputFile, String outputFile) {
        // Use try-with-resources to automatically manage and close files safely
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) { // 'true' enables append mode

            String line;
            writer.write("============= REPORT CARDS =============\n");
            
            while ((line = reader.readLine()) != null) {
                // Assuming data format in text file is: Name,Mark1,Mark2,Mark3 (e.g., Rahul,85,90,75)
                String[] tokens = line.split(",");
                if (tokens.length < 2) continue;

                String name = tokens[0];
                double sum = 0;
                int subjectsCount = tokens.length - 1;

                for (int i = 1; i < tokens.length; i++) {
                    sum += Double.parseDouble(tokens[i].trim());
                }

                double average = sum / subjectsCount;

                // Write formatted report card out to destination file
                writer.write("Student Name: " + name + " | Average Mark: " + String.format("%.2f", average) + "\n");
            }
            writer.write("========================================\n\n");
            System.out.println("Report cards successfully appended to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: The input data file was not found.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while processing records: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Parsing Error: Invalid numeric mark entry inside file.");
        }
    }

    public static void main(String[] args) {
        // For testing, make sure 'students.txt' exists in your working directory with lines like: Rahul,85,90,80
        generateReportCard("students.txt", "report_cards.txt");
    }
}