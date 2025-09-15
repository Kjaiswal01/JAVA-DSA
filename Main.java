// public class Main {
//     public static void main(String[] args){
//         // variables
//         int a = 10;                // a ek integer variable hai jisme 10 store kiya
//         int b = 20;                // b ek integer variable hai jisme 20 store kiya

//         int sum = a + b;           // sum = a + b
//         System.out.println(sum);   // 10 + 20 = 30 print karega

//         int prod = a - b;          // prod = a - b
//         System.out.println(prod);  // 10 - 20 = -10 print karega

//         int mul = a * b;           // mul = a * b
//         System.out.println(mul);   // 10 * 20 = 200 print karega
//     }
// }



// Code 2 (Input Version)------------------------------------------
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);  // Scanner object banaya input lene ke liye

        Float a = sc.nextFloat();             // user se pehla float number read karo
        Float b = sc.nextFloat();             // user se doosra float number read karo

        Float sum = a + b;                    // sum = a + b (float addition)
        System.out.println(sum);              // result print karo
    }
}