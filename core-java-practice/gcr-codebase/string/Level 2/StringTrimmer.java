import java.util.Scanner;

public class StringTrimmer {

    // Analyzes and returns valid text boundaries within a 1D boundary index array
    public static int[] locateTrimBoundaries(String text) {
        int length = text.length();
        int start = 0;
        int end = length - 1;

        // Trace forward over leading blank coordinates
        while (start < length && text.charAt(start) == ' ') {
            start++;
        }
        // Trace backward over trailing blank coordinates
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String extractCustomSubstring(String text, int start, int end) {
        String sub = "";
        for (int i = start; i <= end; i++) {
            sub += text.charAt(i);
        }
        return sub;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Provide text padded with outer spacing dimensions: ");
        String text = sc.nextLine();

        int[] boundaries = locateTrimBoundaries(text);
        
        String customTrimmed = "";
        if (boundaries[0] <= boundaries[1]) {
            customTrimmed = extractCustomSubstring(text, boundaries[0], boundaries[1]);
        }

        String builtinTrimmed = text.trim();
        boolean complianceCheck = compareStrings(customTrimmed, builtinTrimmed);

        System.out.println("\n--- Trim Assessment ---");
        System.out.println("Custom String Layout:  [" + customTrimmed + "]");
        System.out.println("Built-in String Layout: [" + builtinTrimmed + "]");
        System.out.println("Trim processes matching validation? " + complianceCheck);
        
        sc.close();
    }
}