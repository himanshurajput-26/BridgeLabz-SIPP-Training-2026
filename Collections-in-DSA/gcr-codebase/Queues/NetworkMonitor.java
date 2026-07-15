import java.util.ArrayDeque;
import java.util.Deque; // cite: 287

class NetworkMonitor {
    public static int[] maxThroughputWindow(int[] readings, int k) {
        int n = readings.length; // cite: 285
        if (n == 0 || k == 0) return new int[0];
        
        int[] result = new int[n - k + 1]; // cite: 286
        Deque<Integer> deque = new ArrayDeque<>(); // Stores indices with decreasing values front-to-back [cite: 287]

        for (int i = 0; i < n; i++) {
            // 1. Remove elements out of the current sliding window frame
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) { // cite: 289
                deque.pollFirst(); // cite: 291
            }

            // 2. Remove elements from the back that are smaller than the current reading
            while (!deque.isEmpty() && readings[deque.peekLast()] <= readings[i]) { // cite: 292
                deque.pollLast(); // cite: 294
            }

            // 3. Add current element's index
            deque.offerLast(i); // cite: 295

            // 4. Save the maximum for the window (always at the front)
            if (i >= k - 1) { // cite: 296
                result[i - k + 1] = readings[deque.peekFirst()]; // cite: 297
            }
        }
        return result; // cite: 300
    }
}