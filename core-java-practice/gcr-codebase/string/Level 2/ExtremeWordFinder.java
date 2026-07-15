import java.util.Scanner;

public class ExtremeWordFinder {

    public static int getCustomLength(String text) {
        int count = 0;
        try {
            while (true) { text.charAt(count); count++; }
        } catch (StringIndexOutOfBoundsException e) { return count; }
    }

    public static String[] customSplit(String text) {
        int length = getCustomLength(text);
        int spaces = 0;
        for (int i = 0; i < length; i++) if (text.charAt(i) == ' ') spaces++;
        String[] words = new String[spaces + 1];
        int wIdx = 0; String word = "";
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                words[wIdx++] = word; word = "";
            } else { word += text.charAt(i); }
        }
        words[wIdx] = word;
        return words;
    }

    public static String[][] buildWordLengthMatrix(String[] words) {
        String[][] matrix = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            matrix[i][0] = words[i];
            matrix[i][1] = String.valueOf(getCustomLength(words[i]));
        }
        return matrix;
    }

    // Evaluates longest/shortest elements, returns their index pointers inside a 1D Array
    public static int[] findExtremeIndices(String[][] matrix) {
        int shortestIdx = 0;
        int longestIdx = 0;
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int currentLen = Integer.parseInt(matrix[i][1]);
            if (currentLen < minLen) {
                minLen = currentLen;
                shortestIdx = i;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
                longestIdx = i;
            }
        }
        return new int[]{shortestIdx, longestIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your text data line: ");
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] matrix = buildWordLengthMatrix(words);
        int[] resultIndices = findExtremeIndices(matrix);

        System.out.println("\n--- Analysis Output ---");
        System.out.println("Shortest Word: " + matrix[resultIndices[0]][0]);
        System.out.println("Longest Word:  " + matrix[resultIndices[1]][0]);
        
        sc.close();
    }
}