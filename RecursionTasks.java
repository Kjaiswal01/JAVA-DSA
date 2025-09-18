import java.util.*;

public class RecursionTasks {

    // Q1: Print numbers from n down to 1
    public static void printNumbersDesc(int n) {
        if (n == 0) return;
        System.out.println(n);
        printNumbersDesc(n - 1);
    }

    // Q2: Print numbers from 1 up to n
    public static void printNumbersAsc(int n, int current) {
        if (current > n) return;
        System.out.println(current);
        printNumbersAsc(n, current + 1);
    }

    // Q3: Print sum of first n natural numbers
    public static void printSum(int n, int sum) {
        if (n == 0) {
            System.out.println("Sum = " + sum);
            return;
        }
        printSum(n - 1, sum + n);
    }

    // Q4: Print factorial of a number n
    public static void printFactorial(int n, int fact) {
        if (n == 0) {
            System.out.println("Factorial = " + fact);
            return;
        }
        printFactorial(n - 1, fact * n);
    }

    // Q5: Print Fibonacci sequence till n terms
    public static void printFibonacci(int a, int b, int n) {
        if (n == 0) return;
        System.out.println(a);
        printFibonacci(b, a + b, n - 1);
    }

    // Q6: Print x^n with stack height = n
    public static int powerLinear(int x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        return x * powerLinear(x, n - 1);
    }

    // Q7: Print x^n with stack height = log n (fast exponentiation)
    public static int powerFast(int x, int n) {
        if (n == 0) return 1;
        int half = powerFast(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a recursion task:");
        System.out.println("1 - Print numbers from n to 1");
        System.out.println("2 - Print numbers from 1 to n");
        System.out.println("3 - Sum of first n natural numbers");
        System.out.println("4 - Factorial of n");
        System.out.println("5 - Fibonacci sequence till n terms");
        System.out.println("6 - x^n (stack height = n)");
        System.out.println("7 - x^n (stack height = log n)");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter n: ");
                int n1 = sc.nextInt();
                printNumbersDesc(n1);
                break;

            case 2:
                System.out.print("Enter n: ");
                int n2 = sc.nextInt();
                printNumbersAsc(n2, 1);
                break;

            case 3:
                System.out.print("Enter n: ");
                int n3 = sc.nextInt();
                printSum(n3, 0);
                break;

            case 4:
                System.out.print("Enter n: ");
                int n4 = sc.nextInt();
                printFactorial(n4, 1);
                break;

            case 5:
                System.out.print("Enter number of terms n: ");
                int n5 = sc.nextInt();
                printFibonacci(0, 1, n5);
                break;

            case 6:
                System.out.print("Enter x: ");
                int x6 = sc.nextInt();
                System.out.print("Enter n: ");
                int n6 = sc.nextInt();
                System.out.println("x^n = " + powerLinear(x6, n6));
                break;

            case 7:
                System.out.print("Enter x: ");
                int x7 = sc.nextInt();
                System.out.print("Enter n: ");
                int n7 = sc.nextInt();
                System.out.println("x^n = " + powerFast(x7, n7));
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
