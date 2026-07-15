// Program for rocket launch countdown using while loop

import java.util.Scanner;

class RocketCountdownWhile {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take countdown value
        System.out.print("Enter countdown number: ");
        int counter = input.nextInt();

        // Countdown using while loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Rocket Launch!");

        // Close scanner
        input.close();
    }
}