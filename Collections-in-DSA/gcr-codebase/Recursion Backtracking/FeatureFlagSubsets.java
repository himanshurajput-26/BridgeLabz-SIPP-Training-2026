import java.util.ArrayList;
import java.util.List;

public class FeatureFlagSubsets {

    public List<List<String>> generateFlagCombinations(String[] flags) {
        List<List<String>> result = new ArrayList<>();
        backtrack(flags, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String[] flags, int index, List<String> current, List<List<String>> result) {
        if (index == flags.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(flags[index]);
        backtrack(flags, index + 1, current, result);
        current.remove(current.size() - 1);

        backtrack(flags, index + 1, current, result);
    }
}
