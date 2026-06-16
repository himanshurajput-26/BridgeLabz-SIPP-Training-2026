import java.util.Scanner;

public class StringLengthTracker {

    // Method to calculate length without using length() built-in method
    public static int getCustomLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Caught boundary violation exception; count matches string length
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next(); // Takes user input using next() [cite: 207]

        int customLength = getCustomLength(text);
        int builtinLength = text.length();

        System.out.println("\n--- Length Validation ---");
        System.out.println("Custom calculated length: " + customLength);
        System.out.println("Built-in length() value: " + builtinLength);
        System.out.println("Do both length results match? " + (customLength == builtinLength));
        
        sc.close();
    }
}