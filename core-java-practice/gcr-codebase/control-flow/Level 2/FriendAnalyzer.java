// Class to determine extreme profile values among peers
import java.util.Scanner;

class FriendAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Data collection variables for Amar
        System.out.print("Enter Amar's Age and Height (separated by space): ");
        int ageAmar = input.nextInt();
        double heightAmar = input.nextDouble();
        
        // Data collection variables for Akbar
        System.out.print("Enter Akbar's Age and Height (separated by space): ");
        int ageAkbar = input.nextInt();
        double heightAkbar = input.nextDouble();
        
        // Data collection variables for Anthony
        System.out.print("Enter Anthony's Age and Height (separated by space): ");
        int ageAnthony = input.nextInt();
        double heightAnthony = input.nextDouble();
        
        // Module 1: Compute minimum age tracking (Youngest)
        String youngestFriend = "";
        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony) {
            youngestFriend = "Amar";
        } else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony) {
            youngestFriend = "Akbar";
        } else {
            youngestFriend = "Anthony";
        }
        
        // Module 2: Compute maximum height tracking (Tallest)
        String tallestFriend = "";
        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony) {
            tallestFriend = "Amar";
        } else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony) {
            tallestFriend = "Akbar";
        } else {
            tallestFriend = "Anthony";
        }
        
        // Result output display
        System.out.println("\n--- Analysis Results ---");
        System.out.println("The youngest friend is: " + youngestFriend);
        System.out.println("The tallest friend is: " + tallestFriend);
        
        input.close();
    }
}