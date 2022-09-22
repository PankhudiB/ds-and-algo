package array_examples;

import java.util.HashMap;

class TwoSumInSortedArray {
    public static void main(String[] args) {
        int[] res1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res1[0] + "," + res1[1]);
        int[] res2 = twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(res2[0] + "," + res2[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int pairSum = nums[start] + nums[end];
            if (pairSum == target) {
                return new int[]{start, end};
            } else if (pairSum < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }
}

