package TRIES;

// ==============================
// Q3 - LONGEST WORD IN TRIE
// CONCEPT: Finds the longest word in Trie where all prefixes exist
// ==============================

class Node2 {
    Node2[] children = new Node2[26];
    boolean eow = false;
}

public class TrieLongestWordDemo {
    static Node2 root = new Node2();
    public static String ans = "";

    // Insert function
    public static void insert(String word) {
        Node2 curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node2();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Q3 Function: Find Longest Word
    public static void longestWord(Node2 root, StringBuilder curr) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                curr.append((char) (i + 'a'));
                if (curr.length() > ans.length()) {
                    ans = curr.toString();
                }
                longestWord(root.children[i], curr);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (String w : words) {
            insert(w);
        }

        longestWord(root, new StringBuilder());
        System.out.println("Longest Word with all prefixes present: " + ans);
    }
}
