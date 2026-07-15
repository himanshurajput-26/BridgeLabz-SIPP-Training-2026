public class PasswordChecker {

    public static void checkPassword(String password) {
        try {
            // 1. Null verification check
            if (password == null) {
                throw new IllegalArgumentException("Password validation failed: Input cannot be null.");
            }
            // 2. Length verification check (covers empty string as well)
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password validation failed: Password must be at least 8 characters long.");
            }
            // 3. First character check
            char firstChar = password.charAt(0);
            if (!Character.isUpperCase(firstChar)) {
                throw new IllegalArgumentException("Password validation failed: First character must be an uppercase letter.");
            }
            // 4. Last character check
            char lastChar = password.charAt(password.length() - 1);
            if (!Character.isDigit(lastChar)) {
                throw new IllegalArgumentException("Password validation failed: Last character must be a digit.");
            }
            // 5. Special character pattern verification
            String specialChars = "@#$%&*";
            boolean hasSpecial = false;
            for (int i = 0; i < password.length(); i++) {
                if (specialChars.contains(String.valueOf(password.charAt(i)))) {
                    hasSpecial = true;
                    break;
                }
            }
            if (!hasSpecial) {
                throw new IllegalArgumentException("Password validation failed: Missing at least one special character (@, #, $, %, &, *).");
            }

            System.out.println("Password accepted! Success: System rules matched.");

        } catch (IllegalArgumentException e) {
            // Displays meaningful error messages instead of letting the application crash
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        checkPassword(null);
        checkPassword("short");
        checkPassword("lowercase1#");
        checkPassword("ValidPassNoSpecial1");
        checkPassword("Secure@2026"); // Strong password matching all rules
    }
}