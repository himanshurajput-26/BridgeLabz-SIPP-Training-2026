// Program to check whether it is Spring Season

import java.util.Scanner;

class SpringSeason {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take month and day input
        System.out.print("Enter month: ");
        int month = input.nextInt();

        System.out.print("Enter day: ");
        int day = input.nextInt();

        // Check spring season condition
        boolean isSpringSeason =
                (month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20);

        // Display result
        if (isSpringSeason) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        // Close scanner
        input.close();
    }
}