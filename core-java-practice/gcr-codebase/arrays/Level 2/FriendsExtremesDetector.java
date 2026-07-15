import java.util.Scanner;

/**
 * Class to map and resolve age and structural height attributes across groups.
 */
class FriendsExtremesDetector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] identities = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Gather attributes
        for (int i = 0; i < identities.length; i++) {
            System.out.print("Enter age for " + identities[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height for " + identities[i] + ": ");
            heights[i] = input.nextDouble();
        }
        
        // Initializing search references
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        // Evaluate arrays tracking minimum age and maximum height indices
        for (int i = 1; i < identities.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("\n--- Group Analysis Complete ---");
        System.out.println("Youngest Friend: " + identities[youngestIndex] + " (" + ages[youngestIndex] + " years old)");
        System.out.println("Tallest Friend : " + identities[tallestIndex] + " (" + heights[tallestIndex] + " units tall)");
        
        input.close();
    }
}