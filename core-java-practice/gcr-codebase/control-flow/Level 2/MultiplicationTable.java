// Class to generate target segment tables from indices 6 to 9
import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to get its multiplication table (6 to 9): ");
        int number = input.nextInt();
        
        System.out.println("\nMultiplication Table for " + number + " (Rows 6-9):");
        // Execute loop from initial boundary 6 to terminal boundary 9
        for (int i = 6; i <= 9; i++) {
            int product = number * i;
            // Print statement structured precisely in 'number * i = product' format
            System.out.println(number + " * " + i + " = " + product);
        }
        
        input.close();
    }
}