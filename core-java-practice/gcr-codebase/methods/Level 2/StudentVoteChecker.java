import java.util.Scanner;

public class StudentVoteChecker {

    // Method to check voting eligibility
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false; 
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        
        int[] studentAges = new int[10];

        System.out.println("Enter age for 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + " Age: ");
            studentAges[i] = input.nextInt();
        }

        System.out.println("\n--- Voting Results ---");
        for (int i = 0; i < studentAges.length; i++) {
            boolean eligible = checker.canStudentVote(studentAges[i]);
            System.out.println("Student " + (i + 1) + " (Age " + studentAges[i] + "): " + 
                               (eligible ? "Can Vote" : "Cannot Vote"));
        }
        input.close();
    }
}