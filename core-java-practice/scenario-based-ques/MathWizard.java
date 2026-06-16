public class MathWizard {

    // Instance variable (Field)
    // Accessible by any instance method in this class. Tracks how many operations this wizard has performed.
    private int operationsCount = 0; 

    /**
     * Increments the operation counter.
     * Demonstrates instance variable modification.
     */
    private void incrementCount() {
        this.operationsCount++;
    }

    /**
     * Gets the total operations performed by this instance.
     */
    public int getOperationsCount() {
        return this.operationsCount;
    }

    /**
     * Checks if a number is prime.
     */
    public boolean isPrime(int n) {
        incrementCount();
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Calculates factorial using iteration (integer version).
     */
    public long factorial(int n) {
        incrementCount();
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative.");
        
        // 'result' and 'i' are local variables. 
        // They only exist inside this method during its execution.
        long result = 1; 
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Overloaded factorial method that accepts a double.
     * Uses Gamma function approximation (Lanczos approximation) for non-integers,
     * or delegates to standard iteration if it happens to be a whole number.
     */
    public double factorial(double n) {
        incrementCount();
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative.");
        
        // If it's effectively an integer, use the precise iterative version
        if (n == Math.floor(n)) {
            return (double) factorial((int) n);
        }

        // Lanczos approximation for continuous factorial (Gamma(n+1))
        double x = n + 1;
        double[] p = {
            0.99999999999980993, 676.5203681218851, -1259.1392167224028,
            771.32342877765313, -176.61502916214059, 12.507343278686905,
            -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7
        };
        
        double g = 7;
        double max = p[0];
        for (int i = 1; i < p.length; i++) {
            max += p[i] / (x + i - 1);
        }
        
        double t = x + g - 0.5;
        return Math.sqrt(2 * Math.PI) * Math.pow(t, x - 0.5) * Math.exp(-t) * max / n;
    }

    /**
     * Returns the Nth Fibonacci number (0-indexed: fib(0)=0, fib(1)=1).
     */
    public long fibonacci(int n) {
        incrementCount();
        if (n < 0) throw new IllegalArgumentException("Index cannot be negative.");
        if (n == 0) return 0;
        if (n == 1) return 1;

        long prev = 0, current = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    /**
     * Computes Greatest Common Divisor using the Euclidean algorithm.
     */
    public int gcd(int a, int b) {
        incrementCount();
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /**
     * Computes Least Common Multiple.
     */
    public int lcm(int a, int b) {
        incrementCount();
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b); 
    }

    /**
     * Computes base raised to the power of exp (handles negative exponents).
     */
    public double power(double base, int exp) {
        incrementCount();
        if (exp == 0) return 1;
        
        long numExp = exp;
        if (numExp < 0) {
            base = 1 / base;
            numExp = -numExp;
        }

        double result = 1;
        while (numExp > 0) {
            if ((numExp & 1) == 1) {
                result *= base;
            }
            base *= base;
            numExp >>= 1;
        }
        return result;
    }
}