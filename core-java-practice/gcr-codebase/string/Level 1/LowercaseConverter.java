import java.util.Scanner;

public class LowercaseConverter {

    // Converts uppercase to lowercase via ASCII delta processing
    public static String customToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Verify character scales across the upper alphabet registry
            if (ch >= 'A' && ch <= 'Z') {
                result += (char) (ch + 32); // Step down transformation offset
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = sc.nextLine();

        String customLower = customToLowerCase(input);
        String builtinLower = input.toLowerCase();

        boolean match = compareStrings(customLower, builtinLower);

        System.out.println("\n--- Lower Results ---");
        System.out.println("Custom Conversion:  " + customLower);
        System.out.println("Built-in Conversion: " + builtinLower);
        System.out.println("Identical? " + match);

        sc.close();
    }
}