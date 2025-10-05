// Trie Implementation (Insert, Search, StartsWith)
package TRIES;

public class TrieImplement {
    // -----------------------------
    // Node class (structure of Trie)
    // -----------------------------
    static class Node {
        Node[] children = new Node[26];
        boolean eow; // end of word

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // Root node of the Trie
    public static Node root = new Node();

    // -----------------------------
    // INSERT FUNCTION
    // -----------------------------
    public static void insert(String word) { // O(n)
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a'; // convert char to index (0–25)
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // mark end of word
    }

    // -----------------------------
    // SEARCH FUNCTION
    // -----------------------------
    public static boolean search(String key) { // O(n)
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    // -----------------------------
    // STARTSWITH FUNCTION (Prefix check)
    // -----------------------------
    public static boolean startsWith(String prefix) { // O(n)
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

    // -----------------------------
    // MAIN FUNCTION
    // -----------------------------
    public static void main(String args[]) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };

        // Insert words into Trie
        for (String word : words) {
            insert(word);
            System.out.println("Inserted: " + word);
        }

        // Searching
        System.out.println("\nSearch Results:");
        System.out.println("thee -> " + search("thee")); // true
        System.out.println("thor -> " + search("thor")); // false

        // Prefix Checking
        System.out.println("\nPrefix Results:");
        System.out.println("Prefix 'the' -> " + startsWith("the")); // true
        System.out.println("Prefix 'thi' -> " + startsWith("thi")); // false
    }
}
