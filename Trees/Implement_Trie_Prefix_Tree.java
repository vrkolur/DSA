package Trees;


// Check the LeetCode-208 for full problem explation and test cases.
class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (final char c : word.toCharArray()) {
            final int i = c - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    public TrieNode find(String prefix) {
        TrieNode node = root;
        for (final char c : prefix.toCharArray()) {
            final int i = c - 'a';
            if (node.children[i] == null)
                return null;
            node = node.children[i];
        }
        return node;
    }
}