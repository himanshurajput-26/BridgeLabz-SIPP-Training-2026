import java.util.Scanner;

public class StringToCharArray {

    // Convert string to character array manually
    public static char[] getCustomCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    // Compare two character arrays
    public static boolean compareCharArrays(char[] array1, char[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        char[] customArray = getCustomCharArray(text);
        char[] builtinArray = text.toCharArray();

        boolean match = compareCharArrays(customArray, builtinArray);
        System.out.println("Do the custom array and built-in array match? " + match);
        
        sc.close();
    }
}