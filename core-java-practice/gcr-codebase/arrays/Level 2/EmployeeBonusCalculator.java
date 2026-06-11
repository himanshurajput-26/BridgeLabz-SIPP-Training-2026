import java.util.Scanner;

/**
 * Class to evaluate financial payouts and corporate bonuses based on service tenure.
 */
class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Define arrays to track initial attributes and processed payouts
        double[] oldSalaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonusAmounts = new double[10];
        double[] newSalaries = new double[10];
        
        double totalOldSalary = 0.0;
        double totalBonusPaid = 0.0;
        double totalNewSalary = 0.0;
        
        System.out.println("Enter details for 10 employees:");
        for (int i = 0; i < oldSalaries.length; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");
            System.out.print("Enter current base salary: ");
            double baseSalary = input.nextDouble();
            System.out.print("Enter years of service: ");
            double serviceTenure = input.nextDouble();
            
            // Input Validation with index rollback mechanics
            if (baseSalary <= 0 || serviceTenure < 0) {
                System.out.println("Invalid telemetry entered. Re-enter records for this employee.");
                i--; // Decrement index counter to retry the step
                continue;
            }
            
            oldSalaries[i] = baseSalary;
            yearsOfService[i] = serviceTenure;
        }
        
        // Processing loop block
        for (int i = 0; i < oldSalaries.length; i++) {
            double tenure = yearsOfService[i];
            double salary = oldSalaries[i];
            double bonusPercentage = (tenure > 5) ? 0.05 : 0.02;
            
            bonusAmounts[i] = salary * bonusPercentage;
            newSalaries[i] = salary + bonusAmounts[i];
            
            // Accumulate financial indicators
            totalOldSalary += salary;
            totalBonusPaid += bonusAmounts[i];
            totalNewSalary += newSalaries[i];
        }
        
        // Render system aggregates
        System.out.println("\n================= ZARA FINANCIAL SUMMARY =================");
        System.out.printf("Aggregate Base Payroll (Old)  : %.2f\n", totalOldSalary);
        System.out.printf("Aggregate Bonus Payout        : %.2f\n", totalBonusPaid);
        System.out.printf("Aggregate Adjusted Payroll(New): %.2f\n", totalNewSalary);
        System.out.println("==========================================================");
        
        input.close();
    }
}