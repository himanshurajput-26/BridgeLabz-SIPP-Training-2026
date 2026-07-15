import java.util.HashMap;
import java.util.Map;

public class FraudDetector {
    public int[] findFraudPair(int[] amounts, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // Maps: transaction amount -> index value cite: 918
        
        for (int i = 0; i < amounts.length; i++) { // cite: 919
            int complement = target - amounts[i]; // cite: 920
            
            // Check lookup existence prior to saving index
            if (seen.containsKey(complement)) { // cite: 921
                return new int[]{seen.get(complement), i}; // Return original paired indices cite: 922
            }
            seen.put(amounts[i], i); // cite: 924
        }
        return new int[]{-1, -1}; // cite: 926
    }
}