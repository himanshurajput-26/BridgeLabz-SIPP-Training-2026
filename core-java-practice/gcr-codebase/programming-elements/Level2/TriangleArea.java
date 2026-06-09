import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base, height;

        System.out.print("Enter base (cm): ");
        base = sc.nextDouble();

        System.out.print("Enter height (cm): ");
        height = sc.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaInch = areaCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaInch + " and sq cm is " + areaCm);
    }
}