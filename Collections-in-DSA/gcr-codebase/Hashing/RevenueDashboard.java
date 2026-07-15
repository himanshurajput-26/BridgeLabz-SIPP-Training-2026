import java.util.HashMap;
import java.util.Map;

public class RevenueDashboard {
    public int subarraySumEqualsK(int[] revenueChanges, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>(); // cite: 940
        prefixCount.put(0, 1); // Base match case initialization cite: 940

        int runningSum = 0; // cite: 942
        int answer = 0; // cite: 942

        for (int change : revenueChanges) { // cite: 943
            runningSum += change; // cite: 944
            
            // Query map for match differences
            answer += prefixCount.getOrDefault(runningSum - k, 0); // cite: 945
            
            // Store current running prefix configuration
            prefixCount.merge(runningSum, 1, Integer::sum); // cite: 946
        }
        return answer; // cite: 947
    }
}