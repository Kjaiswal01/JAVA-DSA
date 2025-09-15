import java.util.*;
public class Conditions {
    public static void CheckEvenOdd(int num) {

        if (num % 2 ==0) {
            System.out.println(num + " is EVEN");
        } else {
            System.out.println(num + " is ODD");
        }
    }

    public static void CheckAdult(int age) {
        if (age > 18){
            System.out.println("is Adult");
        } else {
            System.out.println("is Not Adult");
        } 
    }

    public static void CheckGreaterLesser(int a ,int b){
        if (a==b) {
            System.out.println("Equal");
        } else if (a>b){
                System.out.println("a is greater");
            }
        else {
                System.out.println("a is lesser");
            }
    }

    // public static void Switch(int button){
    //     if (button == 1){
    //         System.out.println("Hello");
    //     }else if (button == 2){
    //         System.out.println("Namaste");
    //     }else if (button == 3){
    //         System.out.println("Bonjour");
    //     }else {
    //         System.out.println("Invalid Button....");
    //     }
    // }

    public static void Switchcase(int button) {
        switch(button){
            case 1 : System.out.println("Hello");
            break;
            case 2 : System.out.println("Namaste");
            break;
            case 3 : System.out.println("Bonjour");
            break;
            default : System.out.println("Invalid Button...");
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number :");
        int num = sc.nextInt();
        CheckEvenOdd(num);

        System.out.println("Enter age");
        int age = sc.nextInt();
        CheckAdult(age);

        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        CheckGreaterLesser(a,b);

        System.out.println("Enter a number between 1 to 3");
        int button = sc.nextInt();
        Switchcase(button);
    }
}



