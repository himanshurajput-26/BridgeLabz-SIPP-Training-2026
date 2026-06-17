class OTPGenerator {

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static boolean checkUnique(int[] otpArray) {

        for (int i = 0; i < otpArray.length; i++) {

            for (int j = i + 1; j < otpArray.length; j++) {

                if (otpArray[i] == otpArray[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] otpNumbers = new int[10];

        System.out.println("Generated OTPs:");

        for (int i = 0; i < otpNumbers.length; i++) {

            otpNumbers[i] = generateOTP();
            System.out.println(otpNumbers[i]);
        }

        boolean unique = checkUnique(otpNumbers);

        System.out.println("\nAll OTPs Unique: " + unique);
    }
}