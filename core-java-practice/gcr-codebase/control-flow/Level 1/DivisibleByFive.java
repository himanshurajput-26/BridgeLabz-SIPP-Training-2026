import java.util.Scanner;

class DivisibleByFive {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check divisibility by 5
        boolean isDivisible = (number % 5 == 0);

        // Display result
        System.out.println("Is the number " + number +
                " divisible by 5? " + isDivisible);

        // Close scanner
        input.close();
    }
}