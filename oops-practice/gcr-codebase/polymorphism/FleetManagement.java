class Vehicle {
    protected String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public double fuelCost(double km) {
        return 0.0; // Base implementation
    }
}

class Car extends Vehicle {
    public Car(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 7.5; } // ₹7.5 per km
}

class Bus extends Vehicle {
    public Bus(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 15.0; } // ₹15.0 per km
}

class Bike extends Vehicle {
    public Bike(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 2.5; } // ₹2.5 per km
}

// Adding new type without changing existing class logic (Open/Closed Principle)
class ElectricCar extends Vehicle {
    public ElectricCar(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 1.2; } // ₹1.2 per km
}

public class FleetManagement {
    public static void runAnalysis(Vehicle[] vehicles, double km) {
        System.out.println("=== Fleet Fuel Cost Analysis ===");
        for (Vehicle v : vehicles) {
            double cost = v.fuelCost(km);
            System.out.print("Vehicle: " + v.model + " | Cost for " + km + "km: ₹" + cost);
            
            // Explicit type classification check using instanceof
            if (v instanceof ElectricCar) {
                System.out.println(" [Eco-Friendly Electric Battery]");
            } else if (v instanceof Car) {
                System.out.println(" [Standard Internal Combustion Car]");
            } else {
                System.out.println(" [Commercial/Two-Wheeler Standard]");
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("Sedan VXI"),
            new Bus("Volvo Intercity"),
            new Bike("Sports 150cc"),
            new ElectricCar("Tesla Model 3")
        };
        runAnalysis(fleet, 100);
    }
}