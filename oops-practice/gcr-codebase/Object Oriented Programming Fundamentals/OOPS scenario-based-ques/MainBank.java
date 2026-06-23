import java.util.ArrayList;
import java.util.List;

class BankAccount {
    // Static field to track total accounts created
    private static int totalAccounts = 0;

    // Instance variables
    private String accountNumber;
    private String holder;
    private double balance;
    private List<String> statement;

    // Constructor
    public BankAccount(String accountNumber, String holder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = initialBalance;
        this.statement = new ArrayList<>();
        this.statement.add("Account created with initial balance: $" + initialBalance);
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            statement.add("Deposited: $" + amount + " | Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        // Allowing an arbitrary overdraft protection limit of $500 for simulation
        double overdraftLimit = 500.0;
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            statement.add("Withdrew: $" + amount + " | Balance: $" + balance);
        } else {
            statement.add("Failed Withdrawal Attempt: $" + amount + " (Insufficient Funds/Overdraft Limit Exceeded)");
            System.out.println("Withdrawal denied for " + holder + ". Overdraft limit exceeded.");
        }
    }

    public void getStatement() {
        System.out.println("\n--- Account Statement for " + holder + " (" + accountNumber + ") ---");
        for (String record : statement) {
            System.out.println(record);
        }
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class MainBank {
    public static void main(String[] adjournment) {
        // Create 3 accounts
        BankAccount acc1 = new BankAccount("BAC001", "Alice", 1000.0);
        BankAccount acc2 = new BankAccount("BAC002", "Bob", 150.0);
        BankAccount acc3 = new BankAccount("BAC003", "Charlie", 500.0);

        // Simulate 5 transactions each
        acc1.deposit(200);
        acc1.withdraw(150);
        acc1.withdraw(1200); // Triggers overdraft checking
        acc1.deposit(50);
        acc1.withdraw(100);

        acc2.withdraw(50);
        acc2.withdraw(300); // Triggers overdraft
        acc2.deposit(500);
        acc2.withdraw(100);
        acc2.deposit(20);

        acc3.deposit(100);
        acc3.deposit(200);
        acc3.withdraw(50);
        acc3.withdraw(850); // Fails limit check
        acc3.deposit(30);

        // Print statements
        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        System.out.println("\nTotal accounts created: " + BankAccount.getTotalAccounts());
    }
}