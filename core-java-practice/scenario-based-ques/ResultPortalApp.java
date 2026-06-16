import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResultPortalApp {

    private static final String INPUT_FILE = "student_data.txt";
    private static final String REPORT_FILE = "master_report_cards.txt";

    public static void main(String[] args) {
        ResultPortalApp portal = new ResultPortalApp();

        // Step 1: Create a mock input file for demonstration purposes
        portal.generateMockInputFile();

        // Step 2: Run the report card generation processor
        System.out.println("=== Starting Result Portal Processor ===");
        portal.generateReportCards();
        
        System.out.println("\n=== Running Processor a Second Time (Testing Append Feature) ===");
        portal.generateReportCards();
        
        System.out.println("\n=== Testing Graceful Error Handling (Missing File) ===");
        portal.processFile("non_existent_file.txt");
    }

    /**
     * Entry wrapper to capture and process student records from the default file.
     */
    public void generateReportCards() {
        processFile(INPUT_FILE);
    }

    /**
     * Reads student raw data, calculates parameters, and appends to a master file.
     * Contains targeted exception handling to remain resilient.
     */
    private void processFile(String filePath) {
        // BufferedReader initialized within try-with-resources for automatic resource closing
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             // Setting the second argument of FileWriter to 'true' enables APPEND mode
             BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE, true))) {
            
            String line;
            int processedCount = 0;

            writer.write("====================================================\n");
            writer.write("           OFFICIAL STUDENT REPORT CARDS            \n");
            writer.write("====================================================\n");

            // Read the text file line-by-line
            while ((line = reader.readLine()) != null) {
                // Skip empty lines safely
                if (line.trim().isEmpty()) continue;

                // Expected format: StudentName, Math, Science, English (e.g., John Doe, 85, 90, 78)
                String[] tokens = line.split(",");
                if (tokens.length < 4) {
                    System.err.println("Skipping malformed data row: " + line);
                    continue;
                }

                String studentName = tokens[0].trim();
                try {
                    double math = Double.parseDouble(tokens[1].trim());
                    double science = Double.parseDouble(tokens[2].trim());
                    double english = Double.parseDouble(tokens[3].trim());

                    // Calculate math metrics
                    double average = (math + science + english) / 3.0;
                    char grade = determineGrade(average);

                    // Write structured block report to output file
                    writer.write(String.format("Student Name : %s\n", studentName));
                    writer.write(String.format(" Marks       : Math: %.1f | Science: %.1f | English: %.1f\n", math, science, english));
                    writer.write(String.format(" Average     : %.2f%%\n", average));
                    writer.write(String.format(" Final Grade : %c\n", grade));
                    writer.write("----------------------------------------------------\n");

                    processedCount++;

                } catch (NumberFormatException nfe) {
                    System.err.println("Skipping record for '" + studentName + "' due to invalid, non-numeric marks data.");
                }
            }

            writer.write("\n\n"); // Add spacing block for future data additions
            System.out.println("Success: Processed " + processedCount + " student records into '" + REPORT_FILE + "'.");

        } catch (FileNotFoundException e) {
            // Targeted graceful exception handling
            System.err.println("CRITICAL ERROR: The system could not locate the file: " + filePath);
            System.err.println("Please check that the file path is accurate and that the file is not currently open elsewhere.");
            
        } catch (IOException e) {
            // Catches general stream issues (e.g., lack of storage permission)
            System.err.println("SYSTEM ERROR: An issue occurred while reading or writing data: " + e.getMessage());
        }
    }

    /**
     * Business helper logic determining alphabet grade brackets based on calculated averages.
     */
    private char determineGrade(double average) {
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }

    /**
     * Helper method to dynamically generate a dummy text file to ensure the script compiles 
     * and runs right out of the box.
     */
    private void generateMockInputFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE))) {
            bw.write("Alice Vance, 92, 88, 95\n");
            bw.write("Bob Miller, 74, 65, 80\n");
            bw.write("Charlie Day, 55, 60, 48\n");
            bw.write("Diana Prince, 98, 100, 96\n");
        } catch (IOException e) {
            System.err.println("Could not create initial demo data stream file.");
        }
    }
}