import java.util.Scanner;

public class MinMaxFinder {

    public static int[] findSmallestAndLargest(int number1, int number2, int number3) { // [cite: 106, 107]
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three numbers:"); // [cite: 101]
        int num1 = input.nextInt(); // [cite: 101]
        int num2 = input.nextInt(); // [cite: 101]
        int num3 = input.nextInt(); // [cite: 101]

        int[] results = findSmallestAndLargest(num1, num2, num3);
        System.out.println("Smallest Number: " + results[0]);
        System.out.println("Largest Number: " + results[1]);
        input.close();
    }
}