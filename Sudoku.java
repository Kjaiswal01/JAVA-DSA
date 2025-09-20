public class Sudoku {

    //  Check whether placing 'number' at board[row][col] is safe
    public boolean isSafe(char[][] board, int row, int col, int number) {
        // Check the same column and same row
        for (int i = 0; i < board.length; i++) {
            // column check
            if (board[i][col] == (char) (number + '0')) return false;
            // row check
            if (board[row][i] == (char) (number + '0')) return false;
        }

        // Check inside the 3x3 grid
        int sr = (row / 3) * 3;  // starting row index of subgrid
        int sc = (col / 3) * 3;  // starting column index of subgrid

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (number + '0')) return false;
            }
        }

        // Safe if not found in row, col or subgrid
        return true;
    }

    //  Recursive helper function to solve Sudoku
    public boolean helper(char[][] board, int row, int col) {
        // Base case: if row == 9, entire board is filled
        if (row == board.length) {
            return true;
        }

        // Compute next cell coordinates
        int nrow, ncol;
        if (col != board.length - 1) { // not at last column
            nrow = row;
            ncol = col + 1;
        } else {                       // move to next row first column
            nrow = row + 1;
            ncol = 0;
        }

        // If cell already filled, skip to next cell
        if (board[row][col] != '.') {
            return helper(board, nrow, ncol);
        } else {
            // Try placing numbers 1 to 9
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0'); // place number
                    // Recursively check for rest of board
                    if (helper(board, nrow, ncol)) {
                        return true; // solved
                    } else {
                        // Backtrack: remove number
                        board[row][col] = '.';
                    }
                }
            }
        }

        // If no number fits, return false to trigger backtracking
        return false;
    }

    //  Public method to solve Sudoku
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public static void main(String[] args) {
        // Initial Sudoku board ('.' means empty cell)
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        Sudoku solver = new Sudoku();
        solver.solveSudoku(board);

        // Print solved Sudoku board
        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }

}


// Time Complexity:---------------------------------------------------------------
// Sudoku is essentially a Constraint Satisfaction Problem.
// For each empty cell (up to 81), you may try up to 9 digits.
// So in the worst case: O(9^(nEmpty)).
// But due to pruning by isSafe, real runtime is much lower.
// For a 9×9 Sudoku with 20–30 blanks, it’s practically solvable in milliseconds.
// So worst case: O(9^(81)) (huge)
// Average case: far less because of constraints.

// Space Complexity:-------------------------------------------------------------
// The board is fixed size 9×9 → O(81) ≈ O(1) constant.
// Recursion stack depth at most 81 cells → O(81) ≈ O(1) constant.
// No extra large data structures.
// So space complexity = O(1) (apart from the board itself).