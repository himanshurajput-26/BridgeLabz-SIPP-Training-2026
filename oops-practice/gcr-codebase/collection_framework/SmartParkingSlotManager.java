import java.util.ArrayList;

public class SmartParkingSlotManager {
    private ArrayList<String> parkedVehicles;

    public SmartParkingSlotManager() {
        this.parkedVehicles = new ArrayList<>(); // 
    }

    // Task 1: Add a vehicle when it enters [cite: 22]
    public void enterParking(String registrationNumber) {
        parkedVehicles.add(registrationNumber);
        System.out.println("Vehicle " + registrationNumber + " entered the parking area.");
    }

    // Task 2: Remove a vehicle when it exits [cite: 23]
    public boolean exitParking(String registrationNumber) {
        if (parkedVehicles.remove(registrationNumber)) {
            System.out.println("Vehicle " + registrationNumber + " exited the parking area.");
            return true;
        }
        System.out.println("Vehicle " + registrationNumber + " was not found in the parking area.");
        return false;
    }

    // Task 3: Search for a vehicle using its registration number [cite: 27]
    public boolean isVehicleParked(String registrationNumber) {
        return parkedVehicles.contains(registrationNumber);
    }

    // Task 4: Display all parked vehicles along with the total number of occupied slots [cite: 28, 29]
    public void displayParkingStatus() {
        System.out.println("\n--- Current Parked Vehicles ---");
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are currently parked.");
        } else {
            for (String vehicle : parkedVehicles) { // [cite: 18]
                System.out.println("- " + vehicle);
            }
        }
        System.out.println("Total Occupied Slots: " + parkedVehicles.size()); // [cite: 28, 29]
    }

    public static void main(String[] args) {
        SmartParkingSlotManager manager = new SmartParkingSlotManager();
        manager.enterParking("DL-3C-AA-1234");
        manager.enterParking("HR-26-XYZ-7890");
        manager.displayParkingStatus();

        System.out.println("\nSearching for DL-3C-AA-1234: " + manager.isVehicleParked("DL-3C-AA-1234"));
        
        manager.exitParking("DL-3C-AA-1234");
        manager.displayParkingStatus();
    }
}