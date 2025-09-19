import java.util.ArrayList;
import java.util.Scanner;

public class Recursion3 {

    // Q1: Print all permutations of a string
    public static void printPermutation(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newStr, perm + currChar);
        }
    }

    // Q2: Count paths in an m x n grid (from (0,0) to (m-1,n-1))
    public static int countPaths(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        return countPaths(i + 1, j, m, n) + countPaths(i, j + 1, m, n);
    }

    // Q3: Tiling problem (n x m floor with 1 x m tiles)
    public static int placeTiles(int n, int m) {
        if (n < m) {
            return 1;
        } else if (n == m) {
            return 2;
        }
        return placeTiles(n - 1, m) + placeTiles(n - m, m);
    }

    // Q4: Friends pairing problem
    public static int pairFriends(int n) {
        if (n <= 1) {
            return 1;
        }
        return pairFriends(n - 1) + (n - 1) * pairFriends(n - 2);
    }

    // Q5: Subsets of a set
    public static void printSubsets(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }

    public static void findSubsets(int n, ArrayList<Integer> subset) {
        if (n == 0) {
            printSubsets(subset);
            return;
        }
        // don't include n
        findSubsets(n - 1, subset);
        // include n
        subset.add(n);
        findSubsets(n - 1, subset);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a problem:");
        System.out.println("1. Print all permutations of a string");
        System.out.println("2. Count Paths in Maze");
        System.out.println("3. Tiling Problem");
        System.out.println("4. Friends Pairing Problem");
        System.out.println("5. Subsets of a Set");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter a string: ");
                String str = sc.nextLine();
                printPermutation(str, "");
                break;

            case 2:
                System.out.print("Enter number of rows (m): ");
                int m = sc.nextInt();
                System.out.print("Enter number of columns (n): ");
                int n = sc.nextInt();
                System.out.println("Number of paths: " + countPaths(0, 0, m, n));
                break;

            case 3:
                System.out.print("Enter n (floor length): ");
                int nT = sc.nextInt();
                System.out.print("Enter m (tile size): ");
                int mT = sc.nextInt();
                System.out.println("Ways to place tiles: " + placeTiles(nT, mT));
                break;

            case 4:
                System.out.print("Enter number of friends: ");
                int nF = sc.nextInt();
                System.out.println("Number of ways to pair: " + pairFriends(nF));
                break;

            case 5:
                System.out.print("Enter n: ");
                int nS = sc.nextInt();
                findSubsets(nS, new ArrayList<Integer>());
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
} 
