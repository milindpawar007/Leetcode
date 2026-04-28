public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean isRowHasZero = false;
        boolean isColHasZero = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Mark rows and columns
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0)
                        isRowHasZero = true;
                    if (col == 0)
                        isColHasZero = true;

                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Step 2: Update inner matrix
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Step 3: Update first row
        if (isRowHasZero) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }

        // Step 4: Update first column
        if (isColHasZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}