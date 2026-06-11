import java.util.Scanner;

/**
 * Class flattening user dimensional matrices down into uniform arrays.
 */
class MatrixFlattener {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of matrix rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of matrix columns: ");
        int columns = input.nextInt();
        
        int[][] matrix2D = new int[rows][columns];
        
        // Populate nested grid rows
        System.out.println("Enter the elements of the Matrix grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Matrix[" + i + "][" + j + "]: ");
                matrix2D[i][j] = input.nextInt();
            }
        }
        
        // Initialize flat target structure via calculated storage requirements
        int[] flattenedArray = new int[rows * columns];
        int flatTargetIndex = 0;
        
        // Multi-dimensional layout extraction loops
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D[i].length; j++) {
                flattenedArray[flatTargetIndex] = matrix2D[i][j];
                flatTargetIndex++;
            }
        }
        
        System.out.println("\nResulting Single-Dimension Array Output:");
        for (int i = 0; i < flattenedArray.length; i++) {
            System.out.print(flattenedArray[i] + " ");
        }
        System.out.println();
        
        input.close();
    }
}