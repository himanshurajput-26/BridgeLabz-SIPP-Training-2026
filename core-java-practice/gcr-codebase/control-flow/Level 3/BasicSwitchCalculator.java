// Class executing clear mathematical tasks mapped through operator selectors
import java.util.Scanner;

class BasicSwitchCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Collect numeric inputs
        System.out.print("Enter first numeric operand: ");
        double first = input.nextDouble();
        System.out.print("Enter second numeric operand: ");
        double second = input.nextDouble();
        
        // Collect targeted symbolic operation string characters
        System.out.print("Enter an operator (+, -, *, /): ");
        String op = input.next();
        
        double result = 0.0;
        boolean isValid = true; // Flow verification safety tracker flag
        
        // Divert operational paths utilizing explicit switch selectors
        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                // Guarding logic checking for undefined zero values
                if (second != 0.0) {
                    result = first / second;
                } else {
                    System.out.println("Error: Division by zero is mathematically undefined.");
                    isValid = false;
                }
                break;
            default:
                System.out.println("Invalid Operator entered.");
                isValid = false;
                break;
        }
        
        // Print statement executed upon verifying calculations
        if (isValid) {
            System.out.println("Calculation Result: " + first + " " + op + " " + second + " = " + result);
        }
        
        input.close();
    }
}