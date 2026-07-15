import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
    public int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>(); // cite: 895
        int bestCode = codes[0]; // cite: 895
        int bestCount = 0; // cite: 895

        for (int code : codes) { // cite: 896
            // Dynamically increment frequency tracking count
            int count = freq.merge(code, 1, Integer::sum); // cite: 897
            
            if (count > bestCount) { // cite: 897
                bestCount = count; // cite: 898
                bestCode = code; // cite: 899
            }
        }
        return bestCode; // cite: 902
    }
}