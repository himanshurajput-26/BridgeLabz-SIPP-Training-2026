import java.util.Arrays;

public class Problem02_PeakElement {

    public static int findPeakElementIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int findPeakElementValue(int[] arr) {
        int index = findPeakElementIndex(arr);
        return index == -1 ? -1 : arr[index];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int index = findPeakElementIndex(arr);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Peak index: " + index);
        System.out.println("Peak value: " + (index == -1 ? -1 : arr[index]));
    }
}
