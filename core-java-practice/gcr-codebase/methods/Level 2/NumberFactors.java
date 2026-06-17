import java.util.Scanner;

public class NumberFactors {

    // Static method to find factors and return them in an array
    public static int[] findFactors(int number) {
        // First loop: find the count to initialize the array
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        
        // Second loop: save factors into the array
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to find the sum of the factors
    public static int findSum(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // Method to find the product of the factors
    public static long findProduct(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // Method to find the sum of square of the factors using Math.pow()
    public static double findSumOfSquares(int[] factors) {
        double sumOfSquares = 0;
        for (int f : factors) {
            sumOfSquares += Math.pow(f, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        
        System.out.println("\nSum of Factors: " + findSum(factors));
        System.out.println("Product of Factors: " + findProduct(factors));
        System.out.println("Sum of Squares of Factors: " + findSumOfSquares(factors));
        input.close();
    }
}