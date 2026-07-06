public class BubbleSortSwapCount {
    public static int getSwapCount(int[] nums) {
        int n = nums.length;
        int swapCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
}