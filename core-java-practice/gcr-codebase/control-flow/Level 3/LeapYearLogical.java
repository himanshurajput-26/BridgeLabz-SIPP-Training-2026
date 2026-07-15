import java.util.Scanner;

class LeapYearLogical {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("The program only supports Gregorian calendar years from 1582 onwards.");
        } else {
            // Evaluates standard division by 4 but excludes 100 unless match 400
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + " is a Leap Year");
            } else {
                System.out.println(year + " is not a Leap Year");
            }
        }

        input.close();
    }
}