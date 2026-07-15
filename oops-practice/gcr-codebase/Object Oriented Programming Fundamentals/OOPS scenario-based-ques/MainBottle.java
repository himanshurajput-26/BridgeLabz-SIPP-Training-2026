class WaterBottle {
    // Instance variables
    private String ownerName;
    private int dailyTarget; // measured in ml

    // Constructor to initialize values
    public WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    public void displayBottleInfo() {
        System.out.println("Smart Bottle Owner: " + this.ownerName + " | Daily Hydration Target: " + this.dailyTarget + " ml");
    }
}

public class MainBottle {
    public static void main(String[] args) {
        // Create two bottle objects
        WaterBottle user1 = new WaterBottle("Alice", 2500);
        WaterBottle user2 = new WaterBottle("Bob", 3000);

        // Display information
        user1.displayBottleInfo();
        user2.displayBottleInfo();
    }
}