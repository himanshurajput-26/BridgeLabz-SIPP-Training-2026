interface CouponValidator {
    // Abstract validation check
    boolean validateCoupon(String code);

    // Static utility method to check code length constraints
    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 10;
    }
}

class ShoppingCart implements CouponValidator {
    @Override
    public boolean validateCoupon(String code) {
        // A coupon is considered valid if its length is correct and it starts with "SAVE" or "DISC"
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.startsWith("SAVE") || code.startsWith("DISC");
    }

    public void processCoupons(String[] couponCodes) {
        System.out.println("=== Processing Coupon Validations ===");
        for (String code : couponCodes) {
            boolean isValid = validateCoupon(code);
            System.out.println("Coupon: [" + code + "] -> " + (isValid ? "VALID" : "INVALID"));
        }
    }
}