interface LuggageScanner {
    boolean scanLuggage(double weight, boolean hasContraband);
    
    default void displaySecurityGuidelines() {
        System.out.println("Luggage Rule: Max weight 23kg. No flammable items or dangerous liquids.");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);
    
    default void displaySecurityGuidelines() {
        System.out.println("Passport Rule: Must be valid international biometric passport.");
    }
    
    static boolean isPassportNumberValid(String passportNo) {
        // Simple mock rule: Must start with a letter followed by 7 digits
        return passportNo != null && passportNo.matches("^[A-Z][0-9]{7}$");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    @Override
    public void displaySecurityGuidelines() {
        System.out.println("=== Airport Security Gate Requirements ===");
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    @Override
    public boolean scanLuggage(double weight, boolean hasContraband) {
        return weight <= 23.0 && !hasContraband;
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    public void processPassengers(String[] names, String[] passportNos, double[] weights, boolean[] contrabandFlags) {
        displaySecurityGuidelines();
        System.out.println("\n=== Boarding Clearances ===");
        for (int i = 0; i < names.length; i++) {
            boolean passportClear = verifyPassport(passportNos[i]);
            boolean luggageClear = scanLuggage(weights[i], contrabandFlags[i]);
            
            System.out.print("Passenger: " + names[i] + " -> ");
            if (passportClear && luggageClear) {
                System.out.println("BOARDING ALLOWED");
            } else {
                System.out.println("BOARDING DENIED (Reason: " + 
                    (!passportClear ? "Invalid Passport " : "") + (!luggageClear ? "Luggage Violation" : "") + ")");
            }
        }
    }
}