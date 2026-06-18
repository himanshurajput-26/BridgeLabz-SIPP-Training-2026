// Custom exception containing context data properties
class InsufficientBalanceException extends Exception {
    private double currentBalance;
    private double requestedAmount;

    public InsufficientBalanceException(String message, double currentBalance, double requestedAmount) {
        super(message);
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public double getCurrentBalance() { return currentBalance; }
    public double getRequestedAmount() { return requestedAmount; }
}

public class ATMSystem {
    private double balance = 5000.0;

    // The exception should contain details of the shortfall and be thrown from the business logic method
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientBalanceException("Transaction Declined: Insufficient balance. Shortfall of ₹" + shortfall, balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();
        // The exception should be caught and handled in the driver main routine or controller tier
        try {
            System.out.println("Attempting to withdraw ₹8,000...");
            atm.withdraw(8000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught Exception in main: " + e.getMessage());
            System.out.println("Logged Data -> Current Balance: ₹" + e.getCurrentBalance() + " | Attempted: ₹" + e.getRequestedAmount());
        }
    }
}