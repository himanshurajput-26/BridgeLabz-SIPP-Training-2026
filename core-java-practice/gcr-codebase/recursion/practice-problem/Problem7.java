public class Problem7 {
    public static int power(int x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        // Recursive call
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(power(x, n)); // Output: 32
    }
}