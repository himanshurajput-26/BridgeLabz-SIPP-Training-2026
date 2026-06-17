import java.util.Scanner;

public class DivisionCalculations {

    public static int[] findRemainderAndQuotient(int number, int divisor) { // [cite: 111, 112]
        int quotient = number / divisor; // [cite: 110]
        int remainder = number % divisor; // [cite: 110]
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: "); // [cite: 109]
        int number = input.nextInt(); // [cite: 109]
        System.out.print("Enter Divisor: "); // [cite: 109]
        int divisor = input.nextInt(); // [cite: 109]

        if (divisor == 0) {
            System.out.println("Error: Division by zero is undefined.");
        } else {
            int[] outcomes = findRemainderAndQuotient(number, divisor);
            System.out.println("Quotient: " + outcomes[1]);
            System.out.println("Remainder: " + outcomes[0]);
        }
        input.close();
    }
}