// Custom Checked Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    private static int[] patientIds = {101, 102, 103, 104};

    public static void processBill(int patientIndex, String itemCountStr, double payment, double totalBill) {
        try {
            // 1. Array Index Out of Bounds Check
            int patientId = patientIds[patientIndex];
            System.out.println("Processing bill for Patient ID: " + patientId);

            // 2. Number Format Check
            int items = Integer.parseInt(itemCountStr);

            // 3. Division-by-Zero Check
            if (items == 0) {
                int errorTrigger = 100 / items; 
            }
            
            double averageCostPerItem = totalBill / items;
            System.out.println("Average cost per item: ₹" + averageCostPerItem);

            // 4. Custom Exception Check
            if (payment < totalBill) {
                throw new InsufficientFundsException("Payment failed: Provided ₹" + payment + " but the total bill is ₹" + totalBill);
            }
            
            System.out.println("Billing successful! Balance return: ₹" + (payment - totalBill));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index entry.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Item count input must be a valid integer.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot process a bill with zero items (Division by zero).");
        } catch (InsufficientFundsException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1: Insufficient Funds ---");
        processBill(1, "5", 4000, 5500);

        System.out.println("\n--- Test Case 2: Invalid Index ---");
        processBill(8, "5", 5000, 4000);
    }
}