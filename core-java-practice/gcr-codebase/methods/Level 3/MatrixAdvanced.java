class MatrixAdvanced {

    public static int[][] createMatrix(
            int rows, int cols) {

        int[][] matrix =
                new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0;
                 j < cols; j++) {

                matrix[i][j] =
                        (int)(Math.random()
                                * 9) + 1;
            }
        }

        return matrix;
    }

    public static int[][] transpose(
            int[][] matrix) {

        int[][] transpose =
                new int[matrix[0].length]
                        [matrix.length];

        for (int i = 0;
             i < matrix.length; i++) {

            for (int j = 0;
                 j < matrix[0].length; j++) {

                transpose[j][i] =
                        matrix[i][j];
            }
        }

        return transpose;
    }

    public static int determinant2x2(
            int[][] matrix) {

        return matrix[0][0]
                * matrix[1][1]
                -
                matrix[0][1]
                * matrix[1][0];
    }

    public static int determinant3x3(
            int[][] matrix) {

        return matrix[0][0]
                * ((matrix[1][1]
                * matrix[2][2])
                -
                (matrix[1][2]
                * matrix[2][1]))
                -
                matrix[0][1]
                * ((matrix[1][0]
                * matrix[2][2])
                -
                (matrix[1][2]
                * matrix[2][0]))
                +
                matrix[0][2]
                * ((matrix[1][0]
                * matrix[2][1])
                -
                (matrix[1][1]
                * matrix[2][0]));
    }

    public static void display(
            int[][] matrix) {

        for (int[] row : matrix) {

            for (int value : row) {

                System.out.print(
                        value + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix =
                createMatrix(3, 3);

        System.out.println(
                "Matrix:");
        display(matrix);

        System.out.println(
                "\nTranspose:");
        display(
                transpose(matrix));

        System.out.println(
                "\nDeterminant: "
                + determinant3x3(matrix));
    }
}