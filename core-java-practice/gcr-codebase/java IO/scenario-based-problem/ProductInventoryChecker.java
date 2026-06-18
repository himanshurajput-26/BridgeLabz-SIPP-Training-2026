import java.io.*;

public class ProductInventoryChecker {
    public static void checkStock(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("=== Out of Stock Alerts ===");
            
            while ((line = br.readLine()) != null) {
                if (!line.contains("-")) continue;
                
                String[] parts = line.split("-");
                String productName = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());

                if (quantity == 0) {
                    System.out.println(productName + " is out of stock");
                }
            }
        } catch (IOException e) {
            System.out.println("Error mapping stock allocations: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("File Data Malformed: Numeric parse mismatch.");
        }
    }

    public static void main(String[] args) {
        checkStock("inventory.txt");
    }
}