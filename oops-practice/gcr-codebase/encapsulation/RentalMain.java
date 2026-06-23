abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.print("Vehicle No: " + vehicleNumber + " [" + vehicleType + "]");
    }
}

class Car extends Vehicle {
    private double dailyRate;

    public Car(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public Bike(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public Truck(String vehicleNumber, String vehicleType, double dailyRate, double loadingCharge) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
        this.loadingCharge = loadingCharge;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
    public double getLoadingCharge() { return loadingCharge; }
    public void setLoadingCharge(double loadingCharge) { this.loadingCharge = loadingCharge; }

    @Override
    public double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class RentalMain {
    public static void main(String[] args) {
        Vehicle sedan = new Car("DL-3C-1234", "Car", 40.0);
        Vehicle sportsBike = new Bike("UP-93-7777", "Bike", 15.0);
        Vehicle cargoTruck = new Truck("HR-55-9000", "Truck", 120.0, 250.0);

        int rentalDays = 5;
        System.out.println("====== VEHICLE RENTAL INVOICES (" + rentalDays + " Days) ======");
        
        sedan.displayDetails();
        System.out.printf(" -> Cost: $%.2f%n", sedan.calculateRentalCost(rentalDays));

        sportsBike.displayDetails();
        System.out.printf(" -> Cost: $%.2f%n", sportsBike.calculateRentalCost(rentalDays));

        cargoTruck.displayDetails();
        System.out.printf(" -> Cost: $%.2f%n", cargoTruck.calculateRentalCost(rentalDays));
    }
}