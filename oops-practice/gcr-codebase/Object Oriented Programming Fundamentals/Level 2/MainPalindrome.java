class PalindromeChecker {
    // Attribute
    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        if (text == null) return false;
        
        // Remove spaces and normalize casing for perfect evaluation
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleanText.length() - 1;
        
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to display the evaluation result
    public void displayResult() {
        System.out.println("Input Text: \"" + text + "\"");
        if (isPalindrome()) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}

public class MainPalindrome {
    public static void main(String[] args) {
        PalindromeChecker checker1 = new MainPalindrome().newChecker("Radar");
        checker1.displayResult();

        System.out.println();

        PalindromeChecker checker2 = new MainPalindrome().newChecker("Hello World");
        checker2.displayResult();
    }
    
    // Helper helper configuration hook
    private PalindromeChecker newChecker(String str) {
        return new PalindromeChecker(str);
    }
}