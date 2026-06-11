import java.util.Scanner;

public class KingdomTaxSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to store incomes of 10 citizens
        double[] income = new double[10];

        double totalTaxCollected = 0;

        System.out.println("===== Kingdom Tax System =====");

        // Loop for 10 citizens
        for (int i = 0; i < 10; i++) {
            System.out.print("\nEnter income of Citizen " + (i + 1) + ": ");
            income[i] = sc.nextDouble();

            double tax = 0;
            String taxBracket = "";

            // Tax calculation using conditions
            if (income[i] < 10000) {
                tax = income[i] * 0.05;
                taxBracket = "5% Tax Bracket";
            } 
            else if (income[i] <= 50000) {
                tax = income[i] * 0.15;
                taxBracket = "15% Tax Bracket";
            } 
            else {
                tax = income[i] * 0.30;
                taxBracket = "30% Tax Bracket";
            }

            // Add tax to total
            totalTaxCollected += tax;

            // Display result for citizen
            System.out.println("Citizen " + (i + 1) + " Details:");
            System.out.println("Income      : " + income[i]);
            System.out.println("Tax Bracket : " + taxBracket);
            System.out.println("Tax Amount  : " + tax);
        }

        // Final total tax collected
        System.out.println("\n==============================");
        System.out.println("Total Tax Collected: " + totalTaxCollected);
        System.out.println("==============================");

        sc.close();
    }
}