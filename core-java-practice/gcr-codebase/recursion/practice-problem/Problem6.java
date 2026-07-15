public class Problem6 {
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        // Recursive rule
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n)); // Output: 8
    }
}