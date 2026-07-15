class Notification {
    protected String recipientName; // [cite: 176]
    protected String message; // [cite: 177]

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public void sendNotification() { // [cite: 179]
        System.out.println("Sending generic notification to " + recipientName);
    }
}

class EmailNotification extends Notification { // [cite: 181]
    public EmailNotification(String recipientName, String message) { super(recipientName, message); }
    @Override
    public void sendNotification() { // [cite: 187]
        System.out.println("[EMAIL] To: " + recipientName + " | Content: " + message + " (Sent via SMTP)");
    }
}

class SMSNotification extends Notification { // [cite: 182]
    public SMSNotification(String recipientName, String message) { super(recipientName, message); }
    @Override
    public void sendNotification() { // [cite: 187]
        System.out.println("[SMS] To: " + recipientName + " | Content: " + message + " (Sent via Telecom Gateway)");
    }
}

class PushNotification extends Notification { // [cite: 183]
    public PushNotification(String recipientName, String message) { super(recipientName, message); }
    @Override
    public void sendNotification() { // [cite: 187]
        System.out.println("[PUSH] To: " + recipientName + " | Content: " + message + " (Sent via Firebase Cloud)");
    }
}

public class SmartNotificationSystem {
    public static void main(String[] args) {
        // Requirements: Polymorphic Array Container storage [cite: 189]
        Notification[] notifications = {
            new EmailNotification("Himanshu", "Your project assignment is approved!"), // [cite: 190]
            new SMSNotification("Rajput", "OTP for your secure transaction is 8821."), // [cite: 190]
            new PushNotification("AppUser", "Someone liked your futuristic UI dashboard layout!") // [cite: 190]
        };

        System.out.println("=== Launching Dynamic Dispatch Notifications ===");
        for (Notification n : notifications) {
            n.sendNotification(); // Dispatches dynamically based on runtime object identity [cite: 191, 192]
        }
    }
}