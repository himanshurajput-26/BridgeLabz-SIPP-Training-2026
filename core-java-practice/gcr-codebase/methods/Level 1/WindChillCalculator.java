import java.util.Scanner;

public class WindChillCalculator {

    public double calculateWindChill(double temperature, double windSpeed) { // [cite: 121]
        // Standard National Weather Service formula for Wind Chill index [cite: 120]
        return 35.74 + (0.6215 * temperature) - (35.75 * Math.pow(windSpeed, 0.16)) + (0.4275 * temperature * Math.pow(windSpeed, 0.16));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature (in Fahrenheit): ");
        double temp = input.nextDouble();
        System.out.print("Enter wind speed (in mph): ");
        double speed = input.nextDouble();

        WindChillCalculator calculator = new WindChillCalculator();
        double windChill = calculator.calculateWindChill(temp, speed);

        System.out.printf("Calculated Wind Chill Temperature Index: %.2f\n", windChill);
        input.close();
    }
}