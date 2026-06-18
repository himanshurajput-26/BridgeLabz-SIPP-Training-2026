public class Problem9 {
    public static void processDivision(int[] arr, int index, int divisor) {
        try {
            // Outer try block for evaluating array access boundaries
            int value = arr[index];
            
            try {
                // Inner try block handling individual operations
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30};

        // Execution checks
        processDivision(data, 5, 2); // Triggers outer exception
        processDivision(data, 1, 0); // Triggers inner exception
    }
}