package strings;

import java.util.Scanner;

class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDist = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                for (int j = 0; j < wordsDict.length; j++) {
                    if (wordsDict[j].equals(word2)) {
                        minDist = Math.min(minDist, Math.abs(i - j));
                    }
                }
            }
        }
        return minDist;
    }
}

