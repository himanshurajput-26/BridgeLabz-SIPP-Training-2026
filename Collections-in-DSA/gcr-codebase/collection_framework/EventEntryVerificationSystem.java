import java.util.HashSet;

public class EventEntryVerificationSystem {
    private HashSet<String> registeredEmails;

    public EventEntryVerificationSystem() {
        this.registeredEmails = new HashSet<>(); // [cite: 35]
    }

    // Task 1 & 2: Register participant and prevent duplicate registrations automatically [cite: 41, 42]
    public void registerParticipant(String emailId) {
        if (registeredEmails.add(emailId)) { // [cite: 35]
            System.out.println("Registration successful for: " + emailId);
        } else {
            System.out.println("Registration rejected! Duplicate entry detected for: " + emailId); // [cite: 37]
        }
    }

    // Task 3: Display all unique registered participants [cite: 43]
    public void displayRegisteredParticipants() {
        System.out.println("\n--- Unique Registered Participants ---");
        for (String email : registeredEmails) { // [cite: 38]
            System.out.println("- " + email);
        }
    }

    // Task 4: Show the total number of eligible attendees [cite: 44]
    public void displayTotalAttendees() {
        System.out.println("Total Eligible Attendees: " + registeredEmails.size()); // [cite: 44]
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem system = new EventEntryVerificationSystem();
        system.registerParticipant("hrajput@example.com");
        system.registerParticipant("coder@example.com");
        system.registerParticipant("hrajput@example.com"); // Duplicate attempt [cite: 37]

        system.displayRegisteredParticipants();
        system.displayTotalAttendees();
    }
}