package trie;

public class WordBreakProblem {
    private static final int ALPHABET_SIZE = 26;

    public WordBreakProblem() {
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
        WordBreakProblem trie = new WordBreakProblem();
        String dictionary[] = {"mobile", "samsung",
                "sam", "sung", "ma",
                "mango", "icecream",
                "and", "go", "i", "like",
                "ice", "cream"};

        int n = dictionary.length;
        TrieNode root = new TrieNode();

        // Construct trie
        for (int i = 0; i < n; i++)
            trie.insert(dictionary[i]);

        System.out.print(wordBreak("ilikesamsung") ?
                "Yes\n" : "No\n");
        System.out.print(wordBreak("iiiiiiii") ?
                "Yes\n" : "No\n");
        System.out.print(wordBreak("") ?
                "Yes\n" : "No\n");
        System.out.print(wordBreak("ilikelikeimangoiii") ?
                "Yes\n" : "No\n");
        System.out.print(wordBreak("samsungandmango") ?
                "Yes\n" : "No\n");
        System.out.print(wordBreak("samsungandmangok") ?
                "Yes\n" : "No\n");
    }

    private static boolean wordBreak(String sentence) {
        int size = sentence.length();
        if (size == 0) return true;
        for (int i = 1; i <= size; i++) {
            if (search(sentence.substring(0, i)) && wordBreak(sentence.substring(i, size))) {
                return true;
            }
        }
        return false;
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

    private static boolean search(String key) {
        TrieNode crawler = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (crawler.children[index] == null) return false;
            crawler = crawler.children[index];
        }
        return crawler != null && crawler.isEndOfWord;
    }
}
