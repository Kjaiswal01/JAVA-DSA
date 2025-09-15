import java.util.Scanner;

public class Loops {
    public static void main (String args[]) {

        // ----------- For loop 0 to 10 -----------
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }

        // ----------- While loop 0 to 10 -----------
        int i = 0;
        while (i < 11) {
            System.out.println(i);
            i++;
        }

        // ----------- Do-While loop 0 to 11 -----------
        int j = 0;
        do {
            System.out.println(j);
            j = j + 1;
        } while (j < 12);

        // ----------- Sum of first n numbers -----------
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();  // user se n lena

        int sum = 0;
        for (int k = 0; k <= n; k++) {  // loop n tak chalega
            sum = sum + k;              // sum add karo
        }
        System.out.println("Sum of first " + n + " numbers = " + sum);

        // ----------- Table print karna (multiplication table) -----------
        System.out.print("Enter number for table: ");
        int number = sc.nextInt();  

        for (int m = 1; m <= 10; m++) {  // 1 se 10 tak chalega
            System.out.println(number + " * " + m + " = " + (number * m));
        }

        sc.close(); // scanner close kar do
    }
}



// Time Complexity:------------
// for loop → O(n)
// while loop → O(n)
// do-while loop → O(n)
// sum calculation → O(n)

// Space Complexity:----------------------
// Sabhi loops O(1) extra space lete hain.