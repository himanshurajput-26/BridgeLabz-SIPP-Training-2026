import java.util.Scanner;

/**
 * Class to calculate custom segment multiplication mapping to steps 6 through 9.
 */
class PartialMultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        // Size 4 elements to store steps 6, 7, 8, and 9
        int[] multiplicationResult = new int[4];
        
        // Map 6-9 range dynamically down to indices 0-3
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }
        
        System.out.println("\nMultiplication Table Segment (6 to 9):");
        // Output from mapped array elements cleanly
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }
        
        input.close();
    }
}