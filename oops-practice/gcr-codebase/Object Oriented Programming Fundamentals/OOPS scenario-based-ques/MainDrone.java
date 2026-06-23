class Drone {
    // Static variable shared among all instances
    public static String companyName = "Global Logistics Logistics Inc.";

    // Instance variables
    private String droneId;
    private int batteryPercentage;

    // Constructor utilizing 'this' keyword
    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (this.batteryPercentage > 15) {
            System.out.println("Drone " + this.droneId + " has started its delivery run.");
            this.batteryPercentage -= 10; // Consume battery during execution
        } else {
            System.out.println("Drone " + this.droneId + " battery is too low to safely deliver.");
        }
    }

    public void displayStatus() {
        System.out.println("Company: " + companyName + " | Drone ID: " + this.droneId + " | Battery: " + this.batteryPercentage + "%");
    }
}

public class MainDrone {
    public static void main(String[] args) {
        // Create multiple drones
        Drone droneA = new Drone("DRN-77X", 95);
        Drone droneB = new Drone("DRN-88Y", 12);
        Drone droneC = new Drone("DRN-99Z", 80);

        // Verify shared static company profile values
        droneA.displayStatus();
        droneB.displayStatus();
        droneC.displayStatus();

        System.out.println("\n--- Initiating Operations ---");
        droneA.startDelivery();
        droneB.startDelivery();
    }
}