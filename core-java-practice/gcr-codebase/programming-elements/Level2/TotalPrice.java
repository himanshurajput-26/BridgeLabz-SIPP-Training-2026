import java.util.Scanner;

public class TotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double unitPrice;
        int quantity;

        System.out.print("Enter unit price: ");
        unitPrice = sc.nextDouble();

        System.out.print("Enter quantity: ");
        quantity = sc.nextInt();

        double total = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + total +
                " if the quantity " + quantity + " and unit price is INR " + unitPrice);
    }
}