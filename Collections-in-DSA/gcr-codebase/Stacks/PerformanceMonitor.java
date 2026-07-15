import java.util.ArrayDeque;
import java.util.Deque;

class PerformanceMonitor {
    public static int[] loadSpan(int[] load) {
        int n = load.length; // cite: 142
        int[] span = new int[n]; // cite: 143
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices with decreasing loads cite: 144

        for (int i = 0; i < n; i++) { // cite: 145
            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) { // cite: 146
                stack.pop(); // cite: 146
            }
            // If empty, it's larger than all previous elements (span = i + 1)
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek()); // cite: 148
            stack.push(i); // cite: 149
        }
        return span; // cite: 151
    }
}