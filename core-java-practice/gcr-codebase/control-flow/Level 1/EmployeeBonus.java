// Program to calculate employee bonus

import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take salary input
        System.out.print("Enter salary: ");
        double salary = input.nextDouble();

        // Take years of service
        System.out.print(
                "Enter years of service: ");
        int yearsOfService =
                input.nextInt();

        // Check eligibility
        if (yearsOfService > 5) {

            // Calculate bonus
            double bonus =
                    salary * 0.05;

            System.out.println(
                    "Bonus Amount = "
                    + bonus);

        } else {
            System.out.println(
                    "No bonus applicable.");
        }

        // Close scanner
        input.close();
    }
}