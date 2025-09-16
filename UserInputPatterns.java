import java.util.*;

public class UserInputPatterns {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // 1. Print all even numbers till n
        System.out.print("Enter n to print even numbers: ");
        int n = sc.nextInt();
        System.out.println("Even numbers till " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        // 2. Marks Menu Driven
        int input;
        do {
            System.out.print("Enter marks (0-100): ");
            int marks = sc.nextInt();
            if (marks >= 90 && marks <= 100) {
                System.out.println("This is Good");
            } else if (marks >= 60 && marks <= 89) {
                System.out.println("This is also Good");
            } else if (marks >= 0 && marks <= 59) {
                System.out.println("This is Good as well");
            } else {
                System.out.println("Invalid marks");
            }

            System.out.println("Want to continue? yes(1) or no(0):");
            input = sc.nextInt();

        } while (input == 1);

        // 3. Check prime
        System.out.print("Enter number to check prime: ");
        int num = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            if (num == 1) {
                System.out.println("This is neither prime nor composite");
            } else {
                System.out.println(num + " is a prime number");
            }
        } else {
            System.out.println(num + " is not a prime number");
        }

        sc.close();
    }
}
