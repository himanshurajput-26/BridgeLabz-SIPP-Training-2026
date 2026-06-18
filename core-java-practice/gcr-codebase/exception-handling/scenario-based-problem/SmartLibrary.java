public class SmartLibrary {
    private static String books[] = {"Java", "Python", null, "C++"};

    public static void getBookLength(int index) {
        try {
            // This line may throw an ArrayIndexOutOfBoundsException
            String bookName = books[index];
            
            // This line may throw a NullPointerException
            int length = bookName.length(); 
            System.out.println("Book '" + bookName + "' length is: " + length);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Library Alert: Requested index [" + index + "] is out of shelf bounds.");
        } catch (NullPointerException e) {
            System.out.println("Library Alert: The slot at index [" + index + "] is currently empty (null value reference found).");
        }
    }

    public static void main(String[] args) {
        getBookLength(1); // Normal path
        getBookLength(2); // Null path
        getBookLength(6); // Out of bounds path
    }
}