class NumberChecker4 {

    public static int[] getDigits(int number) {

        String str = String.valueOf(number);
        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        return digits;
    }

    public static int[] reverseArray(int[] digits) {

        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }

        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(int number) {

        int[] digits = getDigits(number);
        int[] reverse = reverseArray(digits);

        return compareArrays(digits, reverse);
    }

    public static boolean isDuckNumber(int[] digits) {

        for (int digit : digits) {
            if (digit == 0)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int number = 121;

        int[] digits = getDigits(number);

        System.out.println("Palindrome: " + isPalindrome(number));
        System.out.println("Duck Number: " + isDuckNumber(digits));
    }
}