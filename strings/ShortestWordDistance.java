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

    public int shortestDistance2Pointer(String[] wordsDict, String word1, String word2) {
        int minDist = wordsDict.length;
        int word1Occurence = -1;
        int word2Occurence = -1;

        for(int i=0; i< wordsDict.length; i++){
            if(wordsDict[i].equals(word1)) {
                word1Occurence=i;
            }else if(wordsDict[i].equals(word2)){
                word2Occurence=i;
            }

            if(word1Occurence!=-1 && word2Occurence!=-1){
                minDist = Math.min(minDist,Math.abs(word1Occurence-word2Occurence));
            }
        }
        return minDist;
    }
}

