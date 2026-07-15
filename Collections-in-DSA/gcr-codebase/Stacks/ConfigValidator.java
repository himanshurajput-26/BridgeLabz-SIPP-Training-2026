import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class ConfigValidator {
    public static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // cite: 89
        
        // Map matching closing brackets to opening brackets
        Map<Character, Character> matchFor = Map.of(')', '(', ']', '[', '}', '{'); // cite: 90, 92

        for (char c : s.toCharArray()) { // cite: 91
            if (c == '(' || c == '[' || c == '{') { // cite: 93
                stack.push(c); // cite: 94
            } else if (matchFor.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != matchFor.get(c)) { // cite: 96
                    return false; 
                }
            }
        }
        return stack.isEmpty(); // cite: 99
    }
}