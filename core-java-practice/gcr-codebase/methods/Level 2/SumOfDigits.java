public class SumOfDigits {

    // Get a 4 digit random number [cite: 18]
    public int get4DigitRandomNumber() {
        return (int) (Math.random() * 9000) + 1000; // Generates between 1000 and 9999 [cite: 20]
    }

    // Find the count of digits in the number [cite: 21]
    public int countDigits(int number) {
        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // Store the digits of the number in an array [cite: 30]
    public int[] getDigits(int number, int count) {
        int[] digits = new int[count];
        int temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    // Find the sum of the elements in an array [cite: 40]
    public int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();
        
        int number = sumOfDigits.get4DigitRandomNumber();
        System.out.println("The Random Number is: " + number);

        int count = sumOfDigits.countDigits(number);
        System.out.println("The count of digit is: " + count);

        int[] digits = sumOfDigits.getDigits(number, count);
        
        int sum = sumOfDigits.sumArray(digits);
        System.out.println("\nSum of Digits: " + sum);
    }
}