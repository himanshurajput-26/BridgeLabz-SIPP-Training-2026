class MatrixOperations {

    public static int[][] createMatrix(
            int rows, int cols) {

        int[][] matrix =
                new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0;
                 j < cols; j++) {

                matrix[i][j] =
                        (int)(Math.random()
                                * 10);
            }
        }

        return matrix;
    }

    public static int[][] addMatrix(
            int[][] a, int[][] b) {

        int[][] result =
                new int[a.length]
                        [a[0].length];

        for (int i = 0;
             i < a.length; i++) {

            for (int j = 0;
                 j < a[0].length; j++) {

                result[i][j] =
                        a[i][j]
                        + b[i][j];
            }
        }

        return result;
    }

    public static int[][] subtractMatrix(
            int[][] a, int[][] b) {

        int[][] result =
                new int[a.length]
                        [a[0].length];

        for (int i = 0;
             i < a.length; i++) {

            for (int j = 0;
                 j < a[0].length; j++) {

                result[i][j] =
                        a[i][j]
                        - b[i][j];
            }
        }

        return result;
    }

    public static int[][] multiplyMatrix(
            int[][] a, int[][] b) {

        int[][] result =
                new int[a.length]
                        [b[0].length];

        for (int i = 0;
             i < a.length; i++) {

            for (int j = 0;
                 j < b[0].length; j++) {

                for (int k = 0;
                     k < b.length; k++) {

                    result[i][j]
                            +=
                            a[i][k]
                            * b[k][j];
                }
            }
        }

        return result;
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

        int[][] matrix1 =
                createMatrix(3, 3);

        int[][] matrix2 =
                createMatrix(3, 3);

        System.out.println(
                "Matrix 1");
        display(matrix1);

        System.out.println(
                "\nMatrix 2");
        display(matrix2);

        System.out.println(
                "\nAddition");
        display(
                addMatrix(
                        matrix1,
                        matrix2));

        System.out.println(
                "\nSubtraction");
        display(
                subtractMatrix(
                        matrix1,
                        matrix2));

        System.out.println(
                "\nMultiplication");
        display(
                multiplyMatrix(
                        matrix1,
                        matrix2));
    }
}