/**
 * Custom checked exception thrown when a patient's payment 
 * does not cover the total bill amount.
 */
class InsufficientFundsException extends Exception {
    private final double shortfall;

    public InsufficientFundsException(double totalAmount, double amountPaid) {
        super(String.format("Payment failed: Insufficient funds. Total bill is $%.2f, but only $%.2f was provided.", 
                totalAmount, amountPaid));
        this.shortfall = totalAmount - amountPaid;
    }

    public double getShortfall() {
        return shortfall;
    }
}

// ============================================================================

public class HospitalBillingSystemApp {

    // Mock patient database (simulating safe indices 0 to 2)
    private static final String[] PATIENTS = {"Alice Smith", "Bob Jones", "Charlie Brown"};
    
    public static void main(String[] args) {
        HospitalBillingSystemApp app = new HospitalBillingSystemApp();

        System.out.println("=== Test 1: Successful Transaction ===");
        app.processBilling(1, "500.00", 5, 500.00);

        System.out.println("\n=== Test 2: Handling Number Format Exception ===");
        app.processBilling(0, "abc50.00", 2, 100.00);

        System.out.println("\n=== Test 3: Handling Array Out Of Bounds Exception ===");
        app.processBilling(5, "150.00", 3, 150.00); // Index 5 doesn't exist

        System.out.println("\n=== Test 4: Handling Division By Zero (Zero Items) ===");
        app.processBilling(2, "600.00", 0, 600.00); // 0 items

        System.out.println("\n=== Test 5: Handling Custom Insufficient Funds Exception ===");
        app.processBilling(1, "1200.00", 4, 300.00); // Paid 300 instead of 1200
        
        System.out.println("\n[System Check] Application survived all errors without crashing.");
    }

    /**
     * Simulates processing a bill with defensive exception containment.
     */
    public void processBilling(int patientIndex, String costInput, int itemCount, double amountPaid) {
        try {
            // 1. Check for valid patient index (Array Index Out Of Bounds)
            if (patientIndex < 0 || patientIndex >= PATIENTS.length) {
                throw new ArrayIndexOutOfBoundsException("Requested patient index " + patientIndex + " is out of database boundaries.");
            }
            String patientName = PATIENTS[patientIndex];
            System.out.println("Processing bill for: " + patientName);

            // 2. Parse billing cost (Number Format Exception)
            double totalCost = Double.parseDouble(costInput);

            // 3. Calculate average item cost (Arithmetic Exception / Division by Zero)
            // Explicitly checking for 0 to ensure strict mathematical safety in financial math
            if (itemCount == 0) {
                throw new ArithmeticException("Cannot compute itemized cost for an invoice containing 0 items.");
            }
            double averageItemCost = totalCost / itemCount;
            System.out.printf("  Itemized breakdown: Total $%s over %d items (Avg: $%.2f per item).\n", costInput, itemCount, averageItemCost);

            // 4. Handle Payment & Custom business rule validation
            if (amountPaid < totalCost) {
                throw new InsufficientFundsException(totalCost, amountPaid);
            }

            System.out.println("  Transaction successful! Payment captured smoothly.");

        } catch (NumberFormatException e) {
            System.err.println("CRITICAL ERROR: Failed to parse item cost. Input string \"" + costInput + "\" is corrupted or invalid.");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("CRITICAL ERROR: Patient Record Lookup Failure. " + e.getMessage());
            System.err.println("  Valid database range is between index 0 and " + (PATIENTS.length - 1));
            
        } catch (ArithmeticException e) {
            System.err.println("CRITICAL ERROR: Mathematical calculation error. " + e.getMessage());
            System.err.println("  An invoice cannot be finalized without registered items.");
            
        } catch (InsufficientFundsException e) {
            System.err.println("BUSINESS REJECTION: " + e.getMessage());
            System.err.printf("  Action Required: Collect remaining shortfall of $%.2f from patient to proceed.\n", e.getShortfall());
            
        } catch (Exception e) {
            // Catch-all safety net for any completely unforeseen system issues
            System.err.println("UNEXPECTED ERROR: An unhandled exception occurred: " + e.getMessage());
        }
    }
}