public class Problem4 {
    public static void fetchValue(int[] arr, int index) {
        try {
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
    }

    public static void main(String[] args) {
        int[] validArray = {10, 20, 30};
        int[] nullArray = null;

        // Test cases matching requirements
        fetchValue(validArray, 1);  // Valid case
        fetchValue(validArray, 5);  // Out of bounds case
        fetchValue(nullArray, 0);   // Null array case
    }
}