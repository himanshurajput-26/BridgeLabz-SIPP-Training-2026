import java.util.ArrayList;
import java.util.List;

// ==========================================
// BANK ACCOUNT CLASS
// ==========================================
class BankAccount {
    // Static field to track total accounts created globally
    private static int totalAccountsCreated = 0;

    // Instance fields
    private final String accountNumber;
    private final String accountHolder;
    private double balance;
    private final List<String> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        
        // Track the transaction sequence initialization
        recordTransaction(String.format("Account opened with initial balance of $%.2f", initialBalance));
        
        // Increment the static counter
        totalAccountsCreated++;
    }

    // Static getter to fetch total accounts created
    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }

    // Deposit operation
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.printf("[ERROR] Cannot deposit an invalid amount ($%.2f) for %s.\n", amount, accountHolder);
            return;
        }
        this.balance += amount;
        recordTransaction(String.format("Deposited: +$%.2f", amount));
        System.out.printf("Successfully deposited $%.2f to %s's account. New Balance: $%.2f\n", amount, accountHolder, this.balance);
    }

    // Withdraw operation with Overdraft Check
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.printf("[ERROR] Cannot withdraw an invalid amount ($%.2f) for %s.\n", amount, accountHolder);
            return;
        }
        
        // Overdraft Check
        if (amount > this.balance) {
            System.out.printf("[OVERDRAFT BLOCKED] Execution denied. %s attempted to withdraw $%.2f but only has $%.2f available.\n", 
                    accountHolder, amount, this.balance);
            recordTransaction(String.format("Declined Withdrawal Attempt: $%.2f (Insufficient Funds)", amount));
            return;
        }

        this.balance -= amount;
        recordTransaction(String.format("Withdrew: -$%.2f", amount));
        System.out.printf("Successfully withdrew $%.2f from %s's account. Remaining Balance: $%.2f\n", amount, accountHolder, this.balance);
    }

    // Get Statement Method
    public void printStatement() {
        System.out.println("\n==================================================");
        System.out.printf("             STATEMENT FOR ACCOUNT: %s            \n", accountNumber);
        System.out.println("==================================================");
        System.out.printf("Holder Name   : %s\n", accountHolder);
        System.out.printf("Current Funds : $%.2f\n", balance);
        System.out.println("------------------------- Log --------------------");
        for (String log : transactionHistory) {
            System.out.println(" - " + log);
        }
        System.out.println("==================================================\n");
    }

    // Helper method to keep track of logs internally
    private void recordTransaction(String executionLog) {
        transactionHistory.add(executionLog);
    }
}

// ==========================================
// SIMULATION ENGINE
// ==========================================
public class BankSimulationApp {
    public static void main(String[] args) {
        System.out.println("--- Starting Bank Management Simulation ---\n");

        // 1. Initializing 3 distinct accounts
        BankAccount acc1 = new BankAccount("BAC-1001", "Alice Smith", 500.00);
        BankAccount acc2 = new BankAccount("BAC-1002", "Bob Jones", 1500.00);
        BankAccount acc3 = new BankAccount("BAC-1003", "Charlie Brown", 50.00);

        // Print initial static count tracker metrics
        System.out.printf("\n[System Alert] Total active core system accounts generated: %d\n\n", 
                BankAccount.getTotalAccountsCreated());

        System.out.println("--- Executing Transactions ---\n");

        // 2. Simulating 5 transactions for Account 1 (Alice)
        System.out.println("[Processing Alice's Account]");
        acc1.deposit(200.00);     // Tx 1
        acc1.withdraw(150.00);    // Tx 2
        acc1.deposit(50.50);      // Tx 3
        acc1.withdraw(700.00);    // Tx 4 (Triggers Overdraft Check block)
        acc1.withdraw(40.00);     // Tx 5

        System.out.println("\n[Processing Bob's Account]");
        // 3. Simulating 5 transactions for Account 2 (Bob)
        acc2.withdraw(500.00);    // Tx 1
        acc2.withdraw(200.00);    // Tx 2
        acc2.deposit(1000.00);    // Tx 3
        acc2.withdraw(150.00);    // Tx 4
        acc2.deposit(25.00);      // Tx 5

        System.out.println("\n[Processing Charlie's Account]");
        // 4. Simulating 5 transactions for Account 3 (Charlie)
        acc3.withdraw(60.00);     // Tx 1 (Triggers Overdraft Check block)
        acc3.deposit(300.00);     // Tx 2
        acc3.withdraw(100.00);    // Tx 3
        acc3.deposit(50.00);      // Tx 4
        acc3.withdraw(10.00);     // Tx 5

        // 5. Generating and displaying Account Statements
        System.out.println("\n--- Displaying Final Activity Statements ---");
        acc1.printStatement();
        acc2.printStatement();
        acc3.printStatement();
        
        // Final sanity verification on the static tracker field 
        System.out.printf("Final Audit Check: System tracked a grand total of %d initialized bank accounts.\n", 
                BankAccount.getTotalAccountsCreated());
    }
}