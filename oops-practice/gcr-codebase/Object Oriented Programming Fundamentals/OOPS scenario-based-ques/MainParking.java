class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType; // Target types: "Car" or "Bike"

    // Constructor using 'this' keyword
    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void displayInfo() {
        System.out.println("[" + vehicleType.toUpperCase() + "] Reg No: " + vehicleNumber + " | Owner: " + ownerName);
    }
}

public class MainParking {
    private static Vehicle[] parkingLot = new Vehicle[10];

    public static void displayCars() {
        System.out.println("\n--- Parked Cars ---");
        for (Vehicle v : parkingLot) {
            if (v != null && v.getVehicleType().equalsIgnoreCase("Car")) {
                v.displayInfo();
            }
        }
    }

    public static void displayBikes() {
        System.out.println("\n--- Parked Bikes ---");
        for (Vehicle v : parkingLot) {
            if (v != null && v.getVehicleType().equalsIgnoreCase("Bike")) {
                v.displayInfo();
            }
        }
    }

    public static void main(String[] args) {
        // Store 10 vehicle array positions cleanly
        parkingLot[0] = new Vehicle("DL3C-1234", "Alex", "Car");
        parkingLot[1] = new Vehicle("MH12-5678", "Bob", "Bike");
        parkingLot[2] = new Vehicle("UP93-9999", "Charlie", "Car");
        parkingLot[3] = new Vehicle("DL1S-4321", "Diana", "Bike");
        parkingLot[4] = new Vehicle("KA03-7777", "Ethan", "Car");
        parkingLot[5] = new Vehicle("HR26-1122", "Fiona", "Car");
        parkingLot[6] = new Vehicle("GJ01-8833", "George", "Bike");
        parkingLot[7] = new Vehicle("WB02-4455", "Hannah", "Car");
        parkingLot[8] = new Vehicle("TN07-6611", "Ian", "Bike");
        parkingLot[9] = new Vehicle("BR01-0088", "Julia", "Car");

        // Filter operations by specific sub-type queries
        displayCars();
        displayBikes();
    }
}