class ChargingStation {
    // Static Variables
    public static int totalStations = 0;
    public static double electricityRate = 0.15; // default unit rate per kWh

    // Instance Variables
    private String stationId;
    private double unitsConsumed;

    // Constructor
    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++; // Track station count updates globally
    }

    public double calculateBill() {
        return this.unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station ID: " + this.stationId + " | Units Consumed: " + this.unitsConsumed + " kWh | Bill: $" + calculateBill());
    }
}

public class MainEV {
    public static void main(String[] args) {
        // Create 5 different charging stations
        ChargingStation s1 = new ChargingStation("ST-01", 120.5);
        ChargingStation s2 = new ChargingStation("ST-02", 85.0);
        ChargingStation s3 = new ChargingStation("ST-03", 240.0);
        ChargingStation s4 = new ChargingStation("ST-04", 50.2);
        ChargingStation s5 = new ChargingStation("ST-05", 195.8);

        System.out.println("Initial billing overview updates:");
        s1.displayStationDetails();
        s2.displayStationDetails();

        // Rule Test: Global adjustment across all infrastructure instances instantly
        System.out.println("\n--- Energy rate spike detected! Updating global electricityRate values ---");
        ChargingStation.electricityRate = 0.22; 

        System.out.println("Recalculated output metrics immediately across active stations:");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("\nTotal Stations Managed: " + ChargingStation.totalStations);
    }
}