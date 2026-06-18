public class UsernameValidator {
    public static boolean isValidUsername(String username, int index) {
        // Base case: If we checked all characters successfully
        if (index == username.length()) {
            return true;
        }
        char ch = username.charAt(index);
        // Check if character is NOT a lowercase letter
        if (ch < 'a' || ch > 'z') {
            return false;
        }
        // Recursive call for the next character
        return isValidUsername(username, index + 1);
    }

    public static void main(String[] args) {
        String user1 = "abcdxyz"; // Expected: true [cite: 98]
        String user2 = "abcD123"; // Expected: false [cite: 99]

        System.out.println(isValidUsername(user1, 0)); 
        System.out.println(isValidUsername(user2, 0)); 
    }
}