import java.util.Arrays;

class Matrix {

    private int[][] matrix;

    Matrix(String matrixAsString) {
        var arr = matrixAsString.split("\n");

        int rowSize = arr.length;
        int colSize = arr[0].split(" ").length;

        matrix = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            String[] s1 = arr[i].split(" ");
            
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = Integer.parseInt(s1[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                column[i] = matrix[i][columnNumber - 1];
            }
        }
        return column;
    }
}
