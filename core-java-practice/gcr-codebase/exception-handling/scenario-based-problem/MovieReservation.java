public class MovieReservation {
    private static int[] seats = {101, 102, 103, 104, 105};

    public static int getSeat(int index) {
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Internal Method Alert: Seat position " + index + " does not exist.");
            return -1; // Fallback token when an exception occurs
        }
    }

    public static void main(String[] args) {
        System.out.println("Requesting Seat index 2: " + getSeat(2));
        System.out.println("Requesting Seat index 8: " + getSeat(8));
    }
}