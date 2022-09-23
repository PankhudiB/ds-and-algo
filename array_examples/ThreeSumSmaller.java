package array_examples;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[]{3, 1, 0, -2}, 4));
        System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            count += twoSumForAllPermutation(nums, i, newTarget);
        }
        return count;
    }

    private static int twoSumForAllPermutation(int[] nums, int ith, int target) {
        int start = ith + 1;
        int end = nums.length - 1;
        int count = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (nums[i] + nums[j] < target) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}