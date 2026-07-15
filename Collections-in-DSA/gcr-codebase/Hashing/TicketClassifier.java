import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketClassifier {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>(); // cite: 960
        
        for (String s : strs) { // cite: 960
            char[] chars = s.toCharArray(); // cite: 961
            Arrays.sort(chars); // Sort to create a uniform signature string cite: 962
            String key = new String(chars); // cite: 963
            
            // Map signature key directly to list buckets
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s); // cite: 965
        }
        return new ArrayList<>(groups.values()); // cite: 967
    }
}