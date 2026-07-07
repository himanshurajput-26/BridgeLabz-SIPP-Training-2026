import java.util.Arrays;

public class BankFraudDetection {
    public static int suspiciousPairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);
        
        // Count valid pairs before actual merge sorting phase
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 3L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        
        Arrays.sort(nums, low, high + 1); // Internal merge sub-array container step
        return count;
    }

    public static void main(String[] args) {
        int[] transactions = {12, 4, 5, 2};
        System.out.println("Suspicious Fraud Pairs: " + suspiciousPairs(transactions)); // Output: 3
    }
}