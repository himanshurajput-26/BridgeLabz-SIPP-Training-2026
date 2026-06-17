public class UnitConvertorMisc {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kg) {
        double kilograms2pounds = 2.20462;
        return kg * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        System.out.println("98.6 F to C: " + convertFahrenheitToCelsius(98.6));
        System.out.println("37 C to F: " + convertCelsiusToFahrenheit(37));
        System.out.println("10 Pounds to Kg: " + convertPoundsToKilograms(10));
        System.out.println("5 Kg to Pounds: " + convertKilogramsToPounds(5));
        System.out.println("2 Gallons to Liters: " + convertGallonsToLiters(2));
        System.out.println("5 Liters to Gallons: " + convertLitersToGallons(5));
    }
}