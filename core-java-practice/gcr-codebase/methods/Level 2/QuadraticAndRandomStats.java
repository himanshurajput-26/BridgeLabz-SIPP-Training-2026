import java.util.Scanner;

public class QuadraticAndRandomStats {

    // Method to find the roots of a quadratic equation
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[]{}; // Empty array for negative delta
        }
    }

    // Method that generates array of 4 digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = (int) (Math.random() * 9000) + 1000;
        }
        return randomArray;
    }

    // Method to find average, min and max value of an array
    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int minVal = numbers[0];
        int maxVal = numbers[0];

        for (int num : numbers) {
            sum += num;
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        double average = sum / numbers.length;
        return new double[]{average, (double) minVal, (double) maxVal};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Part 1: Quadratic Equation Solver
        System.out.println("--- Quadratic Equation Solver (ax^2 + bx + c = 0) ---");
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        double[] roots = findRoots(a, b, c);
        if (roots.length == 0) {
            System.out.println("No real roots.");
        } else if (roots.length == 1) {
            System.out.printf("One unique root: %.4f\n", roots[0]);
        } else {
            System.out.printf("Two roots: Root 1 = %.4f, Root 2 = %.4f\n", roots[0], roots[1]);
        }

        // Part 2: Random Array Analytics
        System.out.println("\n--- Random 4-Digit Array Stats ---");
        int[] dataset = generate4DigitRandomArray(5);

        System.out.print("Generated Values: ");
        for (int val : dataset) {
            System.out.print(val + " ");
        }

        double[] statistics = findAverageMinMax(dataset);
        System.out.printf("\nAverage: %.2f | Min: %.0f | Max: %.0f\n", statistics[0], statistics[1], statistics[2]);
        
        input.close();
    }
}