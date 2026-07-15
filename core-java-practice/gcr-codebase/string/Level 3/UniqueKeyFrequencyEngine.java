import java.util.Scanner;

public class UniqueKeyFrequencyEngine {

    public static char[] extractUniqueKeys(String text) {
        char[] tempArray = new char[text.length()];
        int distinctIndexCounter = 0;

        for (int i = 0; i < text.length(); i++) {
            char targetChar = text.charAt(i);
            boolean existsInSet = false;

            for (int j = 0; j < distinctIndexCounter; j++) {
                if (tempArray[j] == targetChar) {
                    existsInSet = true;
                    break;
                }
            }
            if (!existsInSet) {
                tempArray[distinctIndexCounter++] = targetChar;
            }
        }

        char[] distinctKeys = new char[distinctIndexCounter];
        for (int i = 0; i < distinctIndexCounter; i++) {
            distinctKeys[i] = tempArray[i];
        }
        return distinctKeys;
    }

    public static String[][] buildFrequencyReport(String text) {
        int[] globalAsciiRegistry = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            globalAsciiRegistry[text.charAt(i)]++;
        }

        char[] keys = extractUniqueKeys(text); 
        String[][] summaryTable = new String[keys.length][2];

        for (int i = 0; i < keys.length; i++) {
            summaryTable[i][0] = String.valueOf(keys[i]);
            summaryTable[i][1] = String.valueOf(globalAsciiRegistry[keys[i]]);
        }
        return summaryTable;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Provide string parsing parameters: ");
        String text = sc.nextLine();

        String[][] assessmentRecords = buildFrequencyReport(text);

        System.out.println("\n=== Key Distribution Records ===");
        for (String[] record : assessmentRecords) {
            String label = record[0].equals(" ") ? "[Space]" : record[0];
            System.out.println("Character: '" + label + "' | Instances Found: " + record[1]);
        }
        
        sc.close();
    }
}