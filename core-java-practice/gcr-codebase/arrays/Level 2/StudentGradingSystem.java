import java.util.Scanner;

/**
 * Class managing academic grading metrics via unified array sets.
 */
class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter total number of students in database: ");
        int totalStudents = input.nextInt();
        
        double[] physicsMarks = new double[totalStudents];
        double[] chemistryMarks = new double[totalStudents];
        double[] mathMarks = new double[totalStudents];
        double[] aggregatePercentages = new double[totalStudents];
        char[] finalGrades = new char[totalStudents];
        
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\n--- Student Entry " + (i + 1) + " ---");
            System.out.print("Physics Marks: ");
            double phys = input.nextDouble();
            System.out.print("Chemistry Marks: ");
            double chem = input.nextDouble();
            System.out.print("Math Marks: ");
            double math = input.nextDouble();
            
            // Validate negative entries
            if (phys < 0 || chem < 0 || math < 0) {
                System.out.println("Marks cannot be negative. Re-enter this student's scores.");
                i--; // Roll back target entry step index
                continue;
            }
            
            physicsMarks[i] = phys;
            chemistryMarks[i] = chem;
            mathMarks[i] = math;
            
            // Compute percentage based on an individual 100-mark max per topic
            aggregatePercentages[i] = (phys + chem + math) / 3.0;
            double calculatedPct = aggregatePercentages[i];
            
            // Map grading tier categories
            if (calculatedPct >= 80.0) finalGrades[i] = 'A';
            else if (calculatedPct >= 70.0) finalGrades[i] = 'B';
            else if (calculatedPct >= 60.0) finalGrades[i] = 'C';
            else if (calculatedPct >= 50.0) finalGrades[i] = 'D';
            else if (calculatedPct >= 40.0) finalGrades[i] = 'E';
            else finalGrades[i] = 'R';
        }
        
        System.out.println("\n=========================== REPORT REGISTRY SYSTEM ===========================");
        System.out.printf("%-10s | %-7s | %-7s | %-7s | %-12s | %-5s\n", "Student ID", "Phys", "Chem", "Math", "Percentage", "Grade");
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i < totalStudents; i++) {
            System.out.printf("ID %-8d | %-7.1f | %-7.1f | %-7.1f | %-12.2f | %-5c\n", 
                              (i + 1), physicsMarks[i], chemistryMarks[i], mathMarks[i], aggregatePercentages[i], finalGrades[i]);
        }
        System.out.println("==============================================================================");
        
        input.close();
    }
}