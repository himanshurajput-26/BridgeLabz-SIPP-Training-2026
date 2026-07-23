import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Scenario 1: Sparse friend graph representation.
 *
 * Use an adjacency-list style structure backed by HashSet so we keep
 * O(V + E) space and get average O(1) friendship lookups.
 */
class SparseFriendGraph {
    private final Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }
}
