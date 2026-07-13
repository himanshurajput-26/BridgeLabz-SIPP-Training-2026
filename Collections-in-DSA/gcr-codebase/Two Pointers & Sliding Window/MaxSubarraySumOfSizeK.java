public int maxSubarrayOfSizek(int[] cpuLoad, int k) {
    int windowSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int start = 0;
    
    for (int end = 0; end < cpuLoad.length; end++) {
        windowSum += cpuLoad[end]; // Expand the window by adding the current reading
        
        // Once we hit the window size 'k', start sliding
        if (end >= k - 1) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= cpuLoad[start]; // Subtract the element leaving the window
            start++; // Move window start forward
        }
    }
    return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
}