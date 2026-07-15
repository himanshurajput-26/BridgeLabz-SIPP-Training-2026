import java.util.HashSet;
import java.util.Set;

public class MigrationTool {
    public int longestConsecutiveRun(int[] ids) {
        Set<Integer> idSet = new HashSet<>(); // cite: 985
        for (int id : ids) idSet.add(id); // cite: 986
        
        int longest = 0; // cite: 987
        
        for (int id : idSet) { // cite: 988
            // Verify if the current value is a true sequence start
            if (!idSet.contains(id - 1)) { // cite: 989
                int length = 1; // cite: 990
                int current = id; // cite: 991
                
                // Incrementally build sequential length counts
                while (idSet.contains(current + 1)) { // cite: 993
                    current++; // cite: 995
                    length++; // cite: 996
                }
                longest = Math.max(longest, length); // cite: 994
            }
        }
        return longest; // cite: 1001
    }
}