import java.io.*;

public class FeedbackAnalyzer {
    public static void analyzeFeedback(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int goodCount = 0;
            int linesRead = 0;

            // Constrain read logic strictly to 5 target lines
            while ((line = br.readLine()) != null && linesRead < 5) {
                linesRead++;
                if (line.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }

            System.out.println("Good Feedback Count = " + goodCount);

        } catch (FileNotFoundException e) {
            System.out.println("Feedback source file not found.");
        } catch (IOException e) {
            System.out.println("Error reading feedback: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        analyzeFeedback("feedback.txt");
    }
}