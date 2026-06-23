class Vehicle {
    static double registrationFee = 5000;

    String ownerName;
    String vehicleType;
    final String registrationNumber;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
        System.out.println("Updated Fee: " + registrationFee);
    }

    void display() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("Amit", "Car", "UP80AB1234");

        if (v instanceof Vehicle) {
            v.display();
        }

        updateRegistrationFee(6000);
    }
}