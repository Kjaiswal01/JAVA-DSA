// import java.util.HashSet;

// public class Recursion2 {

//     // Q1: Tower of Hanoi
//     // Move n disks from src to dest using helper
//     public static void towerOfHanoi(int n, String src, String helper, String dest) {
//         if (n == 1) { // base case: only 1 disk left
//             System.out.println("transfer disk " + n + " from " + src + " to " + dest);
//             return;
//         }
//         towerOfHanoi(n - 1, src, dest, helper); // move top n-1 from src to helper
//         System.out.println("transfer disk " + n + " from " + src + " to " + dest); // move nth disk to dest
//         towerOfHanoi(n - 1, helper, src, dest); // move n-1 from helper to dest
//     }

//     // Q2: Reverse a String recursively
//     public static String revString(String str) {
//         if (str.length() == 1) return str; // base case
//         char currChar = str.charAt(0);
//         String nextString = revString(str.substring(1));
//         return nextString + currChar; // add current char at end after recursion
//     }

//     // Q3: Find first and last occurrence of a char
//     public static int first = -1;
//     public static int last = -1;

//     public static void getIndices(String str, char el, int idx) {
//         if (idx == str.length()) return; // base case
//         if (str.charAt(idx) == el) {
//             if (first == -1) first = idx; // first time found
//             else last = idx; // keep updating last
//         }
//         getIndices(str, el, idx + 1); // check next
//     }

//     // Q4: Check if array is strictly increasing
//     public static boolean checkIfIncreasing(int arr[], int idx) {
//         if (idx == arr.length - 1) return true; // reached end
//         if (!checkIfIncreasing(arr, idx + 1)) return false; // check rest
//         return arr[idx] < arr[idx + 1]; // check current with next
//     }

//     // Q5: Move all 'x' to the end of string
//     public static String addX(int count) {
//         String newStr = "";
//         for (int i = 0; i < count; i++) newStr += 'x';
//         return newStr;
//     }

//     public static String moveAllX(String str, int idx, int count) {
//         if (idx == str.length()) return addX(count); // all processed
//         if (str.charAt(idx) == 'x') {
//             return moveAllX(str, idx + 1, count + 1); // skip but count x
//         } else {
//             String nextStr = moveAllX(str, idx + 1, count);
//             return str.charAt(idx) + nextStr; // build new string
//         }
//     }

//     // Q6: Remove duplicates in a string
//     public static String removeDuplicates(String str, int idx, boolean present[]) {
//         if (idx == str.length()) return ""; // base case
//         char curr = str.charAt(idx);
//         if (present[curr - 'a']) { // if already seen skip
//             return removeDuplicates(str, idx + 1, present);
//         } else {
//             present[curr - 'a'] = true; // mark seen
//             return curr + removeDuplicates(str, idx + 1, present); // add char + next recursion
//         }
//     }

//     // Q7: Print all subsequences of a string
//     public static void printSubseq(String str, int idx, String res) {
//         if (idx == str.length()) {
//             System.out.println(res);
//             return;
//         }
//         // choose current char
//         printSubseq(str, idx + 1, res + str.charAt(idx));
//         // don't choose current char
//         printSubseq(str, idx + 1, res);
//     }

//     // Q8: Print all unique subsequences
//     public static void printSubseq(String str, int idx, String res, HashSet<String> allSubseq) {
//         if (idx == str.length()) {
//             if (allSubseq.contains(res)) return; // skip duplicates
//             allSubseq.add(res);
//             System.out.println(res);
//             return;
//         }
//         printSubseq(str, idx + 1, res + str.charAt(idx), allSubseq); // choose
//         printSubseq(str, idx + 1, res, allSubseq); // don't choose
//     }

//     // Q9: Print keypad combinations
//     public static String keypad[] = {
//             ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

//     public static void printKeypadCombination(String number, int idx, String res) {
//         if (idx == number.length()) { // base case
//             System.out.println(res);
//             return;
//         }
//         String letters = keypad[number.charAt(idx) - '0'];
//         for (int i = 0; i < letters.length(); i++) {
//             char curr = letters.charAt(i);
//             printKeypadCombination(number, idx + 1, res + curr);
//         }
//     }

//     public static void main(String args[]) {

//         // Q1 Tower of Hanoi:
//         System.out.println("Q1 Tower of Hanoi:");
//         towerOfHanoi(3, "A", "B", "C");

//         // Q2 Reverse string:
//         System.out.println("\nQ2 Reverse String:");
//         System.out.println(revString("abcd"));

//         // Q3 First & Last occurrence:
//         System.out.println("\nQ3 First & Last Occurrence:");
//         String str = "tabcdfghijakkk";
//         char el = 'a';
//         first = -1; last = -1; // reset
//         getIndices(str, el, 0);
//         System.out.println("First occurrence : " + first);
//         System.out.println("Last occurrence : " + last);

//         // Q4 Check array increasing:
//         System.out.println("\nQ4 Check Array Increasing:");
//         int arr[] = {1, 2, 3, 4, 5};
//         System.out.println(checkIfIncreasing(arr, 0) ? "Strictly Increasing" : "NOT Strictly Increasing");

//         // Q5 Move all x to end:
//         System.out.println("\nQ5 Move All x:");
//         String strX = "abcdefxghxixjxxxk";
//         System.out.println(moveAllX(strX, 0, 0));

//         // Q6 Remove duplicates:
//         System.out.println("\nQ6 Remove Duplicates:");
//         String strDup = "abcadbcefghabi";
//         boolean present[] = new boolean[26]; // only 26 letters
//         System.out.println(removeDuplicates(strDup, 0, present));

//         // Q7 All subsequences:
//         System.out.println("\nQ7 All Subsequences:");
//         printSubseq("abc", 0, "");

//         // Q8 All unique subsequences:
//         System.out.println("\nQ8 Unique Subsequences:");
//         HashSet<String> allSubseq = new HashSet<>();
//         printSubseq("aaa", 0, "", allSubseq);

//         // Q9 Keypad combinations:
//         System.out.println("\nQ9 Keypad Combinations:");
//         printKeypadCombination("23", 0, "");
//     }
// }





// USER INPUT---------------------------

import java.util.HashSet;
import java.util.Scanner;

public class Recursion2 {

    // ---------- Q1: Tower of Hanoi ----------
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n - 1, helper, src, dest);
    }

    // ---------- Q2: Reverse a string ----------
    public static String revString(String str) {
        if (str.length() == 1) return str;
        char currChar = str.charAt(0);
        String nextString = revString(str.substring(1));
        return nextString + currChar;
    }

    // ---------- Q3: First & last occurrence ----------
    public static int first = -1, last = -1;
    public static void getIndices(String str, char el, int idx) {
        if (idx == str.length()) return;
        if (str.charAt(idx) == el) {
            if (first == -1) first = idx;
            else last = idx;
        }
        getIndices(str, el, idx + 1);
    }

    // ---------- Q4: Check if array strictly increasing ----------
    public static boolean checkIfIncreasing(int arr[], int idx) {
        if (idx == arr.length - 1) return true;
        if (!checkIfIncreasing(arr, idx + 1)) return false;
        return arr[idx] < arr[idx + 1];
    }

    // ---------- Q5: Move all 'x' to end ----------
    public static String addX(int count) {
        String newStr = "";
        for (int i = 0; i < count; i++) newStr += 'x';
        return newStr;
    }
    public static String moveAllX(String str, int idx, int count) {
        if (idx == str.length()) return addX(count);
        if (str.charAt(idx) == 'x') return moveAllX(str, idx + 1, count + 1);
        else return str.charAt(idx) + moveAllX(str, idx + 1, count);
    }

    // ---------- Q6: Remove duplicates ----------
    public static String removeDuplicates(String str, int idx, boolean present[]) {
        if (idx == str.length()) return "";
        char curr = str.charAt(idx);
        if (present[curr - 'a']) return removeDuplicates(str, idx + 1, present);
        else {
            present[curr - 'a'] = true;
            return curr + removeDuplicates(str, idx + 1, present);
        }
    }

    // ---------- Q7: All subsequences ----------
    public static void printSubseq(String str, int idx, String res) {
        if (idx == str.length()) {
            System.out.println(res);
            return;
        }
        printSubseq(str, idx + 1, res + str.charAt(idx));
        printSubseq(str, idx + 1, res);
    }

    // ---------- Q8: All unique subsequences ----------
    public static void printSubseq(String str, int idx, String res, HashSet<String> allSubseq) {
        if (idx == str.length()) {
            if (allSubseq.contains(res)) return;
            allSubseq.add(res);
            System.out.println(res);
            return;
        }
        printSubseq(str, idx + 1, res + str.charAt(idx), allSubseq);
        printSubseq(str, idx + 1, res, allSubseq);
    }

    // ---------- Q9: Keypad combinations ----------
    public static String keypad[] = {
            ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKeypadCombination(String number, int idx, String res) {
        if (idx == number.length()) {
            System.out.println(res);
            return;
        }
        String letters = keypad[number.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            char curr = letters.charAt(i);
            printKeypadCombination(number, idx + 1, res + curr);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter question number (1-9): ");
        int q = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (q) {
            case 1:
                System.out.print("Enter number of disks: ");
                int n = sc.nextInt();
                towerOfHanoi(n, "A", "B", "C");
                break;

            case 2:
                System.out.print("Enter string to reverse: ");
                String s = sc.nextLine();
                System.out.println(revString(s));
                break;

            case 3:
                System.out.print("Enter string: ");
                String str = sc.nextLine();
                System.out.print("Enter character to find: ");
                char el = sc.next().charAt(0);
                first = -1; last = -1;
                getIndices(str, el, 0);
                System.out.println("First occurrence : " + first);
                System.out.println("Last occurrence : " + last);
                break;

            case 4:
                System.out.print("Enter size of array: ");
                int size = sc.nextInt();
                int arr[] = new int[size];
                System.out.println("Enter array elements:");
                for (int i = 0; i < size; i++) arr[i] = sc.nextInt();
                System.out.println(checkIfIncreasing(arr, 0) ?
                        "Strictly Increasing" : "NOT Strictly Increasing");
                break;

            case 5:
                System.out.print("Enter string: ");
                String sx = sc.nextLine();
                System.out.println(moveAllX(sx, 0, 0));
                break;

            case 6:
                System.out.print("Enter string: ");
                String sd = sc.nextLine();
                boolean present[] = new boolean[26];
                System.out.println(removeDuplicates(sd, 0, present));
                break;

            case 7:
                System.out.print("Enter string: ");
                String ss = sc.nextLine();
                printSubseq(ss, 0, "");
                break;

            case 8:
                System.out.print("Enter string: ");
                String su = sc.nextLine();
                HashSet<String> allSubseq = new HashSet<>();
                printSubseq(su, 0, "", allSubseq);
                break;

            case 9:
                System.out.print("Enter digits: ");
                String number = sc.nextLine();
                printKeypadCombination(number, 0, "");
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
