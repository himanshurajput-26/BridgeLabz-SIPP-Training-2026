import java.util.Scanner;

public class CharacterTypeCounter {

    // Resolves identity profiles of standalone characters via standard ASCII maps
    public static String checkCharacterType(char ch) {
        // Shift uppercase alphabets downwards towards lowercase baseline values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] aggregateCounts(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Provide string parsing parameters: ");
        String text = sc.nextLine();

        int[] totals = aggregateCounts(text);

        System.out.println("\n--- Linguistic Counts ---");
        System.out.println("Vowels Count:     " + totals[0]);
        System.out.println("Consonants Count: " + totals[1]);
        
        sc.close();
    }
}