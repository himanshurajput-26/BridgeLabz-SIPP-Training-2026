import java.io.*;

public class GroceryBillReader {
    public static void readBill(String filename) {
        int lineCount = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("--- Bill Contents ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
            System.out.println("---------------------");
            System.out.println("Total lines in the file: " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: 'bill.txt' file missing.");
        } catch (IOException e) {
            System.out.println("Error while reading file stream: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readBill("bill.txt");
    }
}