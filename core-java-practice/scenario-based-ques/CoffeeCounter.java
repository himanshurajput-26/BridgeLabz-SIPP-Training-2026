import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constant rate for Goods and Services Tax (e.g., 5%)
        final double GST_RATE = 0.05; 
        
        System.out.println("=== Welcome to the Coffee Counter ===");
        
        while (true) { // Loop continues for the next customer 
            System.out.print("\nEnter coffee type (Espresso, Latte, Cappuccino) or type 'exit' to quit: ");
            String coffeeType = scanner.next();
            
            // Check for exit condition 
            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Exiting system. Have a great day!");
                break; // Break control flow to exit loop [cite: 9, 16]
            }
            
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            
            double basePrice = 0.0;
            boolean validOrder = true;
            
            // Determine price using a switch statement 
            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    basePrice = 150.0;
                    break;
                case "latte":
                    basePrice = 180.0;
                    break;
                case "cappuccino":
                    basePrice = 200.0;
                    break;
                default:
                    System.out.println("Error: Invalid coffee type selected.");
                    validOrder = false;
                    break;
            }
            
            // Process bill if the order input was valid
            if (validOrder) {
                double subtotal = basePrice * quantity; // Calculate total bill [cite: 6, 14]
                double gstAmount = subtotal * GST_RATE;  // Calculate GST component [cite: 6, 15]
                double totalBill = subtotal + gstAmount; // Final aggregate amount [cite: 6]
                
                System.out.println("--------------------------------");
                System.out.printf("Subtotal:       ₹%.2f\n", subtotal);
                System.out.printf("GST (5%%):       ₹%.2f\n", gstAmount);
                System.out.printf("Total Bill:     ₹%.2f\n", totalBill);
                System.out.println("--------------------------------");
            }
        }
        
        scanner.close();
    }
}