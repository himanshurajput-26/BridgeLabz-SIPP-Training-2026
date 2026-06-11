import java.util.Scanner;
import java.util.Arrays;

public class SpyAgencyMessageAnalyzer {

    // Method to reverse message
    public static String reverseMessage(String message) {
        String reversed = "";

        for (int i = message.length() - 1; i >= 0; i--) {
            reversed += message.charAt(i);
        }

        return reversed;
    }

    // Method to check palindrome
    public static boolean isPalindrome(String message) {
        String cleaned = message.replaceAll("\\s+", "").toLowerCase();
        String reversed = reverseMessage(cleaned);

        return cleaned.equals(reversed);
    }

    // Method to count vowels and consonants
    public static void countVowelsAndConsonants(String message) {
        int vowels = 0;
        int consonants = 0;

        message = message.toLowerCase();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Number of Vowels: " + vowels);
        System.out.println("Number of Consonants: " + consonants);
    }

    // Method to check anagram
    public static boolean areAnagrams(String str1, String str2) {

        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // Method to find first non-repeating character
    public static char firstNonRepeatingCharacter(String log) {

        for (int i = 0; i < log.length(); i++) {
            char currentChar = log.charAt(i);
            int count = 0;

            for (int j = 0; j < log.length(); j++) {
                if (log.charAt(j) == currentChar) {
                    count++;
                }
            }

            if (count == 1) {
                return currentChar;
            }
        }

        return '\0'; // No non-repeating character found
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Secret Message Input
        System.out.print("Enter Secret Message: ");
        String secretMessage = input.nextLine();

        // Reverse Message
        String reversedMessage = reverseMessage(secretMessage);
        System.out.println("\nReversed Message: " + reversedMessage);

        // Palindrome Check
        if (isPalindrome(secretMessage)) {
            System.out.println("The message is a Palindrome.");
        } else {
            System.out.println("The message is NOT a Palindrome.");
        }

        // Vowel & Consonant Count
        countVowelsAndConsonants(secretMessage);

        // Anagram Check
        System.out.print("\nEnter First Intercept Message: ");
        String intercept1 = input.nextLine();

        System.out.print("Enter Second Intercept Message: ");
        String intercept2 = input.nextLine();

        if (areAnagrams(intercept1, intercept2)) {
            System.out.println("Intercepts are Anagrams.");
        } else {
            System.out.println("Intercepts are NOT Anagrams.");
        }

        // Surveillance Log
        System.out.print("\nEnter Surveillance Log: ");
        String log = input.nextLine();

        char result = firstNonRepeatingCharacter(log);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: " + result);
        } else {
            System.out.println("No Non-Repeating Character Found.");
        }

        input.close();
    }
}