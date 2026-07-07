public class HospitalEmergency {
    public static int findKthHighest(int[] nums, int k) {
        // kth highest is matching target index (N - k) inside ascending layout
        int targetIdx = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIdx);
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];
        int pivotIndex = partition(nums, low, high);
        
        if (pivotIndex == k) return nums[k];
        else if (pivotIndex < k) return quickSelect(nums, pivotIndex + 1, high, k);
        else return quickSelect(nums, low, pivotIndex - 1, k);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] priorities = {10, 30, 15, 50, 40};
        int k = 2;
        System.out.println("Kth Highest Priority: " + findKthHighest(priorities, k)); // Output: 40
    }
}