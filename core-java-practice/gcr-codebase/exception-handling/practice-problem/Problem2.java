import java.util.Scanner;
import java.util.InputMismatchException;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter denominator: ");
            int num2 = scanner.nextInt();
            
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException handled: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException handled: Non-numeric value entered.");
        } finally {
            scanner.close();
        }
    }
}