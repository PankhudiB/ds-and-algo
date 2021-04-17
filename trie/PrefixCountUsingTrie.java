package trie;

public class PrefixCountUsingTrie {
    private static final int ALPHABET_SIZE = 26;

    public PrefixCountUsingTrie() {
        root = new TrieNode();
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int prefixCount;
        boolean isEndOfWord;

        public TrieNode() {
            prefixCount = 0;
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public static void main(String[] args) {
        PrefixCountUsingTrie trie = new PrefixCountUsingTrie();
        String keys[] = {
                "aa",
                "aab",
                "aabc",
                "acb",
        };

        for (String key : keys) {
            trie.insert(key);
        }

        System.out.println("Prefix count : aa : " + trie.prefixCount("aa"));
        System.out.println("Prefix count : aab : " + trie.prefixCount("aab"));
        System.out.println("Prefix count : ak : " + trie.prefixCount("ak"));
    }

    private int prefixCount(String key) {
        TrieNode crawler = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (crawler.children[index] == null || crawler.children[index].prefixCount == 0) return 0;
            crawler = crawler.children[index];
        }
        return crawler.prefixCount;
    }

    private void insert(String key) {
        TrieNode crawler = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';

            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler.prefixCount++;
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
        crawler.prefixCount++;
    }
}
