import java.util.Scanner;

public class BMICalculator {

    // Calculate BMI and populate third column
    public static void calculateBMI(double[][] teamData) {
        for (int i = 0; i < teamData.length; i++) {
            double weightKg = teamData[i][0];
            double heightMeters = teamData[i][1] / 100.0; // cm to meter
            teamData[i][2] = weightKg / (heightMeters * heightMeters);
        }
    }

    // Determine status for each person
    public static String[] getBMIStatus(double[][] teamData) {
        String[] statuses = new String[teamData.length];
        for (int i = 0; i < teamData.length; i++) {
            double bmi = teamData[i][2];
            if (bmi <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmi <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmi <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] teamData = new double[10][3]; 

        System.out.println("Enter details for 10 Team Members:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Member " + (i + 1) + ":");
            System.out.print("  Weight (kg): ");
            teamData[i][0] = input.nextDouble();
            System.out.print("  Height (cm): ");
            teamData[i][1] = input.nextDouble();
        }

        calculateBMI(teamData);
        String[] statuses = getBMIStatus(teamData);

        System.out.printf("\n%-10s %-12s %-12s %-10s %-12s\n", "Member", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Person-%-5d %-12.2f %-12.2f %-10.2f %-12s\n", 
                (i + 1), teamData[i][0], teamData[i][1], teamData[i][2], statuses[i]);
        }
        input.close();
    }
}