import java.util.Scanner;

public class WarehouseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items in warehouse: ");
        int n = sc.nextInt();

        int[] stock = new int[n];

        // Input stock quantities
        System.out.println("Enter stock quantities:");
        for (int i = 0; i < n; i++) {
            stock[i] = sc.nextInt();
        }

        // Find max, min, total stock
        int max = stock[0];
        int min = stock[0];
        int total = 0;

        for (int i = 0; i < n; i++) {
            if (stock[i] > max) {
                max = stock[i];
            }

            if (stock[i] < min) {
                min = stock[i];
            }

            total += stock[i];
        }

        // Display stock analysis
        System.out.println("\n===== Warehouse Stock Analysis =====");
        System.out.println("Maximum Stock : " + max);
        System.out.println("Minimum Stock : " + min);
        System.out.println("Total Stock   : " + total);

        // Detect duplicates
        System.out.println("\nDuplicate Stock Quantities:");
        boolean foundDuplicate = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stock[i] == stock[j]) {
                    System.out.println(stock[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No duplicates found.");
        }

        // Rotate array by k positions
        System.out.print("\nEnter k positions to rotate stock array: ");
        int k = sc.nextInt();

        k = k % n; // Handle large k values

        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = stock[i];
        }

        System.out.println("\nStock Array After Rotation:");
        for (int i = 0; i < n; i++) {
            System.out.print(rotated[i] + " ");
        }

        // 2D Shelf Grid
        System.out.print("\n\nEnter rows for shelf grid: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns for shelf grid: ");
        int cols = sc.nextInt();

        int[][] shelf = new int[rows][cols];

        // Input shelf data
        System.out.println("Enter shelf grid values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                shelf[i][j] = sc.nextInt();
            }
        }

        // Transpose matrix
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = shelf[i][j];
            }
        }

        // Display transposed matrix
        System.out.println("\nTransposed Shelf Grid:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}