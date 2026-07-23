import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Scenario 3: DFS with backtracking to enumerate all simple paths.
 */
class AllDeliveryRoutes {
    public void allRoutes(
            Map<Integer, List<Integer>> roads,
            int current,
            int target,
            List<Integer> path,
            Set<Integer> visited,
            List<List<Integer>> allRoutes) {

        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    allRoutes(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }
}
