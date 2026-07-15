class BankAccount {
    static String bankName = "State Bank of India";
    static int totalAccounts = 0;

    String accountHolderName;
    final int accountNumber;

    BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void display() {
        System.out.println("Bank: " + bankName);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Himanshu", 101);

        if (acc instanceof BankAccount) {
            acc.display();
        }

        getTotalAccounts();
    }
}