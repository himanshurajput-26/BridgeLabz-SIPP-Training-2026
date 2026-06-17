import java.util.Scanner;

public class LeapYear {

    // Method to check for Leap Year
    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            return false; 
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("Leap year program only works for year >= 1582.");
        } else {
            if (isLeapYear(year)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        }
        input.close();
    }
}