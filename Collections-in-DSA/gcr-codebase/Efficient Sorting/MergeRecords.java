public class MergeRecords {
    public static int[] mergeBranches(int[] branchA, int[] branchB) {
        int[] result = new int[branchA.length + branchB.length];
        int i = 0, j = 0, k = 0;

        while (i < branchA.length && j < branchB.length) {
            if (branchA[i] <= branchB[j]) {
                result[k++] = branchA[i++];
            } else {
                result[k++] = branchB[j++];
            }
        }

        while (i < branchA.length) result[k++] = branchA[i++];
        while (j < branchB.length) result[k++] = branchB[j++];

        return result;
    }

    public static void main(String[] args) {
        int[] branchA = {1, 4, 8};
        int[] branchB = {2, 5, 7};
        int[] res = mergeBranches(branchA, branchB);
        System.out.print("Merged Records: ");
        for (int val : res) System.out.print(val + " "); // Output: 1 2 4 5 7 8
    }
}