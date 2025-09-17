import java.util.*;

public class StringMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        while (true) {
            System.out.println("\nCurrent String: " + str);
            System.out.println("Choose operation:");
            System.out.println("1. Declare / Input new String");
            System.out.println("2. Concatenate 2 Strings");
            System.out.println("3. Print Length");
            System.out.println("4. Access Characters");
            System.out.println("5. Compare 2 Strings");
            System.out.println("6. Substring");
            System.out.println("7. Convert String to int (ParseInt)");
            System.out.println("8. Convert int to String (ToString)");
            System.out.println("9. Replace 'e' with 'i'");
            System.out.println("10. Extract username from Email");
            System.out.println("11. Cumulative length of string array");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter new string: ");
                    str = sc.nextLine();
                    break;

                case 2:
                    System.out.print("Enter first string: ");
                    String first = sc.nextLine();
                    System.out.print("Enter second string: ");
                    String second = sc.nextLine();
                    str = first + second;
                    System.out.println("Concatenated String: " + str);
                    break;

                case 3:
                    System.out.println("Length of string: " + str.length());
                    break;

                case 4:
                    System.out.println("Characters of string:");
                    for (int i = 0; i < str.length(); i++) {
                        System.out.println(str.charAt(i));
                    }
                    break;

                case 5:
                    System.out.print("Enter another string to compare: ");
                    String compareStr = sc.nextLine();
                    if (str.equals(compareStr)) {
                        System.out.println("They are the same string.");
                    } else {
                        System.out.println("They are different strings.");
                    }
                    break;

                case 6:
                    System.out.print("Enter start index for substring: ");
                    int start = sc.nextInt();
                    System.out.print("Enter end index for substring: ");
                    int end = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Substring: " + str.substring(start, end));
                    break;

                case 7:
                    try {
                        int num = Integer.parseInt(str);
                        System.out.println("Converted to int: " + num);
                    } catch (NumberFormatException e) {
                        System.out.println("Cannot convert to int. Invalid number string.");
                    }
                    break;

                case 8:
                    System.out.print("Enter integer to convert to string: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    str = Integer.toString(number);
                    System.out.println("Converted to String: " + str);
                    break;

                case 9:
                    String result = "";
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == 'e') {
                            result += 'i';
                        } else {
                            result += str.charAt(i);
                        }
                    }
                    System.out.println("After replacing 'e' with 'i': " + result);
                    break;

                case 10:
                    String username = "";
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '@') break;
                        username += str.charAt(i);
                    }
                    System.out.println("Username from email: " + username);
                    break;

                case 11:
                    System.out.print("Enter size of string array: ");
                    int size = sc.nextInt();
                    sc.nextLine();
                    String[] arr = new String[size];
                    int totalLength = 0;
                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter string " + (i + 1) + ": ");
                        arr[i] = sc.nextLine();
                        totalLength += arr[i].length();
                    }
                    System.out.println("Cumulative length of all strings: " + totalLength);
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }
}
