import java.util.*;

// --- PERMUTATIONS + N-QUEENS COMBINED PROGRAM ---
public class RecursionCombined {

    // =======================
    // PART 1 : PERMUTATIONS
    // =======================
    // Print all permutations of a string
    public static void printPermutation(String str, String perm) {
        // Base case: if string empty, print built permutation
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }

        // For each character, fix it and permute remaining
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            // remove ith char and pass rest
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newStr, perm + currChar);
        }
    }

    // =======================
    // PART 2 : N-QUEENS
    // =======================

    // Check if placing a queen at (row,col) is safe
    public static boolean isSafe(int row, int col, char[][] board) {
        int n = board.length;

        // check same row on left side
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') return false;
        }

        // check upper-left diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }

        // check lower-left diagonal
        for (int r = row, c = col; r < n && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') return false;
        }

        return true; // safe placement
    }

    // Save board configuration as list of strings
    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> newBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                row.append(board[i][j]);
            }
            newBoard.add(row.toString());
        }
        allBoards.add(newBoard);
    }

    // Backtracking helper for N-Queens
    public static void helper(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            // all columns filled → valid configuration
            saveBoard(board, allBoards);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';       // choose
                helper(board, allBoards, col + 1); // recurse for next column
                board[row][col] = '.';       // backtrack
            }
        }
    }

    // Driver for N-Queens
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(board, allBoards, 0);
        return allBoards;
    }

    // =======================
    // MAIN : USER INPUT
    // =======================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Permutations ---
        System.out.print("Enter a string to print all permutations: ");
        String str = sc.nextLine();
        System.out.println("\nAll permutations of " + str + ":");
        printPermutation(str, "");

        // --- N-Queens ---
        System.out.print("\nEnter n for N-Queens: ");
        int n = sc.nextInt();
        List<List<String>> solutions = solveNQueens(n);

        System.out.println("\nAll solutions for " + n + "-Queens:");
        int count = 1;
        for (List<String> board : solutions) {
            System.out.println("Solution " + count++ + ":");
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
        sc.close();
    }
}
