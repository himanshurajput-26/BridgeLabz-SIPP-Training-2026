import java.util.Scanner;

class CalendarProgram {

    public static String getMonthName(int month) {

        String[] months = {
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        };

        return months[month - 1];
    }

    public static boolean isLeapYear(int year) {

        return (year % 4 == 0 &&
                year % 100 != 0) ||
                year % 400 == 0;
    }

    public static int getDaysInMonth(int month, int year) {

        int[] days = {
            31,28,31,30,31,30,
            31,31,30,31,30,31
        };

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }

    public static int getFirstDay(int month, int year) {

        int d = 1;

        if (month < 3) {
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;

        int day = (d + (13 * (month + 1)) / 5
                + k + k / 4
                + j / 4 + 5 * j) % 7;

        return (day + 6) % 7;
    }

    public static void displayCalendar(
            int month, int year) {

        int firstDay =
                getFirstDay(month, year);

        int totalDays =
                getDaysInMonth(month, year);

        System.out.println("\n   " +
                getMonthName(month)
                + " " + year);

        System.out.println(
                "Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= totalDays; day++) {

            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Month: ");
        int month = input.nextInt();

        System.out.print("Enter Year: ");
        int year = input.nextInt();

        displayCalendar(month, year);

        input.close();
    }
}