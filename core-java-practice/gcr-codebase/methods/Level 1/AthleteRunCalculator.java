import java.util.Scanner;

public class AthleteRunCalculator {

    public static double computeRounds(double side1, double side2, double side3) { // [cite: 92]
        double perimeter = side1 + side2 + side3; // [cite: 91]
        double targetDistanceMeters = 5000.0; // 5 km converted to meters [cite: 88]
        return targetDistanceMeters / perimeter; // [cite: 91]
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the 3 sides of the triangular park in meters:"); // [cite: 90]
        double side1 = input.nextDouble(); // [cite: 90]
        double side2 = input.nextDouble(); // [cite: 90]
        double side3 = input.nextDouble(); // [cite: 90]

        double roundsRequired = computeRounds(side1, side2, side3);
        System.out.printf("The athlete needs to complete %.2f rounds to achieve a 5km run.\n", roundsRequired); // [cite: 88]
        input.close();
    }
}