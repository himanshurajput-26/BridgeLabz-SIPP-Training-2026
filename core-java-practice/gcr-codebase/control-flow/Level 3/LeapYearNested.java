// Class to determine leap year eligibility using nested control paths
import java.util.Scanner;

class LeapYearNested {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        
        // Leap year rules apply exclusively to the Gregorian Calendar framework (>= 1582)
        if (year < 1582) {
            System.out.println("The program only supports Gregorian calendar years from 1582 onwards.");
        } else {
            // Nested checks following exact division priority hierarchies
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        System.out.println(year + " is a Leap Year");
                    } else {
                        System.out.println(year + " is not a Leap Year");
                    }
                } else {
                    System.out.println(year + " is a Leap Year");
                }
            } else {
                System.out.println(year + " is not a Leap Year");
            }
        }
        
        input.close();
    }
}