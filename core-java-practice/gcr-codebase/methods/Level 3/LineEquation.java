import java.util.Scanner;

class LineEquation {

    public static double findDistance(
            double x1, double y1,
            double x2, double y2) {

        return Math.sqrt(
                Math.pow(x2 - x1, 2)
                        +
                Math.pow(y2 - y1, 2));
    }

    public static double[] getLineEquation(
            double x1, double y1,
            double x2, double y2) {

        double slope =
                (y2 - y1) / (x2 - x1);

        double intercept =
                y1 - (slope * x1);

        return new double[]{
                slope,
                intercept
        };
    }

    public static void main(String[] args) {

        Scanner input =
                new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = input.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = input.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = input.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = input.nextDouble();

        double distance =
                findDistance(
                        x1, y1,
                        x2, y2);

        double[] equation =
                getLineEquation(
                        x1, y1,
                        x2, y2);

        System.out.println(
                "\nEuclidean Distance: "
                        + distance);

        System.out.println(
                "Equation of Line: y = "
                        + equation[0]
                        + "x + "
                        + equation[1]);

        input.close();
    }
}