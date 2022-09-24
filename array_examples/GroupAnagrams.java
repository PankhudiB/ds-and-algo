package array_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    // N -> no of words
    // K -> no of letters

    //for each word ->
    // sort the string -> sorted key becomes the key of map that you collect strings against
    // O(N*KlogK)
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            ArrayList<String> value = map.getOrDefault(sortedString, new ArrayList<>());
            value.add(str);
            map.put(sortedString, value);
        }

        return new ArrayList<>(map.values());
    }

    // for each word
    // count the alphabet count of the word -> create a key ->
    // eg dabb --> 1#2#0#1#0#0#....
    // use this key to collect against
    // O(N * K)
    public List<List<String>> groupAnagramsEfficient(String[] strs) {
        HashMap<String,ArrayList<String>> ans = new HashMap<String,ArrayList<String>>();
        int[] alphabetCount = new int[26];
        for(String str : strs) {
            Arrays.fill(alphabetCount,0);
            char[] charStr = str.toCharArray();
            for(int i=0; i < charStr.length; i++) {
                alphabetCount[charStr[i] - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i < 26; i++) {
                sb = sb.append(alphabetCount[i]);
                sb.append("#");
            }

            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key,new ArrayList());
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }
}

