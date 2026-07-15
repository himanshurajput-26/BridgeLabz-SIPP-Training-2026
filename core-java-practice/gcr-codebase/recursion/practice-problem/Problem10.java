public class Problem10 {
    public static void generatePermutations(String str, String permutedStr) {
        // Base case: if original string is empty, we found a complete permutation
        if (str.length() == 0) {
            System.out.println(permutedStr);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            // Construct a new substring excluding the picked character
            String remainingStr = str.substring(0, i) + str.substring(i + 1);
            
            // Recursive call adding the picked character to our running permutation string
            generatePermutations(remainingStr, permutedStr + currChar);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        generatePermutations(str, "");
    }
}