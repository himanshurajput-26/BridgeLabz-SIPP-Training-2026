public class Problem2 {
    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive step: n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(factorial(N)); // Output: 120
    }
}