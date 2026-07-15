public class UnitConvertorDimensions {

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3.0;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.3333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        System.out.println("2 Yards to Feet: " + convertYardsToFeet(2));
        System.out.println("6 Feet to Yards: " + convertFeetToYards(6));
        System.out.println("1 Meter to Inches: " + convertMetersToInches(1));
        System.out.println("12 Inches to Meters: " + convertInchesToMeters(12));
        System.out.println("10 Inches to Cm: " + convertInchesToCentimeters(10));
    }
}