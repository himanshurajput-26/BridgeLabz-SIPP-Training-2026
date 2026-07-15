import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Delhi Metro Smart Card System ===");
        System.out.print("Enter initial smart card balance (₹): ");
        double balance = scanner.nextDouble();
        
        while (balance > 0) {
            System.out.println("\nCurrent Balance: ₹" + balance);
            System.out.print("Enter travel distance in km (or type -1 to quit): ");
            double distance = scanner.nextDouble();
            
            // Exit condition
            if (distance == -1) {
                System.out.println("Thank you for traveling with Delhi Metro!");
                break;
            }
            
            // Input validation for distance
            if (distance < 0) {
                System.out.println("Invalid distance entered. Please try again.");
                continue;
            }
            
            // Calculate fare using nested ternary operator
            // Pricing Logic: <= 5km = ₹20, <= 15km = ₹40, > 15km = ₹60
            double fare = (distance <= 5) ? 20.0 : (distance <= 15) ? 40.0 : 60.0;
            
            System.out.println("Calculated Fare for " + distance + " km: ₹" + fare);
            
            // Check if balance is sufficient
            if (balance >= fare) {
                balance -= fare; // Deduct from smart card balance
                System.out.println("Fare deducted successfully. Swipe out allowed.");
            } else {
                System.out.println("Insufficient balance! Please recharge your smart card.");
                System.out.println("Required: ₹" + fare + " | Available: ₹" + balance);
            }
            
            // Check if balance is completely exhausted
            if (balance == 0) {
                System.out.println("\nYour smart card balance is now zero. Please recharge before your next journey.");
            }
        }
        
        System.out.println("System terminated.");
        scanner.close();
    }
}