package TRIES;

// ==============================
// Q2 - STARTS WITH PREFIX DEMO
// CONCEPT: Checks if any word starts with the given prefix using Trie
// ==============================

class Node {
    Node[] children = new Node[26];
    boolean eow = false; // end of word
}

public class TrieStartsWithDemo {
    static Node root = new Node();

    // Insert function
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Q2 Function: Check if prefix exists
    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        insert("apple");
        insert("app");
        insert("bat");
        insert("ball");

        System.out.println("Starts with 'app'? " + startsWith("app"));
        System.out.println("Starts with 'ba'? " + startsWith("ba"));
        System.out.println("Starts with 'cat'? " + startsWith("cat"));
    }
}
