import java.util.HashSet;
import java.util.Set;

public class SessionTracker {
    public boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>(); // cite: 873
        for (String token : tokens) { // cite: 874
            if (!seen.add(token)) { // Returns false if the token was already present cite: 875
                return true; // Duplicate collision detected cite: 876
            }
        }
        return false; // cite: 879
    }
}