import java.util.*;

public class TwoDArrays {
    // 1 Input Matrix
    public static int[][] inputMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements row-wise:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // 2 Print Matrix
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 3 Search Element
    public static void searchElement(int[][] matrix, int x) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == x) {
                    System.out.println("x found at location (" + i + ", " + j + ")");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }

    // 4 Spiral Order Print
    public static void printSpiral(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = m - 1;

        System.out.println("The Spiral Order Matrix is : ");
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 1. Top row
            for (int col = colStart; col <= colEnd; col++) {
                System.out.print(matrix[rowStart][col] + " ");
            }
            rowStart++;

            // 2. Right column
            for (int row = rowStart; row <= rowEnd; row++) {
                System.out.print(matrix[row][colEnd] + " ");
            }
            colEnd--;

            // 3. Bottom row
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    System.out.print(matrix[rowEnd][col] + " ");
                }
                rowEnd--;
            }

            // 4. Left column
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    System.out.print(matrix[row][colStart] + " ");
                }
                colStart++;
            }
        }
        System.out.println();
    }

    // 5 Transpose Print
    public static void printTranspose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println("The transpose is : ");
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter cols: ");
        int cols = sc.nextInt();

        int[][] matrix = inputMatrix(sc, rows, cols);

        // Menu-driven
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Print Matrix");
            System.out.println("2. Search Element");
            System.out.println("3. Print Spiral");
            System.out.println("4. Print Transpose");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printMatrix(matrix);
                    break;
                case 2:
                    System.out.print("Enter element to search: ");
                    int x = sc.nextInt();
                    searchElement(matrix, x);
                    break;
                case 3:
                    printSpiral(matrix);
                    break;
                case 4:
                    printTranspose(matrix);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
