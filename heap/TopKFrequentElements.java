package heap;

import java.util.*;

class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println("Answer " + topKFrequentBruteForce(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    // build frequency map
    // sort the map -> descending order
    // TC -> O(NlogN) | SC -> map + sorting ds
    public static int[] topKFrequentBruteForce(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int freq = freqMap.getOrDefault(nums[i], 0);
            freqMap.put(nums[i], ++freq);
        }

        List<Map.Entry<Integer, Integer>> entriesList = new ArrayList<>(freqMap.entrySet());

        Collections.sort(entriesList, (n1, n2) -> n2.getValue() - n1.getValue());

        int i = 0;
        int[] topKElements = new int[k];
        for (Map.Entry<Integer, Integer> entry : entriesList) {
            if (i == k) break;
            topKElements[i] = entry.getKey();
            i++;
        }

        return topKElements;
    }

}

