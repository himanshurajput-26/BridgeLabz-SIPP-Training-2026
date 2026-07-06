public class BubbleSortAthletes {
    public static void sortScores(int[] scores) {
        int n = scores.length;
        int totalSwaps = 0;
        boolean isAlreadySorted = true; // Flag for best case tracking

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (scores[j] > scores[j + 1]) {
                    // Swap elements
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    
                    swapped = true;
                    totalSwaps++;
                }
            }
            // If no elements were swapped in the first pass, array is already sorted
            if (i == 0 && !swapped) {
                break; 
            }
            if (!swapped) break;
            isAlreadySorted = false;
        }

        System.out.println("Total Swaps: " + totalSwaps);
        System.out.println("Was already sorted? " + isAlreadySorted);
    }
}