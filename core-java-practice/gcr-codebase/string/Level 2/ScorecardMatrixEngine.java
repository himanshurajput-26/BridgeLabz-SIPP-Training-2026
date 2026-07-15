import java.util.Scanner;

public class ScorecardMatrixEngine {

    // Generates a 2D array containing random scores for Physics, Chemistry, and Math (PCM)
    public static int[][] generateStudentScores(int studentCount) {
        int[][] scores = new int[studentCount][3];
        for (int i = 0; i < studentCount; i++) {
            scores[i][0] = (int) (Math.random() * 51) + 50; // Physics: 50-100
            scores[i][1] = (int) (Math.random() * 51) + 50; // Chemistry: 50-100
            scores[i][2] = (int) (Math.random() * 51) + 50; // Math: 50-100
        }
        return scores;
    }

    // Computes Total, Average, and Percentage metrics for each student
    public static double[][] calculatePerformanceMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round off values cleanly to 2 decimal digits [cite: 305]
            metrics[i][0] = Math.round(total * 100.0) / 100.0;
            metrics[i][1] = Math.round(avg * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    // Resolves letter grade symbols using the standardized distribution map [cite: 300]
    public static String[] resolveLetterGrades(double[][] metrics) {
        String[] grades = new String[metrics.length];
        for (int i = 0; i < metrics.length; i++) {
            double pct = metrics[i][2];
            if (pct >= 80) grades[i] = "A";
            else if (pct >= 70) grades[i] = "B";
            else if (pct >= 60) grades[i] = "C";
            else if (pct >= 50) grades[i] = "D";
            else if (pct >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void printReportCard(int[][] scores, double[][] metrics, String[] grades) {
        System.out.println("\n=====================================================================================");
        System.out.printf("%-9s | %-4s | %-4s | %-4s | %-7s | %-7s | %-10s | %-5s\n", 
                "ID", "PHY", "CHE", "MAT", "TOTAL", "AVG", "PERCENT%", "GRADE");
        System.out.println("=====================================================================================");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %-2d | %-4d | %-4d | %-4d | %-7.2f | %-7.2f | %-9.2f%% | %-5s\n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2], 
                    metrics[i][0], metrics[i][1], metrics[i][2], grades[i]);
        }
        System.out.println("=====================================================================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of student accounts to compute: ");
        int count = sc.nextInt();

        int[][] scoreBook = generateStudentScores(count);
        double[][] analyticsBook = calculatePerformanceMetrics(scoreBook);
        String[] finalGrades = resolveLetterGrades(analyticsBook);

        printReportCard(scoreBook, analyticsBook, finalGrades);
        
        sc.close();
    }
}