public class MovieRatingsSorter {
    public static void sortRatings(int[] ratings) {
        int n = ratings.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = ratings[minIdx];
            ratings[minIdx] = ratings[i];
            ratings[i] = temp;
        }
    }
}