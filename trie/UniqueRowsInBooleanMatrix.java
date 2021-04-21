package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueRowsInBooleanMatrix {
    private static final int noOfChildren = 2;

    public UniqueRowsInBooleanMatrix() {
        root = new TrieNode();
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[noOfChildren];
        boolean isEndOfWord;
        int rowIndex;

        public TrieNode() {
            rowIndex = 0;
            isEndOfWord = false;
            for (int i = 0; i < noOfChildren; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public static void main(String[] args) {
        UniqueRowsInBooleanMatrix trie = new UniqueRowsInBooleanMatrix();
        int[][] matrix = {{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}};
        ArrayList<List<Integer>> uniqueRows = trie.uniqueRows(matrix, 3, 4);
        System.out.println(uniqueRows);
    }

    private ArrayList<List<Integer>> uniqueRows(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            insert(matrix[row], row);
        }
        ArrayList<List<Integer>> uniqueRows = new ArrayList<>();
        traverseTrie(root, matrix, uniqueRows);
        return uniqueRows;
    }

    static void insert(int[] row, int rowIndex) {
        TrieNode crawler = root;

        for (int i = 0; i < row.length; i++) {
            if (crawler.children[row[i]] == null) {
                crawler.children[row[i]] = new TrieNode();
            }
            crawler = crawler.children[row[i]];
        }
        crawler.rowIndex = rowIndex;
        crawler.isEndOfWord = true;
    }

    static void traverseTrie(TrieNode root, int[][] matrix, ArrayList<List<Integer>> result) {
        if (root.isEndOfWord) {
            result.add(Arrays.stream(matrix[root.rowIndex]).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < noOfChildren; i++) {
            if (root.children[i] != null) {
                traverseTrie(root.children[i], matrix, result);
            }
        }
    }
}
