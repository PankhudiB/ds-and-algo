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

    // build freq map
    // maintain min heap of k elements
    // insert map entries to min heap
    // TC -> O(N log K) | SC -> O(N + k) --> for map + heap
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int freq = freqMap.getOrDefault(nums[i], 0);
            freqMap.put(nums[i], ++freq);
        }

        //Alternative of (n1, n2) -> freqMap.get(n1) - freqMap.get(n2) ---> Comparator.comparingInt(freqMap::get)
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));

        for (int n : freqMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        int[] topKElements = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topKElements[i] = heap.poll();
        }
        return topKElements;
    }
}

