import java.util.Scanner;

public class FriendAnalysis {

    // Method to find the youngest
    public static int findYoungest(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Method to find the tallest
    public static int findTallest(double[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height (in cm) for " + names[i] + ": ");
            heights[i] = input.nextDouble();
        }

        int youngestIdx = findYoungest(ages);
        int tallestIdx = findTallest(heights);

        System.out.println("\nYoungest Friend: " + names[youngestIdx] + " (Age: " + ages[youngestIdx] + ")");
        System.out.println("Tallest Friend: " + names[tallestIdx] + " (Height: " + heights[tallestIdx] + " cm)");
        input.close();
    }
}