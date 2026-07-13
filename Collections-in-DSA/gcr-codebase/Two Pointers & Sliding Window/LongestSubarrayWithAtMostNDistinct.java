import java.util.*;

public int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
    Map<Integer, Integer> freq = new HashMap<>();
    int start = 0;
    int maxLen = 0;
    
    for (int end = 0; end < keyIds.length; end++) {
        freq.merge(keyIds[end], 1, Integer::sum);
        
        // Shrink the window if the count of distinct keys exceeds 'n'
        while (freq.size() > n) {
            int leftKey = keyIds[start];
            freq.put(leftKey, freq.get(leftKey) - 1);
            if (freq.get(leftKey) == 0) {
                freq.remove(leftKey);
            }
            start++;
        }
        // Update longest valid window length found so far
        maxLen = Math.max(maxLen, end - start + 1);
    }
    return maxLen;
}