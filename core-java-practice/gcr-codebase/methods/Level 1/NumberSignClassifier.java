import java.util.Scanner;

public class NumberSignClassifier {

    public static int checkNumberSign(int number) { // [cite: 94]
        if (number > 0) return 1; // [cite: 94]
        if (number < 0) return -1; // [cite: 94]
        return 0; // [cite: 94]
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: "); // [cite: 94]
        int number = input.nextInt(); // [cite: 94]

        int result = checkNumberSign(number);
        System.out.println("Result: " + result);
        input.close();
    }
}