import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem5 {
    public static void main(String[] args) {
        // Try-with-resources automatically closes the resource
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}