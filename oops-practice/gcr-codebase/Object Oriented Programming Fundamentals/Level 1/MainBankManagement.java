class BankAccount {
    public String accountNumber;       // Public
    protected String accountHolder;    // Protected
    private double balance;            // Private

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public encapsulation layer for private 'balance'
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsInfo() {
        // Can access public accountNumber and protected accountHolder directly
        System.out.println("Savings Acc: " + accountNumber + " | Holder: " + accountHolder + 
                           " | Balance: $" + getBalance() + " | Interest Rate: " + interestRate + "%");
    }
}

public class MainBankManagement {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SAV9901", "Charlie Brown", 5000.0, 4.0);
        sa.deposit(1500);
        sa.displaySavingsInfo();
    }
}