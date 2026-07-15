class SpaceTourist {
    // Static configuration tracking elements
    public static int totalReservations = 0;
    public static String missionName = "Artemis Gateway Voyager";

    // Instance Variables
    private String touristName;
    private int seatNumber;

    // Constructor to initialize instance variants
    public SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    // Update function leveraging method chaining (returns current reference 'this')
    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this; 
    }

    public void displayDetails() {
        System.out.println("Mission: " + missionName + " | Passenger: " + this.touristName + " | Assigned Seat Location: #" + this.seatNumber);
    }
}

public class MainSpace {
    public static void main(String[] args) {
        // Build individual account tracking
        SpaceTourist tourist = new SpaceTourist("Himanshu Rajput", 4);

        System.out.println("Initial status assignment:");
        tourist.displayDetails();

        // Exercise consecutive modifications via sequential method chaining execution path patterns
        tourist.updateSeatNumber(10).updateSeatNumber(15);

        System.out.println("\nFinal verified verification tracking output updates:");
        tourist.displayDetails();
        
        System.out.println("Global Total Bookings Count: " + SpaceTourist.totalReservations);
    }
}