import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Scenario 2: BFS shortest path with parent pointers.
 */
class FewestConnectingFlights {
    public List<Integer> fewestFlights(Map<Integer, List<Integer>> routes, int origin, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new java.util.HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            if (city == destination) {
                break;
            }
            for (int next : routes.getOrDefault(city, Collections.emptyList())) {
                if (visited.add(next)) {
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination)) {
            return Collections.emptyList();
        }

        LinkedList<Integer> path = new LinkedList<>();
        Integer node = destination;
        while (node != null) {
            path.addFirst(node);
            node = parent.get(node);
        }
        return path;
    }
}
