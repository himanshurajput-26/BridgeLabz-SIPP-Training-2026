// Program for rocket launch countdown using for loop

import java.util.Scanner;

class RocketCountdownFor {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take countdown value
        System.out.print("Enter countdown number: ");
        int number = input.nextInt();

        // Countdown using for loop
        for (int counter = number; counter >= 1; counter--) {
            System.out.println(counter);
        }

        System.out.println("Rocket Launch!");

        // Close scanner
        input.close();
    }
}