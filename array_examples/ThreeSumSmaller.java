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

    // sort
    // then for each nums[i]
    //      apply binary search to find the largest index j such that nums[i] + nums[j] < targetnums[i]+nums[j]<target
    //      j−i pairs that satisfy for that -> i
    public class ThreeSumSmallerEfficient {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                System.out.println("main : i: " + i);
                sum += twoSumSmaller(nums, i + 1, target - nums[i]);
                System.out.println("------------------------");
            }
            return sum;
        }

        private int twoSumSmaller(int[] nums, int startIndex, int target) {
            System.out.println("startIndex :" + startIndex + " : " + nums[startIndex]);
            int sum = 0;
            for (int i = startIndex; i < nums.length - 1; i++) {
                int j = binarySearch(nums, i, target - nums[i]);
                System.out.println("found at: " + j + "=" + nums[j]);
                System.out.println("i :" + i);
                System.out.println("j-i : " + (j - i));
                sum += j - i;
            }
            return sum;
        }

        private int binarySearch(int[] nums, int startIndex, int target) {
            System.out.println("Searching :" + target + " | from :" + startIndex);
            int left = startIndex;
            int right = nums.length - 1;

            while (left < right) {
                System.out.println("--------start : " + left + " | end" + right);
                int mid = (left + right + 1) / 2;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}