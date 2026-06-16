import java.util.Arrays;

public class RecursiveWizardApp {

    // ==========================================
    // 1. Tower of Hanoi
    // ==========================================
    private static int hanoiMovesCount = 0;

    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("  Move disk 1 from " + source + " to " + destination);
            hanoiMovesCount++;
            return;
        }
        // Move top N-1 disks from Source to Auxiliary
        solveHanoi(n - 1, source, destination, auxiliary);
        
        // Move the Nth disk from Source to Destination
        System.out.println("  Move disk " + n + " from " + source + " to " + destination);
        hanoiMovesCount++;
        
        // Move the N-1 disks from Auxiliary to Destination
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static int getHanoiMovesCount() {
        return hanoiMovesCount;
    }

    // ==========================================
    // 2. Binary Search on Sorted Price List
    // ==========================================
    public static int binarySearch(double[] prices, double target, int low, int high) {
        if (low > high) {
            return -1; // Base case: Element not found
        }

        int mid = low + (high - low) / 2;

        if (prices[mid] == target) {
            return mid; // Base case: Element found
        }

        if (prices[mid] > target) {
            return binarySearch(prices, target, low, mid - 1); // Search left half
        } else {
            return binarySearch(prices, target, mid + 1, high); // Search right half
        }
    }

    // ==========================================
    // 3. Sum of Digits
    // ==========================================
    public static int sumOfDigits(int n) {
        n = Math.abs(n); // Guard against negative inputs
        if (n < 10) {
            return n; // Base case: Single digit left
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    // ==========================================
    // 4. Reverse a String
    // ==========================================
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str; // Base case
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // ==========================================
    // 5. Balanced Parentheses (No Stack)
    // ==========================================
    public static boolean isBalanced(String str) {
        return checkBalanceHelper(str, 0, 0);
    }

    private static boolean checkBalanceHelper(String str, int index, int balance) {
        // Base case 1: Closing bracket appeared without a matching open bracket
        if (balance < 0) {
            return false;
        }
        // Base case 2: End of string evaluated
        if (index == str.length()) {
            return balance == 0;
        }

        char current = str.charAt(index);
        if (current == '(') {
            return checkBalanceHelper(str, index + 1, balance + 1);
        } else if (current == ')') {
            return checkBalanceHelper(str, index + 1, balance - 1);
        }

        // Skip non-parenthesis characters
        return checkBalanceHelper(str, index + 1, balance);
    }

    // ==========================================
    // Execution Driver (Main)
    // ==========================================
    public static void main(String[] args) {
        System.out.println("=== 1. Tower of Hanoi ===");
        int disks = 3;
        System.out.println("Steps to solve for " + disks + " disks:");
        solveHanoi(disks, 'A', 'B', 'C');
        System.out.println("Total moves computed: " + getHanoiMovesCount());
        System.out.println();

        System.out.println("=== 2. Binary Search on Price List ===");
        double[] storePrices = {4.99, 12.50, 19.99, 45.00, 89.95, 120.00};
        double target = 45.00;
        System.out.println("Sorted Price List: " + Arrays.toString(storePrices));
        int searchResult = binarySearch(storePrices, target, 0, storePrices.length - 1);
        System.out.println("Price " + target + "$ found at index: " + searchResult);
        System.out.println();

        System.out.println("=== 3. Sum of Digits ===");
        int sampleNumber = 9876;
        System.out.println("Sum of digits for " + sampleNumber + " is: " + sumOfDigits(sampleNumber));
        System.out.println();

        System.out.println("=== 4. Reverse a String ===");
        String originalText = "Algorithm";
        System.out.println("Original String: " + originalText);
        System.out.println("Reversed String: " + reverseString(originalText));
        System.out.println();

        System.out.println("=== 5. Balanced Parentheses ===");
        String cleanExpr = "(a + (b * c) - d)";
        String brokenExpr = ")(a + b))";
        System.out.println("Is '" + cleanExpr + "' balanced? -> " + isBalanced(cleanExpr));
        System.out.println("Is '" + brokenExpr + "' balanced? -> " + isBalanced(brokenExpr));
    }
}