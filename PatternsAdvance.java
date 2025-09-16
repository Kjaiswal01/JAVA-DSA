import java.util.*;

public class PatternsAdvance {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Pattern (10-12 + Advanced):");
        System.out.println("10. Solid Rhombus");
        System.out.println("11. Number Pyramid");
        System.out.println("12. Palindromic Number Pyramid");
        System.out.println("13. Diamond / Hourglass Pattern");
        System.out.println("14. Pyramid + Inverted Pyramid");

        System.out.print("Enter pattern number: ");
        int choice = sc.nextInt();

        System.out.print("Enter rows: ");
        int n = sc.nextInt();

        switch (choice) {
            case 10: // Solid Rhombus
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n-i; j++) System.out.print(" ");
                    for (int j = 1; j <= n; j++) System.out.print("*");
                    System.out.println();
                }
                break;

            case 11: // Number Pyramid
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n-i; j++) System.out.print(" ");
                    for (int j = 1; j <= i; j++) System.out.print(i + " ");
                    System.out.println();
                }
                break;

            case 12: // Palindromic Number Pyramid
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n-i; j++) System.out.print(" ");
                    for (int j = i; j >= 1; j--) System.out.print(j);
                    for (int j = 2; j <= i; j++) System.out.print(j);
                    System.out.println();
                }
                break;

            case 13: // Diamond / Hourglass
                // Upper half
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=n-i;j++) System.out.print(" ");
                    for(int j=1;j<=2*i-1;j++) System.out.print("*");
                    System.out.println();
                }
                // Lower half
                for(int i=n;i>=1;i--){
                    for(int j=1;j<=n-i;j++) System.out.print(" ");
                    for(int j=1;j<=2*i-1;j++) System.out.print("*");
                    System.out.println();
                }
                break;

            case 14: // Pyramid + Inverted Pyramid with spaces
                // Upper half
                for (int i=1; i<=n; i++) {
                    for (int j = 1; j<=i; j++) System.out.print("*");
                    int spaces = 2 * (n-i);
                    for (int j=1; j<=spaces; j++) System.out.print(" ");
                    for (int j=1; j<=i; j++) System.out.print("*");
                    System.out.println();
                }
                // Lower half
                for (int i=n; i>=1; i--) {
                    for (int j = 1; j<=i; j++) System.out.print("*");
                    int spaces = 2 * (n-i);
                    for (int j=1; j<=spaces; j++) System.out.print(" ");
                    for (int j=1; j<=i; j++) System.out.print("*");
                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
