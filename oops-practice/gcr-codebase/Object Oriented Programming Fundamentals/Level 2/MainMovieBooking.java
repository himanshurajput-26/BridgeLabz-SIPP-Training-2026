class MovieTicket {
    // Attributes
    private String movieName;
    private String seatNumber;
    private double price;

    // Constructor
    public MovieTicket(String movieName, double basePrice) {
        this.movieName = movieName;
        this.price = basePrice;
        this.seatNumber = "Not Booked";
    }

    // Method to book a ticket
    public void bookTicket(String seat, double premiumCharges) {
        this.seatNumber = seat;
        this.price += premiumCharges; // Update price with specific seat modifiers
        System.out.println("Seat " + seat + " booked successfully for " + movieName);
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("--- Booking Confirmation ---");
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Location: " + seatNumber);
        System.out.println("Total Paid Amount: $" + price);
    }
}

public class MainMovieBooking {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Interstellar", 12.0);
        ticket.bookTicket("Premium-F12", 4.5);
        ticket.displayTicketDetails();
    }
}