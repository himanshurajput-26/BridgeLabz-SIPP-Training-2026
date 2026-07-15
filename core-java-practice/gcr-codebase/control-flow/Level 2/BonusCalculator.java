// Class to calculate corporate employee bonuses based on tenure benchmarks
import java.util.Scanner;

class BonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input variables for financial and tenure records
        System.out.print("Enter employee monthly salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();
        
        // Initializing bonus parameters
        double bonusPercentage = 0.05; // 5% bonus structural rate
        double bonusAmount = 0.0;
        
        // Check eligibility condition (service > 5 years)
        if (yearsOfService > 5) {
            bonusAmount = salary * bonusPercentage;
            System.out.println("Congratulations! You qualify for a 5% bonus.");
            System.out.println("Your Bonus Amount is: " + bonusAmount);
        } else {
            System.out.println("Tenure is less than or equal to 5 years. Not eligible for a bonus.");
            System.out.println("Bonus Amount: " + bonusAmount);
        }
        
        input.close();
    }
}