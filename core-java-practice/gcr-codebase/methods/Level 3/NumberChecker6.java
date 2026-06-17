class NumberChecker6 {

    public static int sumOfDivisors(int number) {

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static boolean isPerfect(int number) {
        return sumOfDivisors(number) == number;
    }

    public static boolean isAbundant(int number) {
        return sumOfDivisors(number) > number;
    }

    public static boolean isDeficient(int number) {
        return sumOfDivisors(number) < number;
    }

    public static int factorial(int number) {

        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static boolean isStrong(int number) {

        int temp = number;
        int sum = 0;

        while (temp > 0) {

            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {

        int number = 145;

        System.out.println("Perfect Number: " + isPerfect(number));
        System.out.println("Abundant Number: " + isAbundant(number));
        System.out.println("Deficient Number: " + isDeficient(number));
        System.out.println("Strong Number: " + isStrong(number));
    }
}