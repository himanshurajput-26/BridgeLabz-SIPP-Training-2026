import java.util.Scanner;

public class DetailedCharacterMapper {

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    // Formulates a comprehensive layout matrix for string inspection pipelines
    public static String[][] mapCharacterMatrix(String text) {
        String[][] matrix = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            matrix[i][0] = String.valueOf(ch);
            matrix[i][1] = checkCharacterType(ch);
        }
        return matrix;
    }

    public static void printCharacterTable(String[][] matrix) {
        System.out.println("\n=========================");
        System.out.printf("%-10s | %-12s\n", "Character", "Type");
        System.out.println("=========================");
        for (String[] row : matrix) {
            String displayChar = row[0].equals(" ") ? "[Space]" : row[0];
            System.out.printf("%-10s | %-12s\n", displayChar, row[1]);
        }
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to map: ");
        String text = sc.nextLine();

        String[][] matrix = mapCharacterMatrix(text);
        printCharacterTable(matrix);
        
        sc.close();
    }
}