import java.util.*;

public class StringBuilderMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial string: ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        while (true) {
            System.out.println("\nCurrent StringBuilder: " + sb);
            System.out.println("Choose operation:");
            System.out.println("1. Get Character at Index");
            System.out.println("2. Set Character at Index");
            System.out.println("3. Insert Character at Index");
            System.out.println("4. Delete Characters (start to end index)");
            System.out.println("5. Append String at End");
            System.out.println("6. Show Length");
            System.out.println("7. Reverse String");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            }

            switch (choice) {
                case 1: // Get Char
                    System.out.print("Enter index: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Character at index " + idx + ": " + sb.charAt(idx));
                    break;

                case 2: // Set Char
                    System.out.print("Enter index: ");
                    int sIdx = sc.nextInt();
                    System.out.print("Enter new character: ");
                    char nChar = sc.next().charAt(0);
                    sc.nextLine();
                    sb.setCharAt(sIdx, nChar);
                    System.out.println("After setCharAt: " + sb);
                    break;

                case 3: // Insert Char
                    System.out.print("Enter index to insert: ");
                    int iIdx = sc.nextInt();
                    System.out.print("Enter character to insert: ");
                    char iChar = sc.next().charAt(0);
                    sc.nextLine();
                    sb.insert(iIdx, iChar);
                    System.out.println("After insert: " + sb);
                    break;

                case 4: // Delete
                    System.out.print("Enter start index: ");
                    int dStart = sc.nextInt();
                    System.out.print("Enter end index (exclusive): ");
                    int dEnd = sc.nextInt();
                    sc.nextLine();
                    sb.delete(dStart, dEnd);
                    System.out.println("After delete: " + sb);
                    break;

                case 5: // Append
                    System.out.print("Enter string to append: ");
                    String aStr = sc.nextLine();
                    sb.append(aStr);
                    System.out.println("After append: " + sb);
                    break;

                case 6: // Length
                    System.out.println("Length of StringBuilder: " + sb.length());
                    break;

                case 7: // Reverse
                    for (int i = 0; i < sb.length() / 2; i++) {
                        int front = i;
                        int back = sb.length() - 1 - i;

                        char frontChar = sb.charAt(front);
                        char backChar = sb.charAt(back);

                        sb.setCharAt(front, backChar);
                        sb.setCharAt(back, frontChar);
                    }
                    System.out.println("After reverse: " + sb);
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }
}
