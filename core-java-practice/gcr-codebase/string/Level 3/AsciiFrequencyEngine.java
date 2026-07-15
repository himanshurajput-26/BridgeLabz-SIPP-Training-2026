import java.util.Scanner;

public class AsciiFrequencyEngine {

    public static String[][] buildFrequencyMatrix(String text) {
        int[] globalAsciiCounts = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char characterValue = text.charAt(i);
            globalAsciiCounts[characterValue]++;
        }

        int distinctCount = 0;
        for (int count : globalAsciiCounts) {
            if (count > 0) distinctCount++;
        }

        String[][] frequencyMatrix = new String[distinctCount][2];
        boolean[] identityLogged = new boolean[256];
        int internalRowIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char characterValue = text.charAt(i);
            
            if (!identityLogged[characterValue]) {
                identityLogged[characterValue] = true;
                frequencyMatrix[internalRowIndex][0] = String.valueOf(characterValue);
                frequencyMatrix[internalRowIndex][1] = String.valueOf(globalAsciiCounts[characterValue]);
                internalRowIndex++;
            }
        }
        return frequencyMatrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter processing text string: ");
        String input = sc.nextLine();

        String[][] resultMatrix = buildFrequencyMatrix(input);

        System.out.println("\n=== Character Frequency Ledger ===");
        for (String[] row : resultMatrix) {
            String displayChar = row[0].equals(" ") ? "[Space]" : row[0];
            System.out.println("  " + displayChar + " -> Count: " + row[1]);
        }
        
        sc.close();
    }
}