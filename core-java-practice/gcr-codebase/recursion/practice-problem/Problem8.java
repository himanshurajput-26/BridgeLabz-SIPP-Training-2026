import java.util.ArrayList;
import java.util.List;

public class Problem8 {
    public static void findSubsets(int[] arr, int index, List<Integer> current) {
        // Base case: when we have evaluated all elements
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Choice 1: Exclude the current element
        findSubsets(arr, index + 1, current);

        // Choice 2: Include the current element
        current.add(arr[index]);
        findSubsets(arr, index + 1, current);
        
        // Backtrack to clean up state for previous branches
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        findSubsets(arr, 0, new ArrayList<>());
    }
}