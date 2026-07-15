import java.util.Scanner;

public class GregorianCalendarConsole {

    public static String getMonthName(int monthValue) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return monthNames[monthValue - 1];
    }

    public static boolean evaluateLeapYear(int calendarYear) {
        return (calendarYear % 4 == 0 && calendarYear % 100 != 0) || (calendarYear % 400 == 0);
    }

    public static int obtainDaysInMonth(int monthValue, int calendarYear) {
        int[] daysDistribution = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (monthValue == 2 && evaluateLeapYear(calendarYear)) {
            return 29; 
        }
        return daysDistribution[monthValue - 1];
    }

    public static int calculateStartDayOffset(int day, int month, int year) {
        int calculatedYear = year - (14 - month) / 12;
        int stepOffset = calculatedYear + calculatedYear / 4 - calculatedYear / 100 + calculatedYear / 400;
        int calculatedMonth = month + 12 * ((14 - month) / 12) - 2;
        return (day + stepOffset + (31 * calculatedMonth) / 12) % 7;
    }

    public static void outputCalendarGrid(int month, int year) {
        String monthTitle = getMonthName(month);
        int maximumDays = obtainDaysInMonth(month, year);
        int startDayOffset = calculateStartDayOffset(1, month, year);

        System.out.println("\n    " + monthTitle + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < startDayOffset; i++) {
            System.out.print("    ");
        }

        for (int dayNumber = 1; dayNumber <= maximumDays; dayNumber++) {
            System.out.printf("%3d ", dayNumber);
            
            if (((dayNumber + startDayOffset) % 7 == 0) || dayNumber == maximumDays) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Provide month value parameter (1-12): ");
        int inputMonth = sc.nextInt();
        System.out.print("Provide year target parameter (e.g. 2005): ");
        int inputYear = sc.nextInt();

        outputCalendarGrid(inputMonth, inputYear);
        
        sc.close();
    }
}