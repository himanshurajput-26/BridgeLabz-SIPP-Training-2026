import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Problem1 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // Attempt to open and read data.txt
            reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print contents if file exists
            }
        } catch (IOException e) {
            // Handle file not found or other IO issues
            System.out.println("File not found");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing reader");
            }
        }
    }
}