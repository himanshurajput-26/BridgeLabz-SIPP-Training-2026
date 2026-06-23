class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RATE = 50.0; // Assume flat standard rate per day

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return this.rentalDays * DAILY_RATE;
    }

    public void displayReceipt() {
        System.out.println("Customer: " + customerName + " | Model: " + carModel + 
                           " | Days: " + rentalDays + " | Total Cost: $" + calculateTotalCost());
    }
}

public class MainCarRental {
    public static void main(String[] args) {
        CarRental rental = new CarRental("John Doe", "Tesla Model 3", 5);
        rental.displayReceipt();
    }
}