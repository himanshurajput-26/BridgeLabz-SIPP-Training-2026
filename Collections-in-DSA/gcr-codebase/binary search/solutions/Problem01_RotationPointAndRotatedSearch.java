import java.util.Arrays;

public class Problem01_RotationPointAndRotatedSearch {

    public static int findRotationPointIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                // Works correctly even if duplicates appear.
                right--;
            }
        }

        return left;
    }

    public static int findMinimumElement(int[] arr) {
        int index = findRotationPointIndex(arr);
        return index == -1 ? -1 : arr[index];
    }

    public static int searchInRotatedSortedArray(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] rotated = {15, 18, 2, 3, 6, 12};
        System.out.println("Array: " + Arrays.toString(rotated));
        System.out.println("Rotation point index: " + findRotationPointIndex(rotated));
        System.out.println("Minimum element: " + findMinimumElement(rotated));
        System.out.println("Index of 6 in rotated array: " + searchInRotatedSortedArray(rotated, 6));
    }
}
