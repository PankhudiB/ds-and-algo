package graph;

import util.Tuple;

import java.util.*;

class WordLadderUsingDictionary {
    public static void main(String[] args) {
        WordLadderUsingDictionary g = new WordLadderUsingDictionary();
        ArrayList<String> wordList = new ArrayList();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println("Ladder Length : " + g.ladderLength("hit", "cog", wordList));

        ArrayList<String> wordList2 = new ArrayList();
        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        System.out.println("Ladder Length : " + g.ladderLength("hit", "cog", wordList2));

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

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });
        System.out.println("allComboDict : " + allComboDict);
        // Queue for BFS
        Queue<Tuple<String, Integer>> Q = new LinkedList<>();
        Q.add(new Tuple(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Tuple<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    System.out.println("word: " + word + " adj : " + allComboDict.getOrDefault(newWord, new ArrayList<>()));
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Tuple(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}