import java.util.Scanner;

public class PalindromeMultiValidationEngine {

    public static boolean checkIteratively(String text) {
        int startPointer = 0;
        int endPointer = text.length() - 1;

        while (startPointer < endPointer) {
            if (text.charAt(startPointer) != text.charAt(endPointer)) {
                return false;
            }
            startPointer++;
            endPointer--;
        }
        return true;
    }

    public static boolean checkRecursively(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return checkRecursively(text, start + 1, end - 1);
    }

    public static boolean checkViaArrayReversal(String text) {
        char[] naturalArray = text.toCharArray();
        char[] reversedArray = new char[naturalArray.length];
        
        int lookupIndex = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            reversedArray[lookupIndex++] = text.charAt(i);
        }

        for (int i = 0; i < naturalArray.length; i++) {
            if (naturalArray[i] != reversedArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Provide sequence for palindrome validation: ");
        String text = sc.nextLine();

        String normalizedText = text.replaceAll("\\s+", "").toLowerCase();

        boolean logic1Result = checkIteratively(normalizedText);
        boolean logic2Result = checkRecursively(normalizedText, 0, normalizedText.length() - 1);
        boolean logic3Result = checkViaArrayReversal(normalizedText);

        System.out.println("\n=== Palindrome Audit Report ===");
        System.out.println("Strategy 1 (Two-Pointer Iteration) : Is Palindrome? -> " + logic1Result);
        System.out.println("Strategy 2 (Functional Recursion)  : Is Palindrome? -> " + logic2Result);
        System.out.println("Strategy 3 (Array Reversal Mirror) : Is Palindrome? -> " + logic3Result);
        
        sc.close();
    }
}