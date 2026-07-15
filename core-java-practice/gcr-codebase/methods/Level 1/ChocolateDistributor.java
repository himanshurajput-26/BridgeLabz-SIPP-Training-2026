import java.util.Scanner;

public class ChocolateDistributor {

    public static int[] findRemainderAndQuotient(int number, int divisor) { // [cite: 117, 118]
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter total number of chocolates: "); // [cite: 116]
        int chocolates = input.nextInt(); // [cite: 116]
        System.out.print("Enter total number of children: "); // [cite: 116]
        int children = input.nextInt(); // [cite: 116]

        if (children <= 0) {
            System.out.println("There must be at least 1 child to distribute chocolates.");
        } else {
            int[] results = findRemainderAndQuotient(chocolates, children);
            System.out.println("Chocolates received per child: " + results[1]); // [cite: 114]
            System.out.println("Remaining items kept in box: " + results[0]); // [cite: 114]
        }
        input.close();
    }
}