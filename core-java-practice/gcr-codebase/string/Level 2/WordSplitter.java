import java.util.Scanner;

public class WordSplitter {

    public static int getCustomLength(String text) {
        int count = 0;
        try {
            while (true) { text.charAt(count); count++; }
        } catch (StringIndexOutOfBoundsException e) { return count; }
    }

    // Custom method to split string by blank spaces
    public static String[] customSplit(String text) {
        int length = getCustomLength(text);
        if (length == 0) return new String[0];

        // 1. Count space delimiters to establish structure
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        // 2. Map delimiter coordinate positions
        int[] spaceIndexes = new int[spaceCount];
        int indexTracker = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[indexTracker++] = i;
            }
        }

        // 3. Extract segmented string words using mapped spacing markers
        String[] words = new String[spaceCount + 1];
        int wordStartIndex = 0;
        
        for (int i = 0; i <= spaceCount; i++) {
            int wordEndIndex = (i < spaceCount) ? spaceIndexes[i] : length;
            String word = "";
            for (int j = wordStartIndex; j < wordEndIndex; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
            wordStartIndex = wordEndIndex + 1;
        }
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence string: ");
        String text = sc.nextLine();

        String[] customWords = customSplit(text);
        String[] builtinWords = text.split(" ");

        boolean listsAreEqual = compareStringArrays(customWords, builtinWords);
        System.out.println("Custom split validation matches native arrays? " + listsAreEqual);
        
        sc.close();
    }
}