// Class translating historical dates into day values (0-6) using Zeller/Gregorian formulas
class DayOfWeek {
    public static void main(String[] args) {
        // Confirming that three structural command line parameter inputs exist
        if (args.length < 3) {
            System.out.println("Error: Please provide three parameters: Month(1-12) Day(1-31) Year");
            return;
        }
        
        // Parse incoming positional string arguments into target integers
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        
        // Implement formulas provided in documentation
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        
        // Optional array translation for contextual readability
        String[] daysList = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        // Clear summary output reporting calculation codes alongside names
        System.out.println("Calculated Day Value: " + d0 + " (" + daysList[d0] + ")");
    }
}