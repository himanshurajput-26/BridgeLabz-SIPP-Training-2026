// Defining custom checked exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class Problem10 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00);

        // Scenario A: Negative value entry
        try {
            account.withdraw(-50);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Scenario B: Excessive balance extraction
        try {
            account.withdraw(600);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Scenario C: Correct transactional logic
        try {
            account.withdraw(150);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}