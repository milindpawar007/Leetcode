// Game of Life - In-place solution (O(1) space)

class Solution {
    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // First pass: mark transitions
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbors = score(board, row, col);

                if (board[row][col] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = -1; // alive → dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[row][col] = 2; // dead → alive
                    }
                }
            }
        }

        // Second pass: finalize values
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    private int score(int[][] board, int row, int col) {
        int count = 0;

        // horizontal
        if (col - 1 >= 0 && Math.abs(board[row][col - 1]) == 1)
            count++;
        if (col + 1 < board[0].length && Math.abs(board[row][col + 1]) == 1)
            count++;

        // vertical
        if (row - 1 >= 0 && Math.abs(board[row - 1][col]) == 1)
            count++;
        if (row + 1 < board.length && Math.abs(board[row + 1][col]) == 1)
            count++;

        // diagonals
        if (row - 1 >= 0 && col - 1 >= 0 && Math.abs(board[row - 1][col - 1]) == 1)
            count++;
        if (row - 1 >= 0 && col + 1 < board[0].length && Math.abs(board[row - 1][col + 1]) == 1)
            count++;
        if (row + 1 < board.length && col - 1 >= 0 && Math.abs(board[row + 1][col - 1]) == 1)
            count++;
        if (row + 1 < board.length && col + 1 < board[0].length && Math.abs(board[row + 1][col + 1]) == 1)
            count++;

        return count;
    }
}