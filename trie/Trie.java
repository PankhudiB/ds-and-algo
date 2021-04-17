package trie;

public class Trie {
    private static final int ALPHABET_SIZE = 26;

    public Trie() {
        root = new TrieNode();
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("searchingWhenDictionaryEmpty"));

        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        for (String key : keys) {
            trie.insert(key);
        }

        System.out.println("Found the : " + trie.search("the"));
        System.out.println("Found these : " + trie.search("these"));
        System.out.println("Found their : " + trie.search("their"));
        System.out.println("Found thaw : " + trie.search("thaw"));
        trie.delete("the");
        System.out.println("Found the : " + trie.search("the"));

    }

    private void delete(String key) {
        TrieNode crawler = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = false;
    }

    private boolean search(String key) {
        TrieNode crawler = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (crawler.children[index] == null)
                return false;
            crawler = crawler.children[index];
        }
        return crawler != null && crawler.isEndOfWord;
    }

    private void insert(String key) {
        TrieNode crawler = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';

            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }

}
