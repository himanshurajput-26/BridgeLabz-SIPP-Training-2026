public class Problem6 {
    // Declaring exception propagation using 'throws'
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0 || years < 0) {
            // Triggering explicit exception via 'throw'
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            // Test invalid input to showcase behavior
            double interest = calculateInterest(-1000, 5.5, 2);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}