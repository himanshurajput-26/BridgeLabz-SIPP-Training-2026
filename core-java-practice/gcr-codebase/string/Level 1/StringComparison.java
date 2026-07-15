import java.util.Scanner;

public class StringComparison {

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String first = sc.next();
        System.out.print("Enter second string: ");
        String second = sc.next();

        // Custom method check
        boolean customResult = compareStrings(first, second);
        // Built-in method check
        boolean builtinResult = first.equals(second);

        System.out.println("\n--- Results ---");
        System.out.println("Custom charAt() comparison result: " + customResult);
        System.out.println("Built-in equals() comparison result: " + builtinResult);
        System.out.println("Do both results match? " + (customResult == builtinResult));
        
        sc.close();
    }
}