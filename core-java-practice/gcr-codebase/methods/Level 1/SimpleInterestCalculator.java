import java.util.Scanner;

public class SimpleInterestCalculator {

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100.0;
    }

    public static void main(String[] args) {
        // Corrected Scanner initialization
        Scanner input = new Scanner(System.in);
        
        // Corrected System.out.print statements
        System.out.print("Enter Principal: ");
        double principal = input.nextDouble();
        
        System.out.print("Enter Rate of Interest: ");
        double rate = input.nextDouble();
        
        System.out.print("Enter Time (in years): ");
        double time = input.nextDouble();

        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f, and Time %.1f years.\n", 
            simpleInterest, principal, rate, time);
            
        input.close();
    }
}