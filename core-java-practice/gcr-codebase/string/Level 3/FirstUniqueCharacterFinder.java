import java.util.Scanner;

public class FirstUniqueCharacterFinder {

    public static char locateFirstNonRepeatingChar(String text) {
        int[] frequencyLedger = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char characterValue = text.charAt(i);
            frequencyLedger[characterValue]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char characterValue = text.charAt(i);
            if (frequencyLedger[characterValue] == 1) {
                return characterValue;
            }
        }
        
        return '\0'; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter structural text input string: ");
        String input = sc.nextLine();

        char entryValue = locateFirstNonRepeatingChar(input);

        if (entryValue != '\0') {
            System.out.println("The first non-repeating character is: '" + entryValue + "'");
        } else {
            System.out.println("No distinct non-repeating character was discovered inside the sequence.");
        }
        
        sc.close();
    }
}