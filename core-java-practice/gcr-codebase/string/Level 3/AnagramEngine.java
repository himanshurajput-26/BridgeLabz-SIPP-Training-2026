import java.util.Scanner;

public class AnagramEngine {

    public static boolean evaluateAnagramStatus(String primary, String secondary) {
        if (primary.length() != secondary.length()) {
            return false;
        }

        int[] primaryFrequencyTable = new int[256];
        int[] secondaryFrequencyTable = new int[256];

        for (int i = 0; i < primary.length(); i++) {
            primaryFrequencyTable[primary.charAt(i)]++;
            secondaryFrequencyTable[secondary.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (primaryFrequencyTable[i] != secondaryFrequencyTable[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first textual input string: ");
        String first = sc.nextLine();
        System.out.print("Enter second textual input string: ");
        String second = sc.nextLine();

        String cleanFirst = first.replaceAll("\\s+", "").toLowerCase();
        String cleanSecond = second.replaceAll("\\s+", "").toLowerCase();

        boolean isAnagram = evaluateAnagramStatus(cleanFirst, cleanSecond);

        System.out.println("\n--- Anagram Analysis Outcome ---");
        System.out.println("Are the entered strings anagram configurations? -> " + isAnagram);
        
        sc.close();
    }
}