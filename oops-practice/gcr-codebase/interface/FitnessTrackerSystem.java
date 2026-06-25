interface Trackable {
    void logActivity(String activity);
    
    // Default method to reset data
    default void resetData() {
        System.out.println("Trackable: Resetting activity metrics to zero.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

// Class implementing all three interfaces
class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String lastActivity = "None";

    @Override
    public void logActivity(String activity) {
        this.lastActivity = activity;
        System.out.println("Activity Logged: " + activity);
    }

    @Override
    public void generateReport() {
        System.out.println("--- Fitness Performance Report ---");
        System.out.println("Last Tracked Activity: " + lastActivity);
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("[ALERT] Notification: " + message);
    }
}