package graph;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        WordLadder g = new WordLadder();
        ArrayList<String> wordList = new ArrayList();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println("Ladder Length : " + g.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr_word = queue.poll();
                if (curr_word.equals(endWord)) return level + 1;   //and see it has reached endWord
                List<String> neighbours = neighbours(curr_word);
                for (String neigh : neighbours) {
                    if (wordSet.contains(neigh)) {                // or see if it is one of the transformation
                        queue.add(neigh);
                        wordSet.remove(neigh);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> neighbours(String word) {
        char[] curr_chars = word.toCharArray();
        List<String> allPossibleNeighbours = new ArrayList<>();
        for (int j = 0; j < curr_chars.length; j++) {          //"hit" > h , i , t
            char original_char = curr_chars[j];
            for (char c = 'a'; c < 'z'; c++) {                  // for given position in [h]it --> try all a to z
                if (c == original_char) continue;
                curr_chars[j] = c;
                String newWord = new String(curr_chars);
                allPossibleNeighbours.add(newWord);
            }
            curr_chars[j] = original_char;         //retain the original word
        }
        return allPossibleNeighbours;
    }
}