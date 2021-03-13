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
        System.out.println("Ladder Length : " + g.ladderLengthEfficient("hit", "cog", wordList));

        ArrayList<String> wordList2 = new ArrayList();
        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        System.out.println("Ladder Length : " + g.ladderLength("hit", "cog", wordList2));
        System.out.println("Ladder Length : " + g.ladderLengthEfficient("hit", "cog", wordList2));

        ArrayList<String> wordList3 = new ArrayList();
        wordList3.add("ymann");
        wordList3.add("yycrj");
        wordList3.add("oecij");
        wordList3.add("ymcnj");
        wordList3.add("yzcrj");
        wordList3.add("yycij");
        wordList3.add("xecij");
        wordList3.add("yecij");
        wordList3.add("ymanj");
        wordList3.add("yzcnj");
        wordList3.add("ymain");
        System.out.println("Ladder Length : " + g.ladderLength("ymain", "oecij", wordList3));
        System.out.println("Ladder Length : " + g.ladderLengthEfficient("ymain", "oecij", wordList3));

    }

    //one-directional BFS
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

    private int ladderLengthEfficient(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {      //By doing this search space reduces
                Set<String> temp;
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> newBeginSet = new HashSet<>();
            for (String word : beginSet) {
                List<String> neighbours = neighbours(word);
                for (String neigh : neighbours) {
                    if (endSet.contains(neigh)) return level + 1;
                    if (wordSet.contains(neigh)) {
                        wordSet.remove(neigh);
                        newBeginSet.add(neigh);
                    }
                }
            }
            beginSet = newBeginSet;
            level++;
        }
        return 0;
    }

    private List<String> neighbours(String word) {
        char[] curr_chars = word.toCharArray();
        List<String> allPossibleNeighbours = new ArrayList<>();
        for (int j = 0; j < curr_chars.length; j++) {          //"hit" > h , i , t
            char original_char = curr_chars[j];
            for (char c = 'a'; c <= 'z'; c++) {                  // for given position in [h]it --> try all a to z
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