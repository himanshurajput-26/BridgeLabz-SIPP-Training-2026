import java.util.Scanner;

/**
 * Class wrapping nested multi-dimensional arrays for data management.
 */
class MatrixGradingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter total number of students in database: ");
        int classVolume = input.nextInt();
        
        // Rows match individual Student IDs, columns track courses [Physics, Chemistry, Math]
        double[][] scoreMatrix = new double[classVolume][3];
        double[] metricsPercentages = new double[classVolume];
        char[] qualitativeGrades = new char[classVolume];
        
        for (int i = 0; i < classVolume; i++) {
            System.out.println("\n--- Student Record Entry " + (i + 1) + " ---");
            System.out.print("Physics Marks: ");
            double physicsScore = input.nextDouble();
            System.out.print("Chemistry Marks: ");
            double chemistryScore = input.nextDouble();
            System.out.print("Math Marks: ");
            double mathScore = input.nextDouble();
            
            if (physicsScore < 0 || chemistryScore < 0 || mathScore < 0) {
                System.out.println("Negative marks detected. Re-enter valid data.");
                i--; // Reset index counter
                continue;
            }
            
            scoreMatrix[i][0] = physicsScore;
            scoreMatrix[i][1] = chemistryScore;
            scoreMatrix[i][2] = mathScore;
            
            metricsPercentages[i] = (scoreMatrix[i][0] + scoreMatrix[i][1] + scoreMatrix[i][2]) / 3.0;
            double referencePct = metricsPercentages[i];
            
            if (referencePct >= 80.0) qualitativeGrades[i] = 'A';
            else if (referencePct >= 70.0) qualitativeGrades[i] = 'B';
            else if (referencePct >= 60.0) qualitativeGrades[i] = 'C';
            else if (referencePct >= 50.0) qualitativeGrades[i] = 'D';
            else if (referencePct >= 40.0) qualitativeGrades[i] = 'E';
            else qualitativeGrades[i] = 'R';
        }
        
        System.out.println("\n======================== INTEGRATED MATRIX REGISTRY ========================");
        System.out.printf("%-10s | %-7s | %-7s | %-7s | %-12s | %-5s\n", "Student ID", "Phys", "Chem", "Math", "Percentage", "Grade");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < scoreMatrix.length; i++) {
            System.out.printf("ID %-8d | %-7.1f | %-7.1f | %-7.1f | %-12.2f | %-5c\n", 
                              (i + 1), scoreMatrix[i][0], scoreMatrix[i][1], scoreMatrix[i][2], metricsPercentages[i], qualitativeGrades[i]);
        }
        System.out.println("============================================================================");
        
        input.close();
    }
}