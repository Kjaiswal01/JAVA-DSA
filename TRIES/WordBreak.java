package TRIES;

class TrieNode {
    TrieNode children[] = new TrieNode[26];
    boolean endOfWord = false;
}

public class WordBreak {
    static TrieNode root = new TrieNode();

    // Insert word into Trie
    public static void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    // Search word in Trie
    public static boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    // Word Break Function
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secPart = key.substring(i);
            if (search(firstPart) && wordBreak(secPart)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        String words[] = { "i", "like", "sam", "samsung", "mobile" };
        String key = "ilikesamsung"; // ---> true

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(wordBreak(key)); // Output: true
    }
}
