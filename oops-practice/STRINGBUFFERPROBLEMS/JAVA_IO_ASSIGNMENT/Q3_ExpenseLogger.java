import java.io.*;
import java.util.*;

public class Q3_ExpenseLogger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Amount: ");
        int amount = sc.nextInt();

        try {
            FileWriter fw = new FileWriter("expenses.txt", true);

            fw.write(category + " - " + amount + "\n");

            fw.close();

            System.out.println("Expense Saved");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}