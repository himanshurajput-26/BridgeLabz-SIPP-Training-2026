import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {
    private HashMap<String, Integer> rawTrafficData; // [cite: 133]

    public SmartCityTrafficMonitoringSystem() {
        this.rawTrafficData = new HashMap<>(); // [cite: 133]
    }

    // Task 1: Add or update vehicle counts for different roads [cite: 144]
    public void recordVehicleTraffic(String roadName, int vehicleCount) {
        rawTrafficData.put(roadName, rawTrafficData.getOrDefault(roadName, 0) + vehicleCount); // [cite: 135, 144]
        System.out.println("Updated " + roadName + " with +" + vehicleCount + " vehicles.");
    }

    // Task 2: Display all roads and their vehicle counts in sorted order [cite: 145]
    public void displaySortedTraffic() {
        // Automatically sorts by Key (Road Name) alphabetically [cite: 136]
        TreeMap<String, Integer> sortedTraffic = new TreeMap<>(rawTrafficData); // [cite: 136]
        
        System.out.println("\n--- Alphabetical Traffic Standings ---");
        for (Map.Entry<String, Integer> entry : sortedTraffic.entrySet()) { // [cite: 145]
            System.out.println("Road: " + entry.getKey() + " | Vehicles: " + entry.getValue());
        }
    }

    // Task 3 & 4: Identify the busiest road and generate a final status report [cite: 146, 147]
    public void generateTrafficAnalysisReport() {
        System.out.println("\n--- Traffic Analysis Report ---");
        String busiestRoad = null;
        int maxVehicles = -1;

        for (Map.Entry<String, Integer> entry : rawTrafficData.entrySet()) { // [cite: 138]
            String road = entry.getKey();
            int counts = entry.getValue();

            // Qualitative condition tag generation based on traffic volume
            String status = counts > 500 ? "HEAVY TRAFFIC" : "MODERATE TRAFFIC"; // [cite: 147]
            System.out.println("Road: " + road + " -> Total Count: " + counts + " [" + status + "]");

            if (counts > maxVehicles) { // [cite: 137]
                maxVehicles = counts;
                busiestRoad = road;
            }
        }
        
        if (busiestRoad != null) {
            System.out.println("\n** Busiest Road Identified **: " + busiestRoad + " with " + maxVehicles + " vehicles."); // [cite: 137, 146]
        }
    }

    // Task 5: Display total number of monitored roads [cite: 148]
    public void displayMonitoredRoadsCount() {
        System.out.println("Total Monitored Roads: " + rawTrafficData.size()); // [cite: 148]
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem system = new SmartCityTrafficMonitoringSystem();
        system.recordVehicleTraffic("Connaught Place Bypass", 650);
        system.recordVehicleTraffic("Gwalior Road Bypass", 320);
        system.recordVehicleTraffic("Connaught Place Bypass", 120); // updates count [cite: 144]

        system.displaySortedTraffic();
        system.generateTrafficAnalysisReport();
        system.displayMonitoredRoadsCount();
    }
}