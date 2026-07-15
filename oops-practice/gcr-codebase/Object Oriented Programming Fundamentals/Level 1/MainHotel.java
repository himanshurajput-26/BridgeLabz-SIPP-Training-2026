class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    // Default Constructor
    public HotelBooking() {
        this.guestName = "Not Registered";
        this.roomType = "Standard";
        this.nights = 0;
    }

    // Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void displayBooking() {
        System.out.println("Guest: " + guestName + " | Room: " + roomType + " | Nights: " + nights);
    }
}

public class MainHotel {
    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Alice", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2); // Copy constructor

        b1.displayBooking();
        b2.displayBooking();
        b3.displayBooking();
    }
}