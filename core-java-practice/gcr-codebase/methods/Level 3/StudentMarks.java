import java.util.Scanner;

class StudentMarks {

    public static int[][] generateMarks(
            int students) {

        int[][] marks =
                new int[students][3];

        for (int i = 0; i < students; i++) {

            for (int j = 0; j < 3; j++) {

                marks[i][j] =
                        (int)(Math.random()
                                * 90) + 10;
            }
        }

        return marks;
    }

    public static double[][] calculateResults(
            int[][] marks) {

        double[][] results =
                new double
                        [marks.length][3];

        for (int i = 0;
             i < marks.length; i++) {

            int total =
                    marks[i][0]
                    + marks[i][1]
                    + marks[i][2];

            double average =
                    total / 3.0;

            double percentage =
                    (total / 300.0)
                            * 100;

            results[i][0] = total;
            results[i][1] =
                    Math.round(
                            average * 100.0)
                            / 100.0;

            results[i][2] =
                    Math.round(
                            percentage
                                    * 100.0)
                            / 100.0;
        }

        return results;
    }

    public static void displayScoreCard(
            int[][] marks,
            double[][] results) {

        System.out.println(
                "Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");

        for (int i = 0;
             i < marks.length; i++) {

            System.out.println(
                    (i + 1) + "\t\t"
                    + marks[i][0]
                    + "\t\t"
                    + marks[i][1]
                    + "\t\t"
                    + marks[i][2]
                    + "\t"
                    + results[i][0]
                    + "\t"
                    + results[i][1]
                    + "\t\t"
                    + results[i][2]
                    + "%");
        }
    }

    public static void main(String[] args) {

        Scanner input =
                new Scanner(System.in);

        System.out.print(
                "Enter Number of Students: ");

        int students =
                input.nextInt();

        int[][] marks =
                generateMarks(students);

        double[][] results =
                calculateResults(marks);

        displayScoreCard(
                marks,
                results);

        input.close();
    }
}