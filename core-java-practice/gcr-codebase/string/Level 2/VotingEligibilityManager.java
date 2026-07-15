import java.util.Scanner;

public class VotingEligibilityManager {

    // Fills an array with random 2-digit ages for n students
    public static int[] generateRandomAges(int count) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            // Generates ages within a standard range of 10 to 99
            ages[i] = (int) (Math.random() * 90) + 10; 
        }
        return ages;
    }

    public static String[][] buildEligibilityMatrix(int[] ages) {
        String[][] matrix = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            matrix[i][0] = String.valueOf(ages[i]);
            
            // Age validation strategy verification loops
            if (ages[i] < 0) {
                matrix[i][1] = "false"; // Explicit negative block override condition [cite: 277]
            } else {
                matrix[i][1] = (ages[i] >= 18) ? "true" : "false";
            }
        }
        return matrix;
    }

    public static void displayEligibilityTable(String[][] matrix) {
        System.out.println("\n===========================");
        System.out.printf("%-12s | %-10s\n", "Student Age", "Can Vote");
        System.out.println("===========================");
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("Student %-4d | %-10s\n", (i + 1), matrix[i][1]);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of student profiles to create: ");
        int totalStudents = sc.nextInt();

        int[] agePool = generateRandomAges(totalStudents);
        String[][] summaryMatrix = buildEligibilityMatrix(agePool);
        displayEligibilityTable(summaryMatrix);
        
        sc.close();
    }
}