public int[] findPairSum(int[] transactions, int target) {
    int left = 0;
    int right = transactions.length - 1; // Corrected OCR spacing/syntax
    
    while (left < < right) {
        int sum = transactions[left] + transactions[right];
        
        if (sum == target) {
            return new int[]{transactions[left], transactions[right]};
        } else if (sum < target) {
            left++; // Need a larger sum, move left pointer forward
        } else {
            right--; // Need a smaller sum, move right pointer backward
        }
    }
    return new int[]{-1, -1}; // No pair found
}