package array_examples;

import java.util.HashMap;
import java.util.HashSet;

class TwoSumInNonSortedArray {
    public static void main(String[] args) {
        int[] res1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res1[0] + "," + res1[1]);
        int[] res2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(res2[0] + "," + res2[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (lookup.containsKey(complement)) {
                return new int[]{lookup.get(complement), i};
            }
            lookup.put(nums[i], i);
        }
        return null;
    }
}

