import java.util.Scanner;

public class TrigonometryCalculator {

    public double[] calculateTrigonometricFunctions(double angle) { // [cite: 125]
        double radians = Math.toRadians(angle); // [cite: 124]
        double sine = Math.sin(radians); // [cite: 124]
        double cosine = Math.cos(radians); // [cite: 124]
        double tangent = Math.tan(radians); // [cite: 124]
        
        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter target angle in degrees: ");
        double angle = input.nextDouble();

        TrigonometryCalculator calculator = new TrigonometryCalculator();
        double[] results = calculator.calculateTrigonometricFunctions(angle);

        System.out.printf("Sine: %.4f\n", results[0]);
        System.out.printf("Cosine: %.4f\n", results[1]);
        System.out.printf("Tangent: %.4f\n", results[2]);
        input.close();
    }
}