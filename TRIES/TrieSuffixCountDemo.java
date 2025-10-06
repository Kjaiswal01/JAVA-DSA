package TRIES;

// ==============================
// Q4 - SUFFIX TRIE & COUNT NODES
// CONCEPT: Builds a Trie of all suffixes and counts total Trie nodes
// ==============================

class Node3 {
    Node3[] children = new Node3[26];
}

public class TrieSuffixCountDemo {
    static Node3 root;

    // Insert function
    public static void insert(String word) {
        Node3 curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node3();
            }
            curr = curr.children[idx];
        }
    }

    // Q4 Function: Build Trie from all suffixes
    public static void buildTrie(String str) {
        root = new Node3();
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }
    }

    // Q4 Function: Count total nodes
    public static int countNodes(Node3 root) {
        if (root == null)
            return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return 1 + count; // 1 for current node
    }

    // MAIN METHOD
    public static void main(String[] args) {
        String str = "ababa";
        buildTrie(str);
        int totalNodes = countNodes(root);
        System.out.println("Total Nodes in Suffix Trie: " + totalNodes);
        System.out.println("Distinct Substrings: " + (totalNodes - 1)); // formula
    }
}
