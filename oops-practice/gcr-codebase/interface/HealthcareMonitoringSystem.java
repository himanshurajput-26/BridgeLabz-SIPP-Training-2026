interface HeartRateMonitor {
    default void displayHealthTips() {
        System.out.println("Heart Tip: Keep resting heart rate between 60-100 BPM via cardiovascular exercise.");
    }
}

interface TemperatureMonitor {
    default void displayHealthTips() {
        System.out.println("Temp Tip: Normal core baseline body temperature fluctuates around 37°C.");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    public static boolean isPatientIdValid(String patientId) {
        // Rule: Patient ID must start with "PAT-" followed by exactly 4 digits
        return patientId != null && patientId.matches("^PAT-[0-9]{4}$");
    }

    @Override
    public void displayHealthTips() {
        System.out.println("=== Automated Preventative Health Tips ===");
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void generateFinalHealthReport(String[] names, String[] ids, int[] heartRates, double[] temperatures) {
        displayHealthTips();
        System.out.println("\n=== Final Ward Health Status Matrix ===");
        for (int i = 0; i < names.length; i++) {
            System.out.println("----------------------------------------");
            System.out.println("Patient Name: " + names[i]);
            
            if (!isPatientIdValid(ids[i])) {
                System.out.println("Status Status: ERROR - Invalid ID Framework [" + ids[i] + "]");
                continue;
            }
            
            System.out.println("Patient ID: " + ids[i]);
            System.out.println("Pulse Rate: " + heartRates[i] + " BPM (" + (heartRates[i] < 60 || heartRates[i] > 100 ? "ABNORMAL" : "NORMAL") + ")");
            System.out.println("Temperature: " + temperatures[i] + "°C (" + (temperatures[i] < 36.1 || temperatures[i] > 37.5 ? "FEVER/HYPOTHERMIA" : "NORMAL") + ")");
        }
    }
}