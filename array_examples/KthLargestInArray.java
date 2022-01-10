package array_examples;

import java.util.ArrayList;
import java.util.Collections;

class KthLargestInArray {
    public static void main(String[] args) {
        System.out.println("expected : 5 | got : " + kthLargestIncludingDuplicates(new int[]{3, 2, 1, 5, 6, 4}, 2) + " for : 3,2,1,5,6,4  k: 2");
        System.out.println("expected : 4 | got : " + kthLargestIncludingDuplicates(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) + " for : 3,2,3,1,2,4,5,5,6  k: 4");
    }

    public static int kthLargestIncludingDuplicates(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
            if (arr.size() > k) {
                arr.remove(Collections.min(arr));
            }
        }
        return Collections.min(arr);
    }
}