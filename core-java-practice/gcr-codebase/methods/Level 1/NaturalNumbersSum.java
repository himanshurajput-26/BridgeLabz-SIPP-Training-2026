import java.util.Scanner;

public class NaturalNumbersSum {

    public static int findSum(int n) { // [cite: 98]
        int sum = 0;
        for (int i = 1; i <= n; i++) { // [cite: 98]
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer (N): "); // [cite: 98]
        int n = input.nextInt(); // [cite: 98]

        if (n < 1) {
            System.out.println("Please enter a positive integer starting from 1.");
        } else {
            int totalSum = findSum(n);
            System.out.println("The sum of first " + n + " natural numbers is: " + totalSum);
        }
        input.close();
    }
}