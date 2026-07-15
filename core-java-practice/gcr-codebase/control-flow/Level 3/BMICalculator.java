// Class implementing body mass calculations and category assignments
import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter weight in kilograms (kg): ");
        double weightKg = input.nextDouble();
        System.out.print("Enter height in centimeters (cm): ");
        double heightCm = input.nextDouble();
        
        // Convert metrics: height in meters = cm / 100
        double heightMeters = heightCm / 100.0;
        
        // Execute structural standard BMI equation: weight / (height * height)
        double bmi = weightKg / (heightMeters * heightMeters);
        String status = "";
        
        // Evaluate the output across standard health risk boundaries
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        // Summary outputs display
        System.out.println("\n--- Health Summary Metrics ---");
        System.out.println("Calculated BMI: " + String.format("%.1f", bmi) + " kg/m^2");
        System.out.println("Classification Status: " + status);
        
        input.close();
    }
}