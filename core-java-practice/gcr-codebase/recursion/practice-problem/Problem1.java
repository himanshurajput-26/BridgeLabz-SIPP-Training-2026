public class Problem1 {
    public static void printDescending(int n) {
        // Base case
        if (n < 1) {
            return;
        }
        // Print current number
        System.out.print(n);
        // Recursive call
        printDescending(n - 1);
    }

    public static void main(String[] args) {
        int N = 5;
        printDescending(N); // Output: 54321
        System.out.println();
    }
}