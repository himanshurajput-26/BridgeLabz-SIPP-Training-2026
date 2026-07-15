public class Problem5 {
    public static boolean isPalindrome(String str, int start, int end) {
        // Base case: if pointers cross, it's a palindrome
        if (start >= end) {
            return true;
        }
        // If characters don't match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recursive call narrowing down the string boundary
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "madam";
        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}