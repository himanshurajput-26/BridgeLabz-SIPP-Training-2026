import java.util.Scanner;

public class UppercaseConverter {

    // Converts lowercase to uppercase via ASCII delta processing
    public static String customToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Verify character scales across the lower alphabet registry
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32); // Step up transformation offset
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

        String customUpper = customToUpperCase(input);
        String builtinUpper = input.toUpperCase();

        boolean match = compareStrings(customUpper, builtinUpper);

        System.out.println("\n--- Upper Results ---");
        System.out.println("Custom Conversion:  " + customUpper);
        System.out.println("Built-in Conversion: " + builtinUpper);
        System.out.println("Identical? " + match);

        sc.close();
    }
}