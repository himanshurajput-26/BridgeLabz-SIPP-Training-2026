public class Problem3 {
    public static int sumOfNatural(int n) {
        // Base case
        if (n <= 0) {
            return 0;
        }
        // Recursive step
        return n + sumOfNatural(n - 1);
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(sumOfNatural(N)); // Output: 15
    }
}