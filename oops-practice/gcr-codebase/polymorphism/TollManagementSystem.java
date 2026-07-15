class Vehicle {
    protected String vehicleNumber; // [cite: 263]
    protected String ownerName; // [cite: 264]

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public double calculateToll() { return 0.0; } // [cite: 266]
}

class Car extends Vehicle {
    public Car(String num, String owner) { super(num, owner); }
    @Override public double calculateToll() { return 100.0; } // [cite: 267]
}

class Bus extends Vehicle {
    public Bus(String num, String owner) { super(num, owner); }
    @Override public double calculateToll() { return 250.0; } // [cite: 267]
}

class Truck extends Vehicle {
    public Truck(String num, String owner) { super(num, owner); }
    @Override public double calculateToll() { return 400.0; } // [cite: 267]
}

public class TollManagementSystem {
    // Requirements: Method 1 - Compute Total Income Revenue [cite: 271]
    public static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) total += v.calculateToll(); // [cite: 273]
        return total;
    }

    // Requirements: Method 2 - Structural Search Algorithm by ID Plate [cite: 272]
    public static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        System.out.println("\nSearching Toll Log for Plates: " + vehicleNumber);
        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equalsIgnoreCase(vehicleNumber)) {
                System.out.println("Found! Owner: " + v.ownerName + " | Paid: ₹" + v.calculateToll());
                return;
            }
        }
        System.out.println("Vehicle not recorded crossing checkpoint.");
    }

    // Requirements: Method 3 - Max Toll Assessment Analysis [cite: 274]
    public static void displayHighestTollVehicle(Vehicle[] vehicles) {
        if (vehicles.length == 0) return;
        Vehicle highest = vehicles[0];
        for (Vehicle v : vehicles) {
            if (v.calculateToll() > highest.calculateToll()) {
                highest = v;
            }
        }
        System.out.println("\nHighest Tariff Payer: " + highest.vehicleNumber + " (" + highest.ownerName + ") paid ₹" + highest.calculateToll());
    }

    // Requirements: Method 4 - Class Type Aggregation Loops [cite: 275]
    public static void countVehiclesByType(Vehicle[] vehicles) {
        int cars = 0, buses = 0, trucks = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) cars++;
            else if (v instanceof Bus) buses++;
            else if (v instanceof Truck) trucks++;
        }
        System.out.println("\nToll Gate Categorical Analytics Summary:");
        System.out.println("Cars Checked: " + cars + " | Buses Checked: " + buses + " | Trucks Checked: " + trucks);
    }

    public static void main(String[] args) {
        Vehicle[] tollPlazaLog = { // [cite: 269]
            new Car("DL-1C-A1234", "Rajesh"),
            new Bus("UP-93-T5567", "Suresh"),
            new Truck("MH-12-Q9981", "Manish"),
            new Car("HR-26-Z8821", "Anjali")
        };

        System.out.println("Total Operational Revenue Collected: ₹" + calculateTotalRevenue(tollPlazaLog)); // [cite: 271]
        countVehiclesByType(tollPlazaLog); // [cite: 275]
        displayHighestTollVehicle(tollPlazaLog); // [cite: 274]
        searchVehicle(tollPlazaLog, "UP-93-T5567"); // [cite: 272]
    }
}