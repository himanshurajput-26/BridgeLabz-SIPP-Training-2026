import java.util.Scanner;

public class DistanceConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double feet;

        System.out.print("Enter distance in feet: ");
        feet = sc.nextDouble();

        double yards = feet / 3;
        double miles = yards / 1760;

        System.out.println("The distance in yards is " + yards + " while the distance in miles is " + miles);
    }
}