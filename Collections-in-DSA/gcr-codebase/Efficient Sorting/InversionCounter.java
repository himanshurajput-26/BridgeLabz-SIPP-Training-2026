import java.util.*;

public class InversionCounter {
    public static long countInversions(long[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static long mergeSortAndCount(long[] arr, int l, int r) {
        long count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    private static long mergeAndCount(long[] arr, int l, int m, int r) {
        long[] left = Arrays.copyOfRange(arr, l, m + 1);
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        long swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (left.length - i); // Core Inversion logic
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
        return swaps;
    }

    public static void main(String[] args) {
        // Employee promotion conflicts verification
        long[] scores = {70, 95, 80, 100};
        System.out.println("Promotion Conflicts: " + countInversions(scores)); // Output: 4
    }
}