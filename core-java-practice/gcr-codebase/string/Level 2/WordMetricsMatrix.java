import java.util.Scanner;

public class WordMetricsMatrix {

    public static int getCustomLength(String text) {
        int count = 0;
        try {
            while (true) { text.charAt(count); count++; }
        } catch (StringIndexOutOfBoundsException e) { return count; }
    }

    public static String[] customSplit(String text) {
        int length = getCustomLength(text);
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }
        String[] words = new String[spaceCount + 1];
        int wordIndex = 0;
        String currentWord = "";
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                words[wordIndex++] = currentWord;
                currentWord = "";
            } else {
                currentWord += ch;
            }
        }
        words[wordIndex] = currentWord;
        return words;
    }

    // Converts word array to a 2D Matrix string metadata catalog
    public static String[][] buildWordLengthMatrix(String[] words) {
        String[][] matrix = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            matrix[i][0] = words[i];
            matrix[i][1] = String.valueOf(getCustomLength(words[i])); // Convert using valueOf [cite: 228]
        }
        return matrix;
    }

    public static void printMetricsTable(String[][] matrix) {
        System.out.println("\n=======================");
        System.out.printf("%-12s | %-6s\n", "Word", "Length");
        System.out.println("=======================");
        for (String[] row : matrix) {
            // Parse string length explicitly back to Integer when displaying [cite: 230]
            int lengthValue = Integer.parseInt(row[1]);
            System.out.printf("%-12s | %-6d\n", row[0], lengthValue);
        }
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text line: ");
        String text = sc.nextLine();

        String[] segments = customSplit(text);
        String[][] dataMatrix = buildWordLengthMatrix(segments);
        printMetricsTable(dataMatrix);

        sc.close();
    }
}