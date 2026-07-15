public class SensorReadings {
    public static boolean isStrictlyIncreasing(int[] readings, int index) {
        // Base case: If we reach the last element or array has < 2 elements
        if (index >= readings.length - 1) {
            return true;
        }
        // If current element is not strictly less than the next, return false
        if (readings[index] >= readings[index + 1]) {
            return false;
        }
        // Recursive call for the next pair
        return isStrictlyIncreasing(readings, index + 1);
    }

    public static void main(String[] args) {
        int[] readings1 = {12, 15, 18, 22, 30}; // Expected: true [cite: 90, 91]
        int[] readings2 = {12, 15, 14, 22};     // Expected: false [cite: 92, 93]

        System.out.println(isStrictlyIncreasing(readings1, 0)); 
        System.out.println(isStrictlyIncreasing(readings2, 0)); 
    }
}