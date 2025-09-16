import java.util.*;

public class PatternsBasic {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Pattern (1-9):");
        System.out.println("1. Solid Rectangle");
        System.out.println("2. Hollow Rectangle");
        System.out.println("3. Right Triangle");
        System.out.println("4. Inverted Triangle");
        System.out.println("5. Right Triangle (rotated with spaces)");
        System.out.println("6. Number Triangle Increasing");
        System.out.println("7. Number Triangle Decreasing");
        System.out.println("8. Floyd's Triangle");
        System.out.println("9. 0-1 Triangle Pattern");

        System.out.print("Enter pattern number: ");
        int choice = sc.nextInt();

        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        int m = n;

        if (choice == 1 || choice == 2) {
            System.out.print("Enter columns: ");
            m = sc.nextInt();
        }

        switch (choice) {
            case 1: // solid rectangle
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) System.out.print("*");
                    System.out.println();
                }
                break;

            case 2: // hollow rectangle
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (i==0 || i==n-1 || j==0 || j==m-1) System.out.print("*");
                        else System.out.print(" ");
                    }
                    System.out.println();
                }
                break;

            case 3: // right triangle
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) System.out.print("*");
                    System.out.println();
                }
                break;

            case 4: // inverted triangle
                for (int i = n; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) System.out.print("*");
                    System.out.println();
                }
                break;

            case 5: // rotated triangle
                for (int i = n; i >= 1; i--) {
                    for (int j = 1; j < i; j++) System.out.print(" ");
                    for (int j = 0; j <= n-i; j++) System.out.print("*");
                    System.out.println();
                }
                break;

            case 6: // number triangle increasing
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) System.out.print(j);
                    System.out.println();
                }
                break;

            case 7: // number triangle decreasing
                for (int i = n; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) System.out.print(j);
                    System.out.println();
                }
                break;

            case 8: // Floyd's triangle
                int number = 1;
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print(number + " ");
                        number++;
                    }
                    System.out.println();
                }
                break;

            case 9: // 0-1 triangle
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print((i+j)%2==0 ? "1 " : "0 ");
                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
