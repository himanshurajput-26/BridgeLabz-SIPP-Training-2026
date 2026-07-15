class BankAccount {
    // Attributes
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method for depositing money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method for withdrawing money safely
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance to process withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display the balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder + " | Account No: " + accountNumber + " | Balance: $" + balance);
    }
}

public class MainATM {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", "ACC123456", 500.0);
        account.displayBalance();
        account.deposit(250.0);
        account.withdraw(100.0);
        account.withdraw(800.0); // Triggers insufficient balance validation
        account.displayBalance();
    }
}