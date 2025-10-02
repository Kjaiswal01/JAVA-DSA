import java.util.*;

public class Functions {
    // method to calculate sum of 2 numbers -> a & b
    public static void sum(int a, int b) {
        int sum = a + b;
        System.out.println("Sum = " + sum);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static void printFactorial(int n) {
        if (n < 0) { // negative number invalid hai
            System.out.println("Invalid number");
            return;
        }
        int factorial = 1;
        for (int i = n; i >= 1; i--) {
            factorial = factorial * i;
        }
        System.out.println("Factorial = " + factorial);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input lete hain
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Sum print
        sum(a, b);

        // Multiply return
        int result = multiply(a, b);
        System.out.println("Multiplication = " + result);

        System.out.print("Enter number for factorial: ");
        int n = sc.nextInt();

        // factorial
        printFactorial(n);
    }
}
