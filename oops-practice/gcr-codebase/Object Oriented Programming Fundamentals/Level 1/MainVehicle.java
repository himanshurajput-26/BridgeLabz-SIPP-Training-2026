class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 150.0; // Class Variable

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance Method
    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + " | Type: " + vehicleType + " | Registration Fee: $" + registrationFee);
    }

    // Class Method
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class MainVehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Bob", "Sedan");
        v1.displayVehicleDetails();

        Vehicle.updateRegistrationFee(175.0);
        v1.displayVehicleDetails();
    }
}