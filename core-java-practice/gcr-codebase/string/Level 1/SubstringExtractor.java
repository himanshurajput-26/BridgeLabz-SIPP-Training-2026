import java.util.Scanner;

public class SubstringExtractor {

    // Extract substring using charAt()
    public static String getCustomSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Reuse string comparison logic
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index (exclusive): ");
        int end = sc.nextInt();

        // 1. Custom extraction
        String customSub = getCustomSubstring(text, start, end);
        // 2. Built-in extraction
        String builtinSub = text.substring(start, end);

        // 3. Comparison
        boolean matches = compareStrings(customSub, builtinSub);

        System.out.println("\n--- Results ---");
        System.out.println("Custom Substring: " + customSub);
        System.out.println("Built-in Substring: " + builtinSub);
        System.out.println("Do they match? " + matches);

        sc.close();
    }
}