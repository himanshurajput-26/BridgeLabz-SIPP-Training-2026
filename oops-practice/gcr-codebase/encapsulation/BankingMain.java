abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to Account " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Account " + accountNumber);
        } else {
            System.out.println("Transaction Failed: Insufficient funds or invalid amount.");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.printf("Account: %s | Holder: %s | Current Balance: $%.2f%n", 
            accountNumber, holderName, balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double monthlyBonusRate;

    public CurrentAccount(String accountNumber, String holderName, double balance, double monthlyBonusRate) {
        super(accountNumber, holderName, balance);
        this.monthlyBonusRate = monthlyBonusRate;
    }

    public double getMonthlyBonusRate() { return monthlyBonusRate; }
    public void setMonthlyBonusRate(double monthlyBonusRate) { this.monthlyBonusRate = monthlyBonusRate; }

    @Override
    public double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}

public class BankingMain {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SAV-4001", "Jane Doe", 10000.0, 4.5);
        BankAccount current = new CurrentAccount("CUR-9002", "John Smith", 25000.0, 1.2);

        System.out.println("====== EXECUTING TRANSACTIONS ======");
        savings.deposit(2000.0);
        savings.withdraw(1500.0);
        
        current.deposit(5000.0);
        current.withdraw(35000.0); // Test Overdraft Protection

        System.out.println("\n====== BANK PROFILE AUDIT ======");
        savings.displayAccountDetails();
        System.out.printf("Calculated Annual Yield: $%.2f%n%n", savings.calculateInterest());

        current.displayAccountDetails();
        System.out.printf("Calculated Monthly Yield: $%.2f%n", current.calculateInterest());
    }
}