public class Problem4 {
    public static String reverseString(String str) {
        // Base case: if string is empty or has a single character
        if (str == null || str.length() <= 1) {
            return str;
        }
        // Recursive step: take the last char and append the reversed substring
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseString(str)); // Output: olleh
    }
}