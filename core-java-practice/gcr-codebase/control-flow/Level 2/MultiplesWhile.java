// Class to find multiples under 100 using a down-counting while loop
import java.util.Scanner;

class MultiplesWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer below 100: ");
        int number = input.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Number must be a positive integer less than 100.");
        } else {
            System.out.println("Numbers between 1 and 100 perfectly divisible by " + number + ":");
            int counter = 100; // Initialize loop sequence marker at max limit
            
            while (counter >= 1) {
                if (counter % number == 0) {
                    System.out.print(counter + " ");
                }
                counter--; // Shift index step downward
            }
            System.out.println();
        }
        
        input.close();
    }
}