// Class executing scalar integer division sequences to extract layout length
import java.util.Scanner;

class DigitCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        int tempNumber = number;
        int count = 0; // State accumulator tracker variable
        
        // Handle explicit edge cases where input is exactly zero
        if (tempNumber == 0) {
            count = 1;
        } else {
            // Loop strips numbers step-by-step to aggregate counts
            while (tempNumber != 0) {
                tempNumber = tempNumber / 10; // Truncate digit
                count++; // Increment tally
            }
        }
        
        System.out.println("Total number of digits in " + number + " = " + count);
        input.close();
    }
}