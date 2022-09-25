package heap;

import java.util.*;

class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        System.out.println("Answer " + t.topKFrequentBruteForce(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    // build frequency map
    // sort the map -> descending order
    // TC -> O(NlogN) | SC -> map + sorting ds
    public int[] topKFrequentBruteForce(int[] nums, int k) {
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
    public int[] topKFrequent(int[] nums, int k) {
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

// using quickselect
// TC -> O(n) -----> becoz we are processing only 1 side of partition and discard the other
class TopKFrequentElementsUsingQuickSelect {

    public static void main(String[] args) {
        TopKFrequentElementsUsingQuickSelect t = new TopKFrequentElementsUsingQuickSelect();
        int k = 1;
        int[] topK = t.topKFrequent(new int[]{3, 0, 1, 0}, k);
        System.out.println("topK ");
        util.ArrayUtil.print(topK);
    }

    // maintain freq map
    // quickselect until you have right position for n-k th pivot
    // quick-select not quick-sort
    //      we want top k elements
    //      in ascending order array --> we just need to keep sorting elements in a way ..
    //      at position n-k --> every element to left are smaller (in our example -> their freq is smaller)
    //      at position n-k --> every element to right are greater (in our example -> their freq is larger)

    int[] unique;
    HashMap<Integer, Integer> count;

    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num : count.keySet()) {
            unique[i] = num;
            i++;
        }

        quickselect(0, n - 1, n - k);

        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void swap(int first, int second) {
        int temp = unique[first];
        unique[first] = unique[second];
        unique[second] = temp;
    }

    private void quickselect(int left, int right, int k_smallest) {
        // base condition of recursion
        if (left == right) return;

        // partition
        // random no generation logic here is
        // right-left --> bcoz quickselect is recursive for sub arrays --> small range
        // left + (somthing from range)
        // eg --> 1st iteration -> 0 + (range(5))
        // eg --> 2st iteration ->(just assuming) 2 + (range(1,2,3))

        int random_no = new Random().nextInt(right - left);
        int pivot_index = left + random_no;

        pivot_index = partition(left, right, pivot_index);

        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            quickselect(left, pivot_index - 1, k_smallest);
        } else {
            quickselect(pivot_index + 1, right, k_smallest);
        }

    }

    private int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);  // this is for our use case - we want to sort by freq

        //move pivot to end
        swap(pivot_index, right);
        int store_index = left;


        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final correct place
        swap(store_index, right);
        return store_index;
    }
}

