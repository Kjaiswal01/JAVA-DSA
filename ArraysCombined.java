import java.util.*;

public class ArraysCombined {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 Input & print names
        System.out.print("Enter number of names: ");
        int nameCount = sc.nextInt();
        sc.nextLine(); // enter key ko consume karega
        String[] names = new String[nameCount];

        System.out.println("Enter " + nameCount + " names: ");
        for (int i = 0; i < nameCount; i++) {
            names[i] = sc.nextLine(); // poora line lega
        }

        System.out.println("\nNames you entered are:");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Name " + (i + 1) + " is : " + names[i]);
        }

        // 2 Input numbers
        System.out.print("\nEnter size of number array: ");
        int size = sc.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter " + size + " numbers: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }

        // 3 Find max & min
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("\nLargest number is : " + max);
        System.out.println("Smallest number is : " + min);

        // 4 Check if array sorted ascending
        boolean isAscending = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                isAscending = false;
                break;
            }
        }

        if (isAscending) {
            System.out.println("The array is sorted in ascending order");
        } else {
            System.out.println("The array is not sorted in ascending order");
        }

        // 5 Search x in numbers
        System.out.print("\nEnter number to search: ");
        int x = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x) {
                System.out.println("x found at index : " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("x not found");
        }

        sc.close();
    }
}
