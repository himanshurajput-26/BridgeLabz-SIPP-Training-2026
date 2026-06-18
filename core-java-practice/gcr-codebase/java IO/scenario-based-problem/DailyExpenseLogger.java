import java.util.Scanner;
import java.io.*;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Open file stream using append mode flag set to true
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt", true))) {
            System.out.println("--- Daily Expense Logger ---");
            System.out.print("Enter item category (e.g., Food, Travel): ");
            String category = scanner.nextLine();
            
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            // Store cleanly matching user format requirements
            writer.write(category + " - " + amount + "\n");
            System.out.println("Expense logged successfully.");

        } catch (IOException e) {
            System.out.println("Failed to log tracking metrics to file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}