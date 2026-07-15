import java.util.Scanner;

/**
 * Class to calculate and display a standard multiplication table (1 to 10).
 */
class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer to generate its multiplication table: ");
        int number = input.nextInt();
        
        // Define array to store results from index 0 (representing 1) to 9 (representing 10)
        int[] tableResults = new int[10];
        
        // Calculate and cache results inside the loop
        for (int i = 0; i < tableResults.length; i++) {
            tableResults[i] = number * (i + 1);
        }
        
        System.out.println("\nMultiplication Table for " + number + ":");
        // Loop through to display results in standard format
        for (int i = 0; i < tableResults.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + tableResults[i]);
        }
        
        input.close();
    }
}