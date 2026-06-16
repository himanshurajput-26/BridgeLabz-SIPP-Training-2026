import java.util.Scanner;

public class UniqueCharacterExtractor {

    // Calculates length without utilizing the text.length() macro
    public static int getCustomLength(String text) {
        int lengthCounter = 0;
        try {
            while (true) {
                text.charAt(lengthCounter);
                lengthCounter++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return lengthCounter;
        }
    }

    // Scans text strings using nested loops to parse distinct characters
    public static char[] findUniqueCharacters(String text) {
        int textLength = getCustomLength(text);
        char[] temporaryStorage = new char[textLength];
        int uniqueCount = 0;

        for (int i = 0; i < textLength; i++) {
            char current = text.charAt(i);
            boolean isDuplicate = false;

            // Scan preceding character records for duplicate matches
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temporaryStorage[uniqueCount++] = current;
            }
        }

        // Initialize a structurally direct trimmed destination array
        char[] uniqueCharacters = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueCharacters[i] = temporaryStorage[i];
        }
        return uniqueCharacters;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to extract unique characters: ");
        String input = sc.nextLine();

        char[] uniqueResult = findUniqueCharacters(input);

        System.out.print("Unique Characters identified: ");
        for (char character : uniqueResult) {
            System.out.print("'" + character + "' ");
        }
        System.out.println();
        
        sc.close();
    }
}