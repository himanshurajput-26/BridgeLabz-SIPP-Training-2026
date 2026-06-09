// Class compiling structural subject scores to return academic tier marks
import java.util.Scanner;

class StudentGrader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Target input variable streams for subject marks
        System.out.print("Enter Physics marks: ");
        double physics = input.nextDouble();
        System.out.print("Enter Chemistry marks: ");
        double chemistry = input.nextDouble();
        System.out.print("Enter Mathematics marks: ");
        double maths = input.nextDouble();
        
        // Computing statistics metrics
        double totalMarks = physics + chemistry + maths;
        double averagePercentage = totalMarks / 3.0;
        
        String grade = "";
        String remarks = "";
        
        // Structural evaluation path mapping marks to grade tiers
        if (averagePercentage >= 80.0) {
            grade = "A";
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (averagePercentage >= 70.0) {
            grade = "B";
            remarks = "(Level 3, at agency-normalized standards)";
        } else if (averagePercentage >= 60.0) {
            grade = "C";
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (averagePercentage >= 50.0) {
            grade = "D";
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (averagePercentage >= 40.0) {
            grade = "E";
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = "R";
            remarks = "(Remedial standards)";
        }
        
        // Final reporting console structure
        System.out.println("\n--- Performance Report Card ---");
        System.out.println("Average Mark / Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Assigned Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        
        input.close();
    }
}