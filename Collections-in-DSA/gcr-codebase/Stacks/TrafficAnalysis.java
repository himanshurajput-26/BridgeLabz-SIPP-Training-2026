import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class TrafficAnalysis {
    public static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length; // cite: 116
        int[] answer = new int[n]; // cite: 117
        Arrays.fill(answer, -1); // cite: 118
        
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices with decreasing visitor counts cite: 119

        for (int i = 0; i < n; i++) { // cite: 120
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) { // cite: 121, 122
                answer[stack.pop()] = visitors[i]; // The current day is the next greater element cite: 123
            }
            stack.push(i); // cite: 125
        }
        return answer; // cite: 127
    }
}